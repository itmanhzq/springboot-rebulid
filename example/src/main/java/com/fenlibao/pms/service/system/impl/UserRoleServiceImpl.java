package com.fenlibao.pms.service.system.impl;

import cn.hutool.core.date.DateUtil;
import com.fenlibao.pms.dto.req.system.UserRoleReq;
import com.fenlibao.pms.mapper.system.UserRoleDao;
import com.fenlibao.pms.model.bo.idmt.RoleBO;
import com.fenlibao.pms.model.convert.RoleConvert;
import com.fenlibao.pms.model.po.idmt.RolePO;
import com.fenlibao.pms.model.po.idmt.UserRolePO;
import com.fenlibao.pms.service.system.RoleService;
import com.fenlibao.pms.service.system.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.*;

/**
 * 用户角色业务处理层实现
 *
 * @author LeiXinXin
 * @date 2018/12/7
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleService roleService;

    @Override
    public List<UserRolePO> listUserRoleByUserId(Integer userId) {
        return userRoleDao.listUserRoleByUserId(userId);
    }

    @Override
    public RoleBO findUserRoleInfo(Integer userId) {
        List<UserRolePO> userRolePOS = this.listUserRoleByUserId(userId);
        RoleBO root = RoleBO.builder().build();
        if (Objects.nonNull(userRolePOS) && !userRolePOS.isEmpty()) {
            UserRolePO userRolePO = userRolePOS.get(0);
            root = RoleConvert.poConvertBO(userRolePO.getRole());
            List<RolePO> rolePOS = roleService.listRoles();
            List<RoleBO> roleBOS = new ArrayList<>();
            for (RolePO rolePO : rolePOS) {
                RoleBO roleBO = RoleConvert.poConvertBO(rolePO);
                roleBOS.add(roleBO);
            }
            buildRoleAndChild(root, roleBOS);
        }
        return root;
    }

    /**
     * 将角色组装成树形
     *
     * @param parent  父级
     * @param roleBOS 角色集合
     */
    @Override
    public void buildRoleAndChild(RoleBO parent, List<RoleBO> roleBOS) {
        List<RoleBO> children = parent.getChildren();
        Integer id = parent.getId();
        if (children == null) {
            children = new ArrayList<>();
        }
        parent.setChildren(children);
        for (RoleBO roleBO : roleBOS) {
            Integer childrenId = roleBO.getParentId();
            if (id.equals(childrenId)) {
                children.add(roleBO);
                buildRoleAndChild(roleBO, roleBOS);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUserRoleByUserId(UserRoleReq userRoleReq) {
        boolean result = true;
        boolean saveUserRole = true;
        boolean notNull = Objects.nonNull(userRoleReq.getRoleIds()) && !userRoleReq.getRoleIds().isEmpty();
        if (notNull) {
            // 获取这个用户的所有角色
            List<UserRolePO> userRolePOS = this.listUserRoleByUserId(userRoleReq.getTargetUserId());
            Set<Integer> notRemoveRoleId = new HashSet<>(16);
            List<Integer> roleIds = userRoleReq.getRoleIds();
            // 筛选出那些不需要移除的角色ID(遍历用户角色集合，判断这个用户角色ID是否一致，如果一致则表示不需要将这些角色移除)
            roleIds.forEach(roleId ->
                    userRolePOS.forEach(userRolePO -> {
                        if (userRolePO.getRoleId().equals(roleId)) {
                            notRemoveRoleId.add(roleId);
                        }
                    })
            );

            // 移除角色
            result = removeUserRole(userRoleReq, notRemoveRoleId);

            // 保存新增的角色
            List<UserRolePO> saveUserRoleList = new ArrayList<>();
            userRoleReq.getRoleIds()
                    .stream()
                    // 过滤掉不需要保存的角色Id（如果，这些角色已经存在了，就不需要进行保存了，所以需要筛选出这个用户新增的角色Id）
                    .filter(roleId -> !notRemoveRoleId.contains(roleId))
                    // 组装用户角色信息
                    .forEach(roleId -> saveUserRoleList.add(UserRolePO.builder()
                            .userId(userRoleReq.getTargetUserId())
                            .roleId(roleId)
                            .build()));
            if (!saveUserRoleList.isEmpty()) {
                saveUserRole = userRoleDao.insertList(saveUserRoleList) > 0;
            }
        }


        return result && saveUserRole;
    }

    private boolean removeUserRole(UserRoleReq userRoleReq, Set<Integer> notRemoveRoleId) {
        Example removeUserRoleExample = Example.builder(UserRolePO.class)
                .where(Sqls.custom()
                        .andEqualTo("userId", userRoleReq.getTargetUserId()))
                .build();
        if (notRemoveRoleId.isEmpty()) {
            // 移除用户的所有角色
            return userRoleDao.deleteByExample(removeUserRoleExample) > 0;
        } else {
            // 移除已取消的角色
            removeUserRoleExample
                    .and(removeUserRoleExample.createCriteria()
                            .andNotIn("roleId", notRemoveRoleId));
            return userRoleDao.deleteByExample(removeUserRoleExample) > 0;
        }
    }
}
