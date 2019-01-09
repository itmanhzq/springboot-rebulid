package com.fenlibao.pms.model.bo.idmt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author chen
 * @date 2018/11/22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色")
public class RoleBO implements Serializable {

    private static final long serialVersionUID = 7963668681390709648L;
    private Integer id;

    @NotNull(message = "角色父级Id不能为空")
    @ApiModelProperty(value = "父级ID", example = "parentId")
    private Integer parentId;

    @NotBlank(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称", example = "name")
    private String name;

    @ApiModelProperty(value = "排序", example = "sort")
    private Integer sort;

    private Date createTime;

    @ApiModelProperty(value = "角色权限集合", example = "rolePermission")
    private List<RolePermissionBO> rolePermission;

    @ApiModelProperty(value = "角色子集", example = "children")
    private List<RoleBO> children;

    @ApiModelProperty(value = "角色选中", example = "checked")
    private Boolean checked;
}
