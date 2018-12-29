package com.fenlibao.pms.dto.req.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * RoleMoveReq
 *
 * @author LeiXinXin
 * @date 2018/12/18
 */
@Data
@ApiModel(value = "RoleMoveReq[移动角色请求实体]")
public class RoleMoveReq implements Serializable {
    private static final long serialVersionUID = -3032974442273854057L;

    @ApiModelProperty(value = "父级id ", required = true,example = "1")
    @NotNull(message = "父级id不能为空")
    private Integer parentId;

    @ApiModelProperty(value = "角色id ", required = true,example = "1")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    @ApiModelProperty(value = "排序号 ", required = true,example = "1")
    @NotNull(message = "排序不能为空")
    @Min(0)
    private Integer sort;
}
