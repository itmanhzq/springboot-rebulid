package com.fenlibao.pms.service.system.impl;

import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.dto.req.system.AddPermissionReq;
import com.fenlibao.pms.exception.BizException;
import com.fenlibao.pms.mapper.system.PermissionDao;
import com.fenlibao.pms.mapper.system.RolePermissionDao;
import com.fenlibao.pms.model.bo.idmt.PermissionBO;
import com.fenlibao.pms.model.bo.idmt.RoleBO;
import com.fenlibao.pms.model.bo.idmt.RolePermissionBO;
import com.fenlibao.pms.model.bo.idmt.UserRoleBO;
import com.fenlibao.pms.model.convert.PermissionConvert;
import com.fenlibao.pms.model.convert.RolePermissionConvert;
import com.fenlibao.pms.model.po.idmt.PermissionPO;
import com.fenlibao.pms.model.po.idmt.RolePermissionPO;
import com.fenlibao.pms.service.system.PermissionService;
import com.fenlibao.pms.service.system.UserRoleService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.*;


/**
 * @author chen
 * @date 2018-11-26
 */
@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Autowired
    RolePermissionDao systemRolePermissionDao;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public List<PermissionPO> getMenuByType(Integer userId) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("userId", userId);
        params.put("component", "Home");
        List<PermissionPO> permissionPOs = permissionDao.getMenuByType(params);
        if (permissionPOs != null && !permissionPOs.isEmpty()) {
            for (PermissionPO permissionPO : permissionPOs) {
                recursionMenu(permissionPO, userId);
            }
        }
        return permissionPOs;
    }

    public void recursionMenu(PermissionPO permissionPO, Integer userId) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("userId", userId);
        params.put("parentId", permissionPO.getId());
        params.put("type", "menu");
        List<PermissionPO> children = permissionDao.getMenuByType(params);
        permissionPO.setChildren(children);
        for (PermissionPO permission : children) {
            recursionMenu(permission, userId);
        }
    }

    @Override
    public PermissionBO getPermissionList() {
        Example example = Example.builder(PermissionPO.class).where(Sqls.custom().andEqualTo("pid", 0)).build();
        PermissionPO permissionPO = permissionDao.selectOneByExample(example);
        if (permissionPO != null) {
            //递归子集
            recursionOrganization(permissionPO);

            PermissionBO permissionBO = new PermissionBO();
            BeanUtils.copyProperties(permissionPO, permissionBO);
            return permissionBO;
        }
        return null;
    }

    @Override
    public PermissionBO getPermissionListByRoleId(UserRoleBO userRoleBO) {
        Example example = Example.builder(PermissionPO.class).build();
        example.setOrderByClause("parent_id,sort");
        List<PermissionPO> permissionPOS = permissionDao.selectByExample(example);
        PermissionBO root = PermissionBO.builder().build();
        if (Objects.nonNull(permissionPOS) && !permissionPOS.isEmpty()) {
            // 获取第一个权限
            root = PermissionConvert.poConvertBO(permissionPOS.get(0));

            // 初始化权限集合
            List<PermissionBO> permissionBOS = configurationPermissions(userRoleBO, permissionPOS);
            // 递归添加子集
            buildPermissionAndChild(root, permissionBOS);
        }
        return root;
    }

    /**
     * 初始化权限集合
     *
     * @param userRoleBO    用户角色信息
     * @param permissionPOS 权限信息
     * @return List
     */
    private List<PermissionBO> configurationPermissions(UserRoleBO userRoleBO, List<PermissionPO> permissionPOS) {
        List<RolePermissionBO> rolePermissionBOS = new ArrayList<>();
        // 获取当前用户的所有权限
        RoleBO userRoleInfo = userRoleService.findUserRoleInfo(userRoleBO.getUserId());
        boolean notNullAndNotAdmin = Objects.nonNull(userRoleBO.getRole()) &&
                Objects.nonNull(userRoleBO.getRole().getParentId()) &&
                !userRoleBO.getRole().getParentId().equals(0);
        if (notNullAndNotAdmin) {
            // 如果，不是root用户将获取这个角色的权限
            List<RolePermissionPO> rolePermissionPOS = systemRolePermissionDao.selectByRoleId(userRoleBO.getRole().getId());
            for (RolePermissionPO rolePermissionPO : rolePermissionPOS) {
                rolePermissionBOS.add(RolePermissionConvert.poConvertBO(rolePermissionPO));
            }
        } else {
            rolePermissionBOS = userRoleInfo.getRolePermission();
        }

        List<Integer> userPermissionIds = new ArrayList<>();
        // 角色的所有权限
        if (Objects.nonNull(rolePermissionBOS)) {
            rolePermissionBOS.forEach(permissionBO -> {
                boolean notNull = Objects.nonNull(permissionBO.getPermission()) && Objects.nonNull(permissionBO.getPermission().getId());
                if (notNull) {
                    userPermissionIds.add(permissionBO.getPermission().getId());
                }
            });
        }
        // 将权限PO转换为BO
        List<PermissionBO> permissionBOS = new ArrayList<>();
        permissionPOS.forEach(permissionPO -> permissionBOS.add(PermissionConvert.poConvertBO(permissionPO)));

        setPermissionChecked(userPermissionIds, permissionBOS);
        return permissionBOS;
    }

    private void setPermissionChecked(List<Integer> userPermissionIds, List<PermissionBO> permissionBOS) {
        for (PermissionBO permissionBO : permissionBOS) {
            // 将角色有的拥有的权限设为true
            boolean contains = userPermissionIds.contains(permissionBO.getId());
            permissionBO.setChecked(false);
            if (contains) {
                permissionBO.setChecked(true);
            }
        }
    }

    /**
     * 递归添加子集
     *
     * @param root          父级
     * @param permissionBOS 子集
     */
    private void buildPermissionAndChild(PermissionBO root, List<PermissionBO> permissionBOS) {
        List<PermissionBO> children = (List<PermissionBO>) root.getChildren();
        if (children == null) {
            children = new ArrayList<>();
        }

        root.setChildren(children);
        for (PermissionBO permissionBO : permissionBOS) {
            if (root.getId().equals(permissionBO.getPid())) {
                children.add(permissionBO);
                buildPermissionAndChild(permissionBO, permissionBOS);
            }
        }
    }

    /**
     * 递归
     *
     * @param permissionPO
     */
    public void recursionOrganization(PermissionPO permissionPO) {
        Example example = Example.builder(PermissionPO.class).where(Sqls.custom().andEqualTo("pid", permissionPO.getId())).build();
        List<PermissionPO> childrenList = permissionDao.selectByExample(example);
        permissionPO.setChildren(childrenList);
        for (PermissionPO permission : childrenList) {
            recursionOrganization(permission);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addOrUpdatePermission(AddPermissionReq req) {
        if (!StringUtil.isEmpty(req.getId())) {
            //更新
            PermissionPO permissionPO = permissionDao.selectByPrimaryKey(req.getId());
            permissionPO.setName(req.getName());
            permissionPO.setDescription(req.getMarks());
            permissionPO.setCode(req.getCode());
            permissionPO.setSort(Integer.valueOf(req.getOrderId()));
            permissionPO.setPath(req.getPath());
            permissionPO.setType(req.getType());
            permissionPO.setComponent(req.getComponent());
            permissionPO.setIcon(req.getIcon());
            permissionDao.updateByPrimaryKey(permissionPO);
        } else {
            //添加
            Example example = Example.builder(PermissionPO.class).where(Sqls.custom().andEqualTo("code", req.getCode())).build();
            int count = permissionDao.selectCountByExample(example);
            if (count > 0) {
                throw new BizException(ResponseStatus.SYSTEM_PERMISSION_ALREADY_EXIST);
            }
            PermissionPO permissionPO = new PermissionPO();
            permissionPO.setName(req.getName());
            permissionPO.setCode(req.getCode());
            permissionPO.setDescription(req.getMarks());
            permissionPO.setPath(req.getPath());
            permissionPO.setCreateTime(new Date());
            permissionPO.setSort(Integer.valueOf(req.getOrderId()));
            permissionPO.setType(req.getType());
            permissionPO.setComponent(req.getComponent());
            permissionPO.setPid(Integer.valueOf(req.getParentId()));
            permissionPO.setIcon(req.getIcon());
            permissionDao.insert(permissionPO);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deletePermission(Integer id) {
        PermissionPO permissionPO = permissionDao.selectByPrimaryKey(id);
        if (permissionPO == null) {
            throw new BizException(ResponseStatus.COMMON_OPERATION_SUCCESS);
        }
        permissionDao.deleteByPrimaryKey(id);
        Example example = Example.builder(RolePermissionPO.class).where(Sqls.custom().andEqualTo("permissionId", id)).build();
        systemRolePermissionDao.deleteByExample(example);
    }
}
