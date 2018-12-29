package com.fenlibao.pms.model.bo.idmt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * RolePermission
 *
 * @author LeiXinXin
 * @date 2018/11/26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RolePermissionBO implements Serializable {

    private static final long serialVersionUID = -1087101212513440165L;
    private Integer id;
    /**
     * 角色Id
     */
    private Integer roleId;
    /**
     * 权限ID
     */
    private Integer permissionId;
    private Date createTime;

    /**
     * 权限
     */
    private PermissionBO permission;
}
