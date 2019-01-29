package com.fenlibao.pms.model.po.idmt;

import com.fenlibao.base.po.BasePO;
import lombok.*;

import javax.persistence.Table;

/**
 * RolePermission
 *
 * @author LeiXinXin
 * @date 2018/11/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "idmt_role_permission")
public class RolePermissionPO  extends BasePO {

    private Integer id;
    /**
     * 角色Id
     */
    private Integer roleId;
    /**
     * 权限ID
     */
    private Integer permissionId;


    /**
     * 权限
     */
    private PermissionPO permission;
}
