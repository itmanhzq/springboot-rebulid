package com.fenlibao.xinwang.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author hubert
 * @Date: 2018/12/12 10:14
 */
@Data
@ApiModel(value = "授权预处理实体类")
public class UserAutoPreTransaction extends BasePO {

    @ApiModelProperty(value = "关联充值请求流水号（原充值成功请求流水号）")
    private String originalRechargeNo;

    @NotNull(message = "预处理业务类型不能为空")
    @ApiModelProperty(required = true,value = "预处理业务类型",example = "TENDER")
    private String bizType;

    @NotNull(message = "冻结金额不能为空")
    @ApiModelProperty(required = true,value = "冻结金额",example = "1000")
    private BigDecimal amount;

    @ApiModelProperty(value = "预备使用的红包金额",example = "1000")
    private BigDecimal preMarketingAmount;

    @ApiModelProperty(value = "备注",example = "1000")
    private String remark;

    @NotNull(message = "标的号不能为空")
    @ApiModelProperty(required = true,value = "标的号",example = "hhher")
    private String projectNo;

    @ApiModelProperty(value = "购买债转份额",example = "1000")
    private BigDecimal share;

    @ApiModelProperty(value = "债权出让请求流水号")
    private BigDecimal creditsaleRequestNo;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "BORROWERS9234")
    private String platformUserNo;

}
