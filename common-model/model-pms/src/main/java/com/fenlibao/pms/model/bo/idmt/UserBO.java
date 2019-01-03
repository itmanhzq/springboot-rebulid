package com.fenlibao.pms.model.bo.idmt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户信息")
public class UserBO implements Serializable {

    private static final long serialVersionUID = -8548287612650812497L;
    private Integer id;

    @Length(min = 4, max = 20, message = "用户名称字符长度在 {min} 到 {max} 之间")
    @ApiModelProperty(value = "用户名 ", required = true, example = "admin")
    private String userName;

    @Length(min = 6, max = 12, message = "用户密码长度在 {min} 到 {max} 之间")
    @ApiModelProperty(value = "密码 ", required = true, example = "123456")
    private String password;

    @Length(min = 2, max = 10, message = "真实姓名字符长度在 {min} 到 {max} 之间")
    @ApiModelProperty(value = "真实姓名", required = true, example = "长坂坡")
    private String realName;

    @ApiModelProperty(value = "手机号", example = "12345678911")
    private String phone;

    @ApiModelProperty(value = "邮箱", example = "admin@admin.com")
    private String email;

    @ApiModelProperty(value = "状态", example = "status")
    private Integer status;
    @ApiModelProperty(value = "头像", example = "avatar")
    private String avatar;
    @ApiModelProperty(value = "账号是否被锁", example = "lock")
    private Boolean lock;

    /**
     * 是否离职
     */
    @ApiModelProperty(value = "是否离职", example = "dimission")
    private Boolean dimission;

    /**
     * 密码错误次数
     */
    @ApiModelProperty(value = "密码错误次数", example = "111")
    private Integer errorNumber;

    @ApiModelProperty(value = "用户角色集合", example = "userRoles")
    private List<UserRoleBO> userRoles;

    @ApiModelProperty(value = "组织", example = "userRoles")
    private OrganizationBO organization;
}
