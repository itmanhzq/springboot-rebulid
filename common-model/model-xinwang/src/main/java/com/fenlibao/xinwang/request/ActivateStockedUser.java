package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hubert
 * @Date: 2018/12/14 11:01
 */
@Data
@ApiModel(value = "会员激活实体类")
public class ActivateStockedUser extends BasePO {

    @NotNull(message = "页面回跳 URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "www.fenlibao.com")
    private String redirectUrl;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "INVESTOR5728720")
    private String platformUserNo;

    @ApiModelProperty(value = "用户授权列表")
    private String authList;

    @ApiModelProperty(value = "鉴权验证类型",example = "LIMIT")
    private String checkType;

    @ApiModelProperty(value = "固定值：UNMOD",example = "UNMOD")
    private String mobileChange;

    @ApiModelProperty(value = "固定值：UNMOD",example = "UNMOD")
    private String cardChange;

    @ApiModelProperty(value = "授权期限")
    private String failTime;

    @ApiModelProperty(value = "授权金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "支持银行列表")
    private String bankList;
}
