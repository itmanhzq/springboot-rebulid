package com.fenlibao.xinwang.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 个人绑卡注册实体类
 * @author hubert
 * @Date: 2018/12/11 17:14
 */
@Data
@Builder
public class PersonalRegisterExpand extends BasePO {

    /**
     *  平台用户编号
     */
    private String platformUserNo;
    /**
     * 用户真实姓名
     */
    private String realName;
    /**
     * 用户证件号
     */
    private String idCardNo;
    /**
     * 银行预留手机号
     */
    private String mobile;

    /**
     * 银行卡号
     */
    private String bankcardNo;

    /**
     * 证件类型
     */
    private String idCardType;
    /**
     * 用户角色
     */
    private String userRole;
    /**
     * 鉴权验证类型
     */
    private String checkType;
    /**
     * 页面回跳 URL
     */
    private String redirectUrl;
    /**
     * 验证身份证唯一性
     */
    private String userLimitType;
    /**
     * 用户授权列表
     */
    private String authList;
    /**
     * 授权期限
     */
    private String failTime;
    /**
     * 授权金额
     */
    private BigDecimal amount;
    /**
     * 固定值 MOD，如果传入则表示个人用户在注册页面可以修改手机号，否则不能更改
     */
    private String mobileChange;
    /**
     * 支持银行列表，见【银行编码】
     */
    private String bankList;
    /**
     * 验证当前角色维度身份证唯一性，固定值 ID_CARD_NO_UNIQUE，默认不校验
     */
    private String roleUserLimit;
}
