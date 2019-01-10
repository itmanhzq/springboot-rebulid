package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/12 10:49
 */
@Data
@ApiModel(value = "个人换绑卡实体类")
public class PersonalBindBankcardExpand extends BasePO {

    @NotNull(message = "页面回跳 URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "www.fenlibao.com")
    private String redirectUrl;

    @ApiModelProperty(value = "银行预留手机号",example = "1581688888")
    private String mobile;

    @NotNull(message = "鉴权验证类型不能为空")
    @ApiModelProperty(required = true,value = "鉴权验证类型",example = "LIMIT")
    private String checkType;

    @ApiModelProperty(value = "固定值",example = "LIMIT")
    private String bindType;

    @ApiModelProperty(value = "支持银行列表",example = "LIMIT")
    private String bankList;

    @NotNull(message = "借款方平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "借款方平台用户编号",example = "ABOC")
    private String platformUserNo;
}
