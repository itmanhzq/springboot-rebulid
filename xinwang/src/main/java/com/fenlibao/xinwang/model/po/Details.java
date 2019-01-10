package com.fenlibao.xinwang.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * 业务明细
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Details implements Serializable{
    private static final long serialVersionUID = 1905122041950251207L;

    /**
     * 业务类型
     */
    String  bizType;
    /**
     * 预处理请求流水号
     */
    String freezeRequestNo;
    /**
     * 出款方编号
     */
    String sourcePlatformUserNo;
    /**
     * 收款方用户编号
     */
    String targetPlatformUserNo;
    /**
     * 交易金额（有利息时为本息和）
     */
    BigDecimal amount;
    /**
     * 利息
     */
    BigDecimal income;
    /**
     * 债权份额（债权认购且需校验债权关系的必传）
     */
    BigDecimal share;
    /**
     * 平台商户自定义参数， 平台交易时传入的自定义参数
     */
    String customDefine;
    /**
     * 备注
     */
    String remark;

}
