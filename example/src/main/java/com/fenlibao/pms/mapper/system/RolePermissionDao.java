package com.fenlibao.pms.mapper.system;

import com.fenlibao.pms.common.BaseMapper;
import com.fenlibao.pms.model.po.idmt.RolePermissionPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色权限数据访问层
 *
 * @author LeiXinXin
 * @date 2018/11/26
 */
@Repository
public interface RolePermissionDao extends BaseMapper<RolePermissionPO> {

    /**
     * 通过角色id查询角色权限信息
     *
     * @param roleId 权限
     * @return RolePermissionDao
     */
    List<RolePermissionPO> selectByRoleId(Integer roleId);
}
