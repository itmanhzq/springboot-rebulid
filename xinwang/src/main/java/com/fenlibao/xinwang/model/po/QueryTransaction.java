package com.fenlibao.xinwang.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/12 10:35
 */
@Data
@ApiModel(value = "单笔交易查询实体类")
public class QueryTransaction extends BasePO {

    @NotNull(message = "交易查询类型不能为空")
    @ApiModelProperty(required = true,value = "交易查询类型",example = "RECHARGE")
    private String transactionType;

    @ApiModelProperty(value = "用户平台ID",example = "INVESTOR9605")
    private String platformUserNo;

}
