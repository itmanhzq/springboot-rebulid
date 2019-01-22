package com.fenlibao.pms.model.bo.borrower;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author chen
 * @date 2018/11/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "企业用户信息")
public class EnterpriseDetailBO extends BorrowerBaseBO implements Serializable {

    private static final long serialVersionUID = 6894528768862282049L;


    @ApiModelProperty(value = "营业执照登记注册号")
    private String enterpriseRegisterNo;

    @ApiModelProperty(value = "借款人性质" ,example = "0:法人 1:其他组织")
    private Integer borrowerNature;

    @ApiModelProperty(value = "所属行业" ,example = "金融业")
    private String industry;

    @ApiModelProperty(value = "地址" ,example = "**省**市")
    private String address;

    @ApiModelProperty(value = "营业执照编号")
    private String licenceNo;

    @ApiModelProperty(value = "税务登记号")
    private String taxNo;

    @ApiModelProperty(value = "机构信用代码")
    private String creditCode;

    @ApiModelProperty(value = "组织机构代码")
    private String organizeCode;

    @ApiModelProperty(value = "法人姓名")
    private String legalName;

    @ApiModelProperty(value = "法人证件类型")
    private String certificatesType;

    @ApiModelProperty(value = "法人证件号")
    private String certificatesNo;

    @ApiModelProperty(value = "联系人姓名")
    private String contactsName;

    @ApiModelProperty(value = "联系人电话号码")
    private String contactsPhone;

    @ApiModelProperty(value = "开户银行")
    private String depositBank;

    @ApiModelProperty(value = "对公账户")
    private String publicAccounts;

}
