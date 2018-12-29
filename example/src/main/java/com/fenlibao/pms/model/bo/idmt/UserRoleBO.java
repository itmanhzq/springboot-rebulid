package com.fenlibao.pms.model.bo.idmt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Toby
 * @date 2018/11/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户角色实体")
public class UserRoleBO implements Serializable {

    private static final long serialVersionUID = -6735454844511220990L;
    private Integer id;

    @NotNull(message = "用户编号不能为空")
    @ApiModelProperty(value = "用户ID", required = true, example = "1")
    private Integer userId;

    @ApiModelProperty(value = "角色ID", example = "1")
    private Integer roleId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "角色信息")
    private RoleBO role;
}
