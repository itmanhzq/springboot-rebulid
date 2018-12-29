package com.fenlibao.pms.service.system;

import com.fenlibao.pms.dto.req.system.RoleMoveReq;
import com.fenlibao.pms.model.po.idmt.RolePO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色业务处理层
 *
 * @author LeiXinXin
 * @date 2018/11/26
 */
@Service
public interface RoleService {
    /**
     * 保存角色
     *
     * @param rolePO 角色
     * @return boolean
     */
    boolean saveRole(RolePO rolePO);

    /**
     * 列出所有角色
     *
     * @return List
     */
    List<RolePO> listRoles();

    /**
     * 通过角色Id，更新角色信息
     *
     * @param rolePO 角色
     * @return boolean
     */
    boolean updateRoleAndPermission(RolePO rolePO);

    /**
     * 通过角色Id删除角色信息
     *
     * @param roleId 角色Id
     * @return boolean
     */
    boolean removeRoleById(Integer roleId);

    /**
     * 移动角色（更新父级id）
     *
     * @param req 角色信息
     * @return boolean
     */
    boolean moveRoleByRoleId(RoleMoveReq req);
}
