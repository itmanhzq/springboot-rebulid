package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 企业信息修改实体类
 * @author hubert
 * @Date: 2018/12/12 10:57
 */
@Data
@ApiModel(value = "企业信息修改实体类")
public class EnterpriseInformationUpdate extends BasePO {

    @NotNull(message = "页面回跳 URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "www.fenlibao.com")
    private String redirectUrl;

    @NotNull(message = "平台用户编号不用为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "BORROWERS5728143")
    private String platformUserNo;

}
