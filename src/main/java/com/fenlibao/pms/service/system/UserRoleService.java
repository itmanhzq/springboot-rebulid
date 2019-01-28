package com.fenlibao.pms.service.system;

import com.fenlibao.pms.model.bo.idmt.RoleBO;
import com.fenlibao.pms.model.po.idmt.UserRolePO;
import com.fenlibao.pms.dto.req.system.UserRoleReq;

import java.util.List;

/**
 * 用户角色业务处理层
 *
 * @author LeiXinXin
 * @date 2018/12/7
 */
public interface UserRoleService {
    /**
     * 根据用户Id查询角色信息
     *
     * @param userId 用户Id
     * @return List
     */
    List<UserRolePO> listUserRoleByUserId(Integer userId);

    /**
     * 组装用户的角色信息
     *
     * @param userId 用户ID
     * @return RoleBO
     */
    RoleBO findUserRoleInfo(Integer userId);

    /**
     * 将角色组装成树形
     *
     * @param parent  父级
     * @param roleBOS 角色集合
     */
    void buildRoleAndChild(RoleBO parent, List<RoleBO> roleBOS);

    /**
     * 通过用户Id更新用户角色
     *
     * @param userRoleReq 用户角色信息
     * @return boolean
     */
    boolean updateUserRoleByUserId(UserRoleReq userRoleReq);
}