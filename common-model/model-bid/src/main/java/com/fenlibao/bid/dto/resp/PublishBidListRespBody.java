package com.fenlibao.bid.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 发标管理列表
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@Data
@Builder
@ApiModel("PublishBidListRespBody[发标管理列表]")
public class PublishBidListRespBody {
    @ApiModelProperty(value = "标的ID")
    private Integer id;
    @ApiModelProperty(value = "序号")
    private Integer serialNumber;
    @ApiModelProperty(value = "资产类型")
    private Integer assetType;
    @ApiModelProperty(value = "借款标题")
    private String title;
    @ApiModelProperty(value = "借款人姓名")
    private String borrowerName;
    @ApiModelProperty(value = "借款账户")
    private String borrowingAccount;
    @ApiModelProperty(value = "借款金额")
    private BigDecimal loanAmount;
    @ApiModelProperty(value = "借款利率")
    private BigDecimal annualizedInterestRate;
    @ApiModelProperty(value = "借款人综合资金成本")
    private BigDecimal borrowerInterestRate;
    @ApiModelProperty(value = "还款方式")
    private String repayMethod;
    @ApiModelProperty(value = "期限")
    private Integer term;
    @ApiModelProperty(value = "申请时间")
    private Date applyForTime;
    @ApiModelProperty(value = "发标时间")
    private Date publishBidTime;
    @ApiModelProperty(value = "显示和可投时间")
    private Date showAndTenderTime;
    @ApiModelProperty(value = "加息率")
    private BigDecimal rateHike;
    @ApiModelProperty(value = "最低起投金额")
    private BigDecimal minimumStartingAmount;
    @ApiModelProperty(value = "状态")
    private String state;
}
