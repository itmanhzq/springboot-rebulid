package com.fenlibao.bid.model.po.old;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 标对应借款人详细信息
 *
 * @author LeiXinXin
 * @date 2019/1/24
 */
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class BidExtUserPO {
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 标id
     */
    private Integer bid;
    /**
     * 借款人id
     */
    private Integer userId;
    /**
     * 借款人收入及负债情况
     */
    private String borrowerInfo;
    /**
     * 征信信息
     */
    private String credit;
    /**
     * 银行流水
     */
    private String bankTransaction;
    /**
     * 风控审核项目
     */
    private String risk;
    /**
     * 经办人
     */
    private String operator;
    /**
     * 真实借款人姓名
     */
    private String realName;
    /**
     * 真实借款人身份证号（加密存储）
     */
    private String realCreditCardNum;
    /**
     * 真实借款人手机
     */
    private String realPhone;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 地址
     */
    private String address;
    /**
     * 主体性质 1自然人, 2法人, 3其他组织机构
     */
    private String subjectNature;
    /**
     * 其他借款信息
     */
    private String otherBorrowerInfo;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
