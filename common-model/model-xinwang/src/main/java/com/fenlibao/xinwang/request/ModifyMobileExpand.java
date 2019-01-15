package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/11 18:24
 */
@Data
@ApiModel(value = "预留手机号更新实体类")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifyMobileExpand extends BasePO {


    @ApiModelProperty(value = "更新后用户手机号",example = "15815888888")
    private String mobile;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "INVESTOR9605")
    private String platformUserNo;

    @NotNull(message = "页面回跳URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳URL",example = "http://192.168.40.215:90/cg/modify_reserved_phone")
    private String redirectUrl;
    /**
     * 鉴权验证类型，默认填 LIMIT（强制四要素），即四要素完全通过（姓名、身份证
     号、银行卡号，银行预留手机号） 方可更新手机号成功
     */
    @ApiModelProperty(value = "鉴权验证类型",example = "LIMIT")
    private String checkType;

    @ApiModelProperty(value = "银行列表")
    private String bankList;
}
