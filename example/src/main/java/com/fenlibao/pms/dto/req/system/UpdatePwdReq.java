package com.fenlibao.pms.dto.req.system;

import com.fenlibao.pms.common.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 修改密码
 *
 * @author chen
 * @date 2018-11-26
 */
@Getter
@Setter
@ApiModel(value = "UpdatePwdReq[修改用户密码请求实体]")
public class UpdatePwdReq implements Serializable {


    private static final long serialVersionUID = -2501159066254244255L;



    @NotBlank
    @ApiModelProperty(value = "旧密码", required = true,example = "123456")
    private String oldPassword;

    /**
     * 新密码
     */
    @NotBlank
    @ApiModelProperty(value = "新密码", required = true,example = "123456")
    @Pattern(regexp = Constants.PAWD_PATTERN, message = "密码格式错误")
    private String newPassword;


}
