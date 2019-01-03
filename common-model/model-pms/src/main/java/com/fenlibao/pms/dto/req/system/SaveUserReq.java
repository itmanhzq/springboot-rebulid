package com.fenlibao.pms.dto.req.system;

import com.fenlibao.common.core.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author chen
 * @date 2018-11-26
 */
@Getter
@Setter
@ApiModel(value = "SaveUserReq[保存用户请求实体]")
public class SaveUserReq implements Serializable {


    private static final long serialVersionUID = -3503004289259184241L;

    @ApiModelProperty(value = "userId", required = true,example = "1")
    private Integer userId;

    @NotBlank
    @ApiModelProperty(value = "用户名", required = true,example = "admin")
    private String userName;

    @NotBlank
    @ApiModelProperty(value = "密码", required = true,example = "123456")
    @Pattern(regexp = Constants.PAWD_PATTERN, message = "密码格式错误")
    private String password;

    @NotBlank
    @ApiModelProperty(value = "确认密码", required = true,example = "123456")
    @Pattern(regexp = Constants.PAWD_PATTERN, message = "密码格式错误")
    private String comfirmPassword;

    @NotBlank
    @ApiModelProperty(value = "真实姓名", required = true,example = "admin")
    private String realName;

    @ApiModelProperty(value = "手机号码", required = true,example = "136234512154")
    @Pattern(regexp = Constants.PHONE_PATTERN, message = "手机格式错误")
    private String phone;

    @ApiModelProperty(value = "邮箱", required = true,example = "103233@qq.com")
    @Email
    private String email;

    @ApiModelProperty(value = "启用状态 0：禁用  1：启用", required = true,example = "1")
    @NotBlank
    private String status;

    @ApiModelProperty(value = "组织id ", required = true,example = "1")
    @NotBlank
    private String organizationId;

}
