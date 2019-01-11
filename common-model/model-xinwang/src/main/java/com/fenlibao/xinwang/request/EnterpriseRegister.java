package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hubert
 * @Date: 2018/12/12 11:09
 */
@Data
@ApiModel(value = "企业绑卡注册实体类")
public class EnterpriseRegister extends BasePO {

    @NotNull(message = "页面回跳 URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "www.fenlibao.com")
    private String redirectUrl;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "INVESTOR9605")
    private String platformUserNo;

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "开户银行许可证核准号")
    private String bankLicense;

    @ApiModelProperty(value = "组织机构代码")
    private String orgNo;

    @ApiModelProperty(value = "营业执照编号")
    private String businessLicense;

    @ApiModelProperty(value = "税务登记号")
    private String taxNo;

    @ApiModelProperty(value = "统一社会信用代码")
    private String unifiedCode;

    @ApiModelProperty(value = "机构信用代码")
    private String creditCode;

    @ApiModelProperty(value = "法人姓名")
    private String legal;

    @ApiModelProperty(value = "证件类型")
    private String idCardType;

    @ApiModelProperty(value = "法人证件号")
    private String legalIdCardNo;

    @ApiModelProperty(value = "企业联系人")
    private String contact;

    @ApiModelProperty(value = "联系人手机号")
    private String contactPhone;

    @ApiModelProperty(value = "用户角色")
    private String userRole;

    @ApiModelProperty(value = "企业对公账户")
    private String bankcardNo;

    @ApiModelProperty(value = "银行编码")
    private String bankcode;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "用户授权列表")
    private String authList;

    @ApiModelProperty(value = "授权期限")
    private Date failTime;

    @ApiModelProperty(value = "授权金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "支持银行列表")
    private String bankList;
}
