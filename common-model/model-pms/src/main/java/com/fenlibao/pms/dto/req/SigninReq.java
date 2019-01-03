package com.fenlibao.pms.dto.req;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Toby
 * @date 2018/11/7
 */
@Getter
@Setter
@ApiModel(value = "SigninReq[登录请求实体]")
public class SigninReq extends BaseReq implements Serializable {

    private static final long serialVersionUID = 8405835552578998882L;

    @NotBlank
    @ApiModelProperty(value = "用户唯一签名", required = true, example = "userName")
    private String userUniqueSign;

    @NotBlank
    @ApiModelProperty(value = "密码", required = true, example = "password")
    private String password;

    @NotBlank
    @ApiModelProperty(value = "验证码id", required = true, example = "validateId")
    private String validateId;
}
