package com.fenlibao.bid.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 审核标的信息
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@Data
@Builder
@ApiModel("ReviewBidInfoRespBody[审核标的信息]")
public class ReviewBidInfoRespBody {
    @ApiModelProperty(value = "标的ID")
    private Integer id;
    @ApiModelProperty(value = "标的类型")
    private String bidType;
    @ApiModelProperty(value = "标的标签")
    private String label;
    @ApiModelProperty(value = "筹款到期")
    private Integer fundraisingExpirationDay;
    @ApiModelProperty(value = "代收手续费")
    private BigDecimal collectionFee;
    @ApiModelProperty(value = "营销奖励-加息")
    private BigDecimal rateInterestForBid;
    @ApiModelProperty(value = "随时退出")
    private Integer isAnyExitBid;
    @ApiModelProperty(value = "检查用户资产总额")
    private Integer checkTotalUserAssets;
    @ApiModelProperty(value = "用户资产总额")
    private BigDecimal totalUserAssets;
    @ApiModelProperty(value = "检查用户累计投资金额")
    private Integer checkUserInvestingAmount;
    @ApiModelProperty(value = "用户累计投资金额")
    private BigDecimal userInvestingAmount;
    @ApiModelProperty(value = "检查用户累计收益")
    private Integer checkUserCumulativeRevenue;
    @ApiModelProperty(value = "用户累计收益")
    private BigDecimal userCumulativeRevenue;
    @ApiModelProperty(value = "白名单用户")
    private Integer targetUserCheckbox;
    @ApiModelProperty(value = "备注-现在基于旧表，不做保留")
    private String remark;
    @ApiModelProperty(value = "递增金额-现在基于旧表，不做保留")
    private BigDecimal incrementalAmount;
    @ApiModelProperty(value = "最低起投金额-现在基于旧表，不做保留")
    private BigDecimal minimumStartingAmount;
    @ApiModelProperty(value = "最大可投金额-现在基于旧表，不做保留")
    private BigDecimal maximumInvestmentAmount;
    @ApiModelProperty(value = "审核记录")
    private List<ReviewBidRecordRespBody> reviewBidRecord;
}
