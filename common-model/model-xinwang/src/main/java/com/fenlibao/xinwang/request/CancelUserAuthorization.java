package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/19 14:56
 */
@Data
@ApiModel(value = "解除用户自动授权")
public class CancelUserAuthorization extends BasePO{

    @NotNull(message = "用户授权列表不能为空")
    @ApiModelProperty(required = true,value = "用户授权列表",example = "TENDER,REPAYMENT")
    private String authList;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "INVESTOR5728720")
    private String platformUserNo;
}
