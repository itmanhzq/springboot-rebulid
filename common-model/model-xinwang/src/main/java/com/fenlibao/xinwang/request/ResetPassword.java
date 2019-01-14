package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/11 18:15
 */
@Data
@ApiModel(value = "修改密码实体类")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResetPassword extends BasePO {
    /**
     * 变更类型：Remember 为记得密码，主动修改密码；Forget 为忘记密码，重新设置密码；
     */
    @ApiModelProperty(value = "变更类型",example = "Remember")
    private String isSkip;

    @NotNull(message = "页面回跳URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "http://192.168.40.215:90/#/withdrawalsSuccess")
    private String redirectUrl;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "INVESTOR9605")
    private String platformUserNo;
}
