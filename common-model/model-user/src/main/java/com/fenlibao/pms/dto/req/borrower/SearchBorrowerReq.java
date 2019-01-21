package com.fenlibao.pms.dto.req.borrower;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author chen
 * @date 2019/01/11
 */
@Getter
@Setter
@ApiModel(value = "SearchBorrowerReq[查询借款人列表请求实体]")
public class SearchBorrowerReq extends BaseReq implements Serializable {

    @ApiModelProperty(value = "手机号",example = "136********")
    private String phone;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "注册来源",example = "0:后台添加 1:注册")
    private String origin;

    @ApiModelProperty(value = "账户类型",example = "0:个人账户 1:企业账户")
    private String type;

    @ApiModelProperty(value = "开户状态",example = "0:审核中 1:审核通过 2:审核拒绝")
    private String state;

    @ApiModelProperty(value = "账户状态",example = "0:锁定中 1:启用 2:黑名单 3::已注销")
    private String accountState;

    @ApiModelProperty("注册时间-起始")
    private String startTime;

    @ApiModelProperty("注册时间-结束")
    private String endTime;
}
