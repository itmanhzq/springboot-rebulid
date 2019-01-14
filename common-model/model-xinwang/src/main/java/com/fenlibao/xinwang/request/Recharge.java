package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author hubert
 * @Date: 2018/12/11 17:56
 */
@Data
@ApiModel(value = "充值实体类")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recharge extends BasePO {

    @NotNull(message = "充值金额不能为空")
    @ApiModelProperty(required = true,value = "充值金额",example = "520")
    private BigDecimal amount;

    @ApiModelProperty(value = "平台佣金",example = "888")
    private BigDecimal commission;

    @NotNull(message = "偏好支付公司不能为空")
    @ApiModelProperty(required = true,value = "偏好支付公司",example = "YEEPAY")
    private String expectPayCompany;

    @NotNull(message = "支付方式不能为空")
    @ApiModelProperty(required = true,value = "支付方式",example = "SWIFT")
    private String rechargeWay;

    @ApiModelProperty(value = "银行编码",example = "ICBK")
    private String bankcode;

    @ApiModelProperty(value = "网银类型")
    private String payType;

    @ApiModelProperty(value = "授权交易类型")
    private String authtradeType;

    @ApiModelProperty(value = "授权金额")
    private String authtenderAmount;

    @ApiModelProperty(value = "标的号",example = "166688")
    private String projectNo;

    @ApiModelProperty(value = "商户自定义快捷路由",example = "ORIGINAL_SWIFT 为原快捷，NEW_SWIFT 为新标准快捷，不传值则走存管系统默认的快捷路由")
    private String swiftRoute;

    @NotNull(message = "页面回跳URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "http://192.168.40.213:8086/resultPage/rechargeSuccess")
    private String redirectUrl;

    @NotNull(message = "页面过期有效期不能为空")
    @ApiModelProperty(required = true,value = "过期时间",example = "20181221114935")
    private String expired;

    @ApiModelProperty(value = "快捷充值回调模式",example = "DIRECT_CALLBACK")
    private String callbackModel;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "INVESTOR9605")
    private String platformUserNo;
}
