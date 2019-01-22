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
@ApiModel(value = "借款人基础信息")
public class BorrowerBaseBO implements Serializable {

    private static final long serialVersionUID = 6894528768862282029L;

    private Integer id;

    @ApiModelProperty(value = "姓名或者企业名称")
    private String name;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "注册来源" ,example = "0:后台添加 1:手动注册")
    private Integer origin;

    @ApiModelProperty(value = "开户状态" ,example = "0:审核中 1:审核成功 2:审核拒绝 3:审核回退")
    private Integer accountState;

    @ApiModelProperty(value = "注册时间")
    private long registerTime;

    @ApiModelProperty(value = "绑定邮箱")
    private String email;

    @ApiModelProperty(value = "借款人收入及负债情况")
    private String incomeAndLiabilities;

    @ApiModelProperty(value = "征信报告")
    private String creditReport;

    @ApiModelProperty(value = "银行流水")
    private String bankTransaction;

    @ApiModelProperty(value = "其他借款情况")
    private String otherInfo;
}
