package com.fenlibao.xinwang.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author hubert
 * @Date: 2018/12/12 10:24
 */
@Data
@ApiModel(value = "批量交易实体类")
public class AsyncTransaction extends BasePO {

    @NotNull(message = "批次号不能为空")
    @ApiModelProperty(required = true,value = "批次号",example = "201708092030535176")
    private String batchNo;

    @NotNull(message = "交易明细不能为空")
    @ApiModelProperty(required = true,value = "交易明细")
    private List<Map<String, String>> bizDetails;

    @NotNull(message = "交易类型不能为空")
    @ApiModelProperty(required = true,value = "交易类型",example = "COMPENSATORY")
    private String tradeType;

    @ApiModelProperty(value = "标的编号",example = "608")
    private String projectNo;

    @ApiModelProperty(value = "债权出让请求流水号",example = "608")
    private String saleRequestNo;

    @NotNull(message = "业务明细不能为空")
    @ApiModelProperty(required = true,value = "业务明细")
    private List<Map<String, String>> details;

    @NotNull(message = "业务类型不能为空")
    @ApiModelProperty(required = true,value = "业务类型",example = "COMPENSATORY")
    private String bizType;

    @ApiModelProperty(value = "预处理请求流水号",example = "201708092030522453")
    private String freezeRequestNo;

    @ApiModelProperty(value = "绑定卡预处理流水号",example = "201708092030522453")
    private String proxyPretransRequestNo;

    @ApiModelProperty(value = "出款方用户编号",example = "168")
    private String sourcePlatformUserNo;

    @ApiModelProperty(value = "收款方用户编号",example = "998")
    private String targetPlatformUserNo;

    @NotNull(message = "交易金额不能为空")
    @ApiModelProperty(required = true,value = "交易金额（有利息时为本息）",example = "1688888")
    private BigDecimal amount;

    @ApiModelProperty(value = "利息",example = "998")
    private BigDecimal income;

    @ApiModelProperty(value = "债权份额",example = "668")
    private BigDecimal share;

    @ApiModelProperty(value = "平台商户自定义参数")
    private String customDefine;

    @ApiModelProperty(value = "备注")
    private String remark;

}
