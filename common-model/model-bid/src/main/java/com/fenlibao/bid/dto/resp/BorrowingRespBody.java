package com.fenlibao.bid.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借款管理列表返回类
 *
 * @author LeiXinXin
 * @date 2019/1/22
 */
@Data
@Builder
@ApiModel("BorrowingRespBody[借款管理列表类]")
public class BorrowingRespBody {
    @ApiModelProperty(value = "标的ID")
    private Integer id;
    @ApiModelProperty(value = "序号")
    private Integer serialNumber;
    @ApiModelProperty(value = "资产类型")
    private String assetType;
    @ApiModelProperty(value = "合同编号")
    private String agreementCode;
    @ApiModelProperty(value = "借款标题")
    private String title;
    @ApiModelProperty(value = "借款人姓名")
    private String borrowerName;
    @ApiModelProperty(value = "借款账户")
    private String borrowingAccount;
    @ApiModelProperty(value = "借款金额")
    private BigDecimal loanAmount;
    @ApiModelProperty(value = "投标金额")
    private BigDecimal bidAmount;
    @ApiModelProperty(value = "借款人综合资金成本")
    private BigDecimal borrowerInterestRate;
    @ApiModelProperty(value = "还款方式")
    private String repayMethod;
    @ApiModelProperty(value = "期限")
    private Integer term;
    @ApiModelProperty(value = "申请时间")
    private Date applyForTime;
    @ApiModelProperty(value = "发标时间")
    private Date sendBidTime;
    @ApiModelProperty(value = "发标时间")
    private Date loanTime;
    @ApiModelProperty(value = "是否为续贷")
    private String isPassiveRenewal;
    @ApiModelProperty(value = "进件人")
    private String incomer;
    @ApiModelProperty(value = "经办人")
    private String manager;
    @ApiModelProperty(value = "状态")
    private String state;
}
