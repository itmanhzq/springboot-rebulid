package com.fenlibao.pms.dto.req.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * RoleUpdateReq
 *
 * @author LeiXinXin
 * @date 2018/12/13
 */
@Data
@ApiModel(value = "RoleUpdateReq[角色更新请求实体]")
public class RoleUpdateReq implements Serializable {
    private static final long serialVersionUID = 496840177741345422L;
    private Integer id;

    @ApiModelProperty(value = "父级id ", required = true,example = "1")
    @NotNull(message = "角色父级Id不能为空")
    private Integer parentId;

    @ApiModelProperty(value = "角色名称 ", required = true,example = "技术员")
    @NotBlank(message = "角色名称不能为空")
    private String name;

    @ApiModelProperty(value = "排序号 ", required = true,example = "1")
    @Min(0)
    @NotNull(message = "排序不能为空")
    private Integer sort;

    @ApiModelProperty(value = "权限id ", required = true,example = "1")
    private List<Integer> permissionIds;
}
