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
@ApiModel(value = "个人用户信息")
public class PersonalDetailBO extends BorrowerBaseBO implements Serializable {

    private static final long serialVersionUID = 6894528768862282059L;

    @ApiModelProperty(value = "主体性质")
    private String subjectNature;

    @ApiModelProperty(value = "学历")
    private String education;

    @ApiModelProperty(value = "所属行业")
    private String industry;

    @ApiModelProperty(value = "毕业院校")
    private String school;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "月收入")
    private String monthIncome;
}
