package com.fenlibao.bid.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 借款管理查看
 *
 * @author LeiXinXin
 * @date 2019/1/21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("ViewBorrowingRespBody[借款管理查看]")
public class ViewBorrowingRespBody {
    private Integer id;
    @ApiModelProperty(value = "借款标题")
    private String title;
    @ApiModelProperty(value = "合同编号")
    private String agreementCode;
    @ApiModelProperty(value = "借款用户ID")
    private Integer loanUserId;
    @ApiModelProperty(value = "借款金额")
    private BigDecimal loanAmount;
    @ApiModelProperty(value = "工单金额")
    private BigDecimal orderAmount;
    @ApiModelProperty(value = "是否被动续贷")
    private Integer isPassiveRenewal;
    @ApiModelProperty(value = "进件人")
    private Integer incomer;
    @ApiModelProperty(value = "经办人")
    private String manager;
    @ApiModelProperty(value = "资产类型")
    private Integer assetType;
    @ApiModelProperty(value = "项目分类")
    private String projectClassify;
    @ApiModelProperty(value = "项目区域位置ID")
    private Integer regionalLocationId;
    @ApiModelProperty(value = "担保措施")
    private Integer guaranteeMeasure;
    @ApiModelProperty(value = "担保用户ID")
    private Integer guaranteeUserId;
    @ApiModelProperty(value = "借款用途")
    private String loanUsage;
    @ApiModelProperty(value = "借款期限")
    private Integer borrowingPeriod;
    @ApiModelProperty(value = "借款期限类型（0.月 1.天）")
    private Integer borrowingPeriodType;
    @ApiModelProperty(value = "借款利率")
    private BigDecimal annualRate;
    @ApiModelProperty(value = "借款人综合资金成本")
    private BigDecimal borrowerInterestRate;
    @ApiModelProperty(value = "成交服务费率")
    private BigDecimal transactionFee;
    @ApiModelProperty(value = "逾期罚息利率")
    private BigDecimal overduePenaltyInterestRate;
    @ApiModelProperty(value = "逾期手续费率")
    private BigDecimal overdueHandlingRate;
    @ApiModelProperty(value = "还款方式")
    private String repayMethod;
    @ApiModelProperty(value = "还款来源")
    private String repayOrigin;
    @ApiModelProperty(value = "是否连带担保")
    private Integer isGuarantee;
    @ApiModelProperty(value = "是否委托收款")
    private Integer isEntrustPayee;
    @ApiModelProperty(value = "项目介绍")
    private String loanDescription;
    @ApiModelProperty(value = "借款人收入及负债情况")
    private String borrowerIncomeAndLiabilities;
    @ApiModelProperty(value = "借款人征信报告")
    private String borrowerCreditReport;
    @ApiModelProperty(value = "银行流水")
    private String bankTransaction;
    @ApiModelProperty(value = "其他借款情况")
    private String otherBorrowerInfo;
    @ApiModelProperty(value = "风控审核项目-身份证")
    private Integer identification;
    @ApiModelProperty(value = "风控审核项目-征信认证")
    private Integer credit;
    @ApiModelProperty(value = "风控审核项目-公司相关证照（营业执照、税务登记证）")
    private Integer licence;
    @ApiModelProperty(value = "风控审核项目-租赁合同")
    private Integer agreements;
    @ApiModelProperty(value = "风控审核项目-银行流水")
    private Integer bankInfo;
    @ApiModelProperty(value = "风控审核项目-业绩流水报表")
    private Integer performanceFlowReport;
    @ApiModelProperty(value = "风控审核项目-担保方相关资料")
    private Integer guarantorRelatedInformation;
    @ApiModelProperty(value = "风控审核项目-资产凭证")
    private Integer personalAsset;
    @ApiModelProperty(value = "风控审核项目-工作证明")
    private Integer employment;
    @ApiModelProperty(value = "风控审核项目-三方合作协议")
    private Integer cooperation;
    @ApiModelProperty(value = "认证类型-信用认证")
    private Integer creditCertification;
    @ApiModelProperty(value = "认证类型-实地认证")
    private Integer fieldCertification;
    @ApiModelProperty(value = "认证类型-抵押担保")
    private Integer mortgageGuarantee;
    @ApiModelProperty(value = "认证类型-质押担保")
    private Integer pledgeGuarantee;
    @ApiModelProperty(value = "认证类型-保证担保")
    private Integer ensureGuarantee;
    @ApiModelProperty(value = "审核记录")
    private List<ReviewBidRecordRespBody> reviewBidRecord;
}
