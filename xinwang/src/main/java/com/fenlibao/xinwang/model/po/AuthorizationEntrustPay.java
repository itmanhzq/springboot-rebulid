package com.fenlibao.xinwang.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/14 11:09
 */
@Data
@ApiModel(value = "委托支付授权记录实体类")
public class AuthorizationEntrustPay extends BasePO {

    @NotNull(message = "借款方平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "借款方平台用户编号",example = "BORROWERS9232")
    private String borrowPlatformUserNo;

    @NotNull(message = "标的号不能为空")
    @ApiModelProperty(required = true,value = "标的号",example = "3588")
    private String projectNo;

    @NotNull(message = "鉴权验证类型不能为空")
    @ApiModelProperty(required = true,value = "鉴权验证类型",example = "LIMIT")
    private String checkType;

    @NotNull(message = "受托方类型不能为空")
    @ApiModelProperty(required = true,value = "受托方类型",example = "PERSONAL")
    private String entrustedType;

    @NotNull(message = "受托方平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "受托方平台用户编号",example = "INVESTOR8996")
    private String entrustedPlatformUserNo;
}
