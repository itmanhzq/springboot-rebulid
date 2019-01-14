package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author hubert
 * @Date: 2018/12/11 18:07
 */
@Data
@ApiModel(value = "提现实体类")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Withdraw extends BasePO {

    @NotNull(message = "页面过期有效期不能为空")
    @ApiModelProperty(required = true,value = "过期时间",example = "20181221114935")
    private String expired;

    @NotNull(message = "页面回跳URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "http://192.168.40.215:90/#/withdrawalsSuccess")
    private String redirectUrl;
    /**
     * 见【提现方式】，直接提现时，该参数为必传，NORMAL 表示普通 T1，URGENT
     表示加急 T0，NORMAL_URGENT 表示智能 T0;待确认提现时，该参数允许不传，
     或者传入 NORMAL 表示普通 T1；
     */
    @ApiModelProperty(value = "提现方式",example = "NORMAL_URGENT")
    private String withdrawType;
    /**
     * 提现类型，IMMEDIATE 为直接提现，CONFIRMED 为待确认提现，不传默认为直接提现类型
     */
    @ApiModelProperty(value = "提现类型",example = "IMMEDIATE")
    private String withdrawForm;

    @NotBlank(message = "提现金额不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "100")
    private BigDecimal amount;

    @ApiModelProperty(value = "提现分佣",example = "100")
    private BigDecimal commission;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "INVESTOR9605")
    private String platformUserNo;

}
