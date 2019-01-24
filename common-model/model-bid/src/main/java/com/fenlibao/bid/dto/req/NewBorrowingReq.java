package com.fenlibao.bid.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 新增借款请求类
 *
 * @author LeiXinXin
 * @date 2019/1/21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("NewBorrowingReq[新增借款请求类]")
public class NewBorrowingReq {
    private Integer id;
    @NotNull(message = "借款标题不能为空")
    @ApiModelProperty(value = "借款标题", required = true)
    private String title;
    @NotNull(message = "合同编号不能为空")
    @ApiModelProperty(value = "合同编号", required = true)
    private String agreementCode;
    @NotNull(message = "借款用户ID不能为空")
    @ApiModelProperty(value = "借款用户ID", required = true)
    private Integer loanUserId;
    @NotNull(message = "借款金额不能为空")
    @ApiModelProperty(value = "借款金额", required = true)
    private BigDecimal loanAmount;
    @NotNull(message = "工单金额不能为空")
    @Min(value = 0, message = "工单金额不能小于0")
    @ApiModelProperty(value = "工单金额", required = true)
    private BigDecimal orderAmount;
    @NotNull(message = "是否被动续贷不能为空")
    @ApiModelProperty(value = "是否被动续贷", required = true)
    private Integer isPassiveRenewal;
    @NotNull(message = "进件人不能为空")
    @ApiModelProperty(value = "进件人", required = true)
    private Integer incomer;
    @NotNull(message = "经办人不能为空")
    @ApiModelProperty(value = "经办人", required = true)
    private String manager;
    @NotNull(message = "资产类型不能为空")
    @ApiModelProperty(value = "资产类型", required = true)
    private Integer assetType;
    @NotNull(message = "项目分类不能为空")
    @ApiModelProperty(value = "项目分类", required = true)
    private String projectClassify;
    @NotNull(message = "项目区域位置ID不能为空")
    @ApiModelProperty(value = "项目区域位置ID", required = true)
    private Integer regionalLocationId;
    @NotNull(message = "担保措施不能为空")
    @ApiModelProperty(value = "担保措施", required = true)
    private Integer guaranteeMeasure;
    @NotNull(message = "担保用户ID不能为空")
    @ApiModelProperty(value = "担保用户ID", required = true)
    private Integer guaranteeUserId;
    @NotNull(message = "借款用途不能为空")
    @ApiModelProperty(value = "借款用途", required = true)
    private String loanUsage;
    @NotNull(message = "借款期限不能为空")
    @ApiModelProperty(value = "借款期限", required = true)
    private Integer borrowingPeriod;
    @NotNull(message = "借款期限类型不能为空")
    @ApiModelProperty(value = "借款期限类型（0.月 1.天）", required = true)
    private Integer borrowingPeriodType;
    @NotNull(message = "借款利率不能为空")
    @Min(value = 0, message = "借款利率不能小于0")
    @ApiModelProperty(value = "借款利率", required = true)
    private BigDecimal annualRate;
    @NotNull(message = "借款人综合资金成本不能为空")
    @Min(value = 0, message = "借款人综合资金成本不能小于0")
    @ApiModelProperty(value = "借款人综合资金成本", required = true)
    private BigDecimal borrowerInterestRate;
    @NotNull(message = "成交服务费率不能为空")
    @Min(value = 0, message = "成交服务费率不能小于0")
    @ApiModelProperty(value = "成交服务费率", required = true)
    private BigDecimal transactionFee;
    @NotNull(message = "逾期罚息利率不能为空")
    @Min(value = 0, message = "逾期罚息利率不能小于0")
    @ApiModelProperty(value = "逾期罚息利率", required = true)
    private BigDecimal overduePenaltyInterestRate;
    @NotNull(message = "逾期手续费率不能为空")
    @Min(value = 0, message = "逾期手续费率不能小于0")
    @ApiModelProperty(value = "逾期手续费率", required = true)
    private BigDecimal overdueHandlingRate;
    @NotNull(message = "还款方式不能为空")
    @ApiModelProperty(value = "还款方式", required = true)
    private String repayMethod;
    @NotNull(message = "还款来源不能为空")
    @ApiModelProperty(value = "还款来源", required = true)
    private String repayOrigin;
    @NotNull(message = "是否连带担保不能为空")
    @ApiModelProperty(value = "是否连带担保", required = true)
    private Integer isGuarantee;
    @NotNull(message = "是否委托收款不能为空")
    @ApiModelProperty(value = "是否委托收款", required = true)
    private Integer isEntrustPayee;
    @NotNull(message = "借款描述不能为空")
    @ApiModelProperty(value = "项目介绍", required = true)
    private String loanDescription;
    @NotNull(message = "借款人收入及负债情况不能为空")
    @ApiModelProperty(value = "借款人收入及负债情况", required = true)
    private String borrowerIncomeAndLiabilities;
    @NotNull(message = "借款人征信报告不能为空")
    @ApiModelProperty(value = "借款人征信报告", required = true)
    private String borrowerCreditReport;
    @NotNull(message = "银行流水不能为空")
    @ApiModelProperty(value = "银行流水", required = true)
    private String bankTransaction;
    @NotNull(message = "其他借款情况不能为空")
    @ApiModelProperty(value = "其他借款情况", required = true)
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
}
