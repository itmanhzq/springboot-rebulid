package com.fenlibao.bid.model.po.old;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 标扩展信息
 *
 * @author LeiXinXin
 * @date 2019/1/24
 */
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class BidInfoExtPO {
    /**
     * 标ID
     */
    private Integer id;
    /**
     * 还款总期数
     */
    private Integer repayTotalTerm;
    /**
     * 剩余期数
     */
    private Integer remainingTerm;
    /**
     * 月化收益率
     */
    private BigDecimal monthlyYield;
    /**
     * 日化收益率
     */
    private BigDecimal dailyYield;
    /**
     * 下次还款日期
     */
    private Date nextRepayDate;
    /**
     * 项目区域位置ID
     */
    private Integer regionalLocationId;
    /**
     * 资金用途
     */
    private String useFunds;
    /**
     * 借款描述
     */
    private String loanDescription;
    /**
     * 审核时间
     */
    private Date reviewTime;
    /**
     * 满标时间
     */
    private Date fullBidTime;
    /**
     * 放款时间
     */
    private Date loanTime;
    /**
     * 结清时间
     */
    private Date settleTime;
    /**
     * 垫付时间
     */
    private Date advancePaymentTime;
    /**
     * 流标时间
     */
    private Date flowBidTime;
    /**
     * 还款来源
     */
    private String repayOrigin;
    /**
     * 起息日期
     */
    private Date valueDate;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 是否逾期,S:是(逾期);F:否;YZYQ:严重逾期
     */
    private String isOverdue;
    /**
     * 还款提前预警日
     */
    private String repayEarlyWarning;
    /**
     * 是否为按天借款,S:是;F:否
     */
    private String isBorrowingByDay;
    /**
     * 借款天数
     */
    private String borrowingDays;
    /**
     * 店铺名称
     */
    private String storeName;
    /**
     * 店铺地址
     */
    private String storeAddress;
    /**
     * 店铺图片
     */
    private String storeImageUrl;
    /**
     * 店铺图片缩略图
     */
    private String storeImageThumbnail;
    /**
     * 自定义标签
     */
    private String customizeLabel;
    /**
     * 合同编号
     */
    private String agreementCode;
    /**
     * 置顶时间
     */
    private String topTime;
    /**
     * 0:普通标，1：消费信贷计划标
     */
    private Integer bidDifference;
    /**
     * 营销设置条件说明
     */
    private String conditionalDescription;
    /**
     * 发布后是否加入计划债权库 0：不加入，1：加入
     */
    private Integer isPublishJoinCredit;
    /**
     * 还款时是否给借款人发信息：1发送、0不发送
     */
    private Integer sendMsgBorrower;
    /**
     * 推荐时间，推荐列表最新首位显示在推荐首页
     */
    private Date recommendTime;
    /**
     * 担保用户id，推荐列表最新首位显示在推荐首页
     */
    private Integer guaranteeUserId;
    /**
     * 委托收款人用户id
     */
    private Integer entrustPayeeUserId;
    /**
     * 是否担保(为空时表示没选择,0表示选择否,1表示选择是)
     */
    private String guaranteeFlag;
    /**
     * 是否委托收款(为空时表示没选择,0表示选择否,1表示选择是)
     */
    private String entrustPayeeFlag;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 出借类型: 0 手动出借  1:自动出借
     */
    private Integer lendType;
    /**
     * 是否匹配过 : 0 未匹配 ; 1:已匹配
     */
    private Integer isMate;
}
