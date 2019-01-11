package com.fenlibao.pms.service.system.impl;

import cn.hutool.core.date.DateUtil;
import com.fenlibao.pms.mapper.system.RoleMapper;
import com.fenlibao.pms.mapper.system.RolePermissionMapper;
import com.fenlibao.pms.mapper.system.UserRoleMapper;
import com.fenlibao.pms.service.system.RoleService;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.exception.BizException;
import com.fenlibao.pms.model.po.idmt.RolePO;
import com.fenlibao.pms.model.po.idmt.RolePermissionPO;
import com.fenlibao.pms.model.po.idmt.UserRolePO;
import com.fenlibao.pms.dto.req.system.RoleMoveReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 角色业务处理层实现
 *
 * @author LeiXinXin
 * @date 2018/11/26
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper systemRoleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveRole(RolePO rolePO) {
        rolePO.setCreateTime(DateUtil.date());
        boolean saveRoleResult = systemRoleMapper.insert(rolePO) > 0;
        if (saveRoleResult) {
            return true;
        } else {
            throw new BizException(ResponseStatus.COMMON_UPDATE_ERROR);
        }
    }

    @Override
    public List<RolePO> listRoles() {
        return systemRoleMapper.listRoles();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateRoleAndPermission(RolePO rolePO) {
        if (Objects.isNull(rolePO.getId())) {
            log.warn("角色ID为NULL");
            return false;
        }
        if (Objects.isNull(rolePO.getRolePermission())) {
            log.warn("角色权限为NULL");
            return false;
        }
        boolean updateRoleResult = systemRoleMapper.updateRoleByRoleId(rolePO) > 0;
        List<RolePermissionPO> saveRolePermissionPOS = configurationPermission(rolePO);

        boolean saveRolePermissionResult = true;
        if (!saveRolePermissionPOS.isEmpty()) {
            saveRolePermissionResult = rolePermissionMapper.insertList(saveRolePermissionPOS) > 0;
        }

        if (updateRoleResult && saveRolePermissionResult) {
            return true;
        } else {
            throw new BizException(ResponseStatus.COMMON_UPDATE_ERROR);
        }
    }

    /**
     * 初始化配置需要更新的权限以及角色信息
     *
     * @param rolePO 角色信息
     * @return List
     */
    private List<RolePermissionPO> configurationPermission(RolePO rolePO) {
        // 查询这个角色所有的权限信息
        RolePO role = systemRoleMapper.selectRoleByRoleId(rolePO.getId());
        Set<Integer> notRemoveRolePermissionIdSet = new HashSet<>(16);
        rolePO.getRolePermission()
                .forEach(permissionPO -> role.getRolePermission()
                        .forEach(rolePermissionPO -> {
                            if (permissionPO.getPermissionId()
                                    .equals(rolePermissionPO.getPermissionId())) {
                                notRemoveRolePermissionIdSet.add(rolePermissionPO.getPermissionId());
                            }
                        }));

        // 更新该角色相关的权限
        Example rolePermissionExample = Example.builder(RolePermissionPO.class)
                .where(Sqls.custom().andEqualTo("roleId", role.getId()))
                .build();
        if (notRemoveRolePermissionIdSet.isEmpty()) {
            // 移除该角色所有的权限
            rolePermissionMapper.deleteByExample(rolePermissionExample);
        } else {
            // 移除，已经取消了的权限
            rolePermissionExample.and(rolePermissionExample.createCriteria()
                    .andNotIn("permissionId", notRemoveRolePermissionIdSet));
            rolePermissionMapper.deleteByExample(rolePermissionExample);
        }

        // 获取需要保存的权限集合
        List<RolePermissionPO> rolePermissionPOS = rolePO.getRolePermission()
                .stream()
                // 过滤掉不需要保存的权限信息
                .filter(rolePermissionPO -> !notRemoveRolePermissionIdSet.contains(rolePermissionPO.getPermissionId()))
                .collect(Collectors.toList());
        rolePermissionPOS.forEach(rolePermissionPO -> {
            rolePermissionPO.setRoleId(rolePO.getId());
            rolePermissionPO.setCreateTime(DateUtil.date());
        });
        return rolePermissionPOS;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeRoleById(Integer roleId) {
        if (roleId == null) {
            return false;
        }
        // 先删除用户对应的角色
        boolean userRoleRemoveResult = true;
        if (userRoleMapper.selectCount(UserRolePO.builder().roleId(roleId).build()) > 0) {
            userRoleRemoveResult = userRoleMapper.delete(UserRolePO.builder().roleId(roleId).build()) > 0;
        }
        // 然后删除角色对应的权限
        boolean rolePermissionRemoveResult = true;
        if (rolePermissionMapper.selectCount(RolePermissionPO.builder().roleId(roleId).build()) > 0) {
            rolePermissionRemoveResult = rolePermissionMapper.delete(RolePermissionPO.builder().roleId(roleId).build()) > 0;
        }
        // 最后删除角色以及子集
        boolean roleRemoveResult = systemRoleMapper.deleteByPrimaryKey(roleId) > 0;

        // 通过父级ID查询出相关的子集，并且删除相关的角色以及角色相对应的权限
        Example removeChildrenRoleExample = Example.builder(RolePO.class).where(Sqls.custom().andEqualTo("parentId", roleId)).build();
        List<RolePO> childrenRole = systemRoleMapper.selectByExample(removeChildrenRoleExample);
        if (!childrenRole.isEmpty()) {
            for (RolePO rolePO : childrenRole) {
                if (rolePO.getId() != null) {
                    removeRoleById(rolePO.getId());
                }
            }
        }
        if (userRoleRemoveResult && rolePermissionRemoveResult && roleRemoveResult) {
            return true;
        } else {
            throw new BizException(ResponseStatus.COMMON_UPDATE_ERROR.getCode(),
                    String.format("角色删除异常-删除用户对应的角色：%s-删除角色对应的权限：%s-删除角色：%s", userRoleRemoveResult,
                            rolePermissionRemoveResult, roleRemoveResult));
        }
    }

    @Override
    public boolean moveRoleByRoleId(RoleMoveReq req) {
        Example example = Example.builder(RolePO.class)
                .where(Sqls.custom().andEqualTo("id", req.getRoleId()))
                .build();
        return systemRoleMapper.updateByExampleSelective(RolePO.builder()
                .parentId(req.getParentId())
                .sort(req.getSort())
                .build(), example) > 0;
    }
}
