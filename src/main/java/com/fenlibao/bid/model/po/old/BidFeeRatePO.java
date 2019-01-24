package com.fenlibao.bid.model.po.old;

import lombok.*;

import java.math.BigDecimal;

/**
 * 标的费率
 *
 * @author LeiXinXin
 * @date 2019/1/24
 */
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class BidFeeRatePO {
    /**
     * 标ID
     */
    private Integer bid;
    /**
     * 成交服务费率
     */
    private BigDecimal transactionServiceRate;
    /**
     * 投资管理费率
     */
    private BigDecimal investmentManagementRate;
    /**
     * 逾期罚息利率
     */
    private BigDecimal overduePenaltyInterestRate;
    /**
     * 标的奖励利率
     */
    private BigDecimal bidIncentiveRate;
    /**
     * 借款人利率
     */
    private BigDecimal borrowerInterestRate;
    /**
     * 逾期手续费率
     */
    private BigDecimal overdueFeeRate;
    /**
     * 代收手续费
     */
    private BigDecimal custodyHandlingFee;
    /**
     * 标加息利率
     */
    private BigDecimal bidAddInterestRate;
    /**
     * 标还款利率
     */
    private BigDecimal repaymentRate;
    /**
     * 利息管理费比例
     */
    private BigDecimal interestPercent;
}
