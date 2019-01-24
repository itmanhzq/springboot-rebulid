package com.fenlibao.bid.model.po.old;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 标信息
 *
 * @author LeiXinXin
 * @date 2019/1/24
 */
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class BidInfoPO {
    private Integer id;
    /**
     * 借款用户ID
     */
    private Integer userId;
    /**
     * 借款标题
     */
    private String title;
    /**
     * 借款标类型ID
     */
    private Integer bidTypeId;
    /**
     * 借款金额
     */
    private BigDecimal loadAmount;
    /**
     * 年化利率
     */
    private BigDecimal annualizedInterestRate;
    /**
     * 可投金额
     */
    private BigDecimal remainingAmount;
    /**
     * 筹款期限,单位:天
     */
    private BigDecimal fundraisingDays;
    /**
     * 借款周期,单位:月
     */
    private BigDecimal borrowingCycle;
    /**
     * 还款方式,DEBX:等额本息;MYFX:每月付息,到期还本;YCFQ:本息到期一次付清;DEBJ:等额本金;
     */
    private BigDecimal repayMethod;
    /**
     * 状态,SQZ:申请中;DSH:待审核;DFB:待发布;YFB:预发布;TBZ:投标中;DFK:待放款;HKZ:还款中;YJQ:已结清;YLB:已流标;
     * YDF:已垫付（线上无此状态）;YZF:已作废;DFZ:垫付中（线上无此状态）
     */
    private String bidState;
    /**
     * 发布时间,预发布状态有效
     */
    private Date publishTime;
    /**
     * 申请时间
     */
    private Date applyForTime;
    /**
     * 标编号
     */
    private String bidCode;
    /**
     * 计息金额
     */
    private BigDecimal interestAmount;
    /**
     * 是否为新手标,S:是;F:否
     */
    private String isNoviceBid;
    /**
     * 新手标是否展示,S:是;F:否;
     */
    private String isShowNoviceBid;
    /**
     * 借款周期,单位:天
     */
    private String fundraisingCycle;
    /**
     * 资产类型
     */
    private String assetTypeStr;
    /**
     * 是否正在还款中 0:还款中 1:正在还款
     */
    private Integer isRepayment;
    /**
     * 标的来源(0001:分利宝，0002:缺钱么)
     */
    private String bidOrigin;
    /**
     * 1：普通标，2：存管标
     */
    private Integer differenceType;
    /**
     * 随时退出标：1是、0否
     */
    private Integer isAnyExitBid;
    /**
     * 担保措施:1 应收质押,2保证金质押,3房产抵押,4车辆质押,5信用借款
     */
    private Integer guaranteeMeasure;
    /**
     * 服务费收取节点方式:1 前置收取, 0后置收取
     */
    private Integer collectType;
    /**
     * 资产类型：1 加盟商融资;2 供应商融资;3 房产抵押;4 商票质押;5 其他
     */
    private Integer assetType;
    /**
     * 进件人
     */
    private Integer uploader;
    /**
     * 工单金额
     */
    private Integer orderMoney;

}
