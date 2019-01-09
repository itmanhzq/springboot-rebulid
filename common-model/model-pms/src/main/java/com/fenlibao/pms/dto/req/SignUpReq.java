package com.fenlibao.pms.dto.req;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Getter
@Setter
@ApiModel(value = "SignUpReq[注销请求实体]")
public class SignUpReq extends BaseReq implements Serializable{

    private static final long serialVersionUID = -3304204644212030038L;

    @ApiModelProperty(value = "姓名", required = true, example = "tony")
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @ApiModelProperty(value = "密码", required = true, example = "123456")
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
}
