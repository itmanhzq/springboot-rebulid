package com.fenlibao.xinwang.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author hubert
 * @Date: 2018/12/12 9:00
 */
@Data
@ApiModel(value = "创建标的实体类")
public class EstablishProject extends BasePO {

    @NotNull(message = "标的号不能为空")
    @ApiModelProperty(required = true,value = "标的号",example = "hhher")
    private String projectNo;

    @NotNull(message = "标的金额不能为空")
    @ApiModelProperty(required = true,value = "标的金额",example = "1000")
    private BigDecimal projectAmount;

    @NotNull(message = "标的名称不能为空")
    @ApiModelProperty(required = true,value = "标的名称",example = "企业经营融资A1808038")
    private String projectName;

    @ApiModelProperty(value = "标的描述")
    private String projectDescription;

    @NotNull(message = "标的类型不能为空")
    @ApiModelProperty(required = true,value = "标的类型",example = "STANDARDPOWDER")
    private String projectType;

    @NotNull(message = "标的期限（单位：天）不能为空")
    @ApiModelProperty(required = true,value = "标的期限（单位：天）",example = "31")
    private int projectPeriod;

    @NotNull(message = "年化利率不能为空")
    @ApiModelProperty(required = true,value = "年化利率",example = "0.1")
    private BigDecimal annnualInterestRate;

    @NotNull(message = "还款方式不能为空")
    @ApiModelProperty(required = true,value = "还款方式",example = "ONE_TIME_SERVICING")
    private String repaymentWay;

    @ApiModelProperty(value = "是否为自动授权类标的",example = "true")
    private String isAutoAuth = "true";

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "BORROWERS9234")
    private String platformUserNo;

    @ApiModelProperty(value = "标的扩展信息")
    private String extend;
}
