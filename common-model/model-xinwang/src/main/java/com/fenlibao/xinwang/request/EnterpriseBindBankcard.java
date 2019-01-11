package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/12 11:57
 */
@Data
@ApiModel(value = "企业绑卡实体类")
public class EnterpriseBindBankcard extends BasePO {

    @NotNull(message = "页面回跳URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "www.fenlibao.com")
    private String redirectUrl;

    @NotNull(message = "银行账户号不能为空")
    @ApiModelProperty(required = true,value = "银行账户号",example = "6226902103067775")
    private String bankcardNo;

    @NotNull(message = "银行编码不能为空")
    @ApiModelProperty(required = true,value = "银行编码",example = "ICBK")
    private String bankcode;

    @ApiModelProperty(value = "UPDATE_BANKCARD")
    private String bindType;

    @ApiModelProperty(value = "银行编码")
    private String bankList;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "BORROWERS9806")
    private String platformUserNo;
}
