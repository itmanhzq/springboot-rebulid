package com.fenlibao.pms.mapper.system;

import com.fenlibao.common.core.BaseMapper;
import com.fenlibao.pms.model.po.idmt.RolePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色数据访问层
 *
 * @author LeiXinXin
 * @date 2018/11/26
 */
@Repository
public interface RoleMapper extends BaseMapper<RolePO> {

    /**
     * 查询所有角色
     *
     * @return List
     */
    List<RolePO> listRoles();

    /**
     * 通过角色Id，更新角色信息
     *
     * @param rolePO 角色
     * @return int
     */
    int updateRoleByRoleId(RolePO rolePO);

    /**
     * 通过角色Id，查询角色信息
     *
     * @param roleId 角色Id
     * @return RolePO
     */
    RolePO selectRoleByRoleId(@Param("roleId") Integer roleId);
}
