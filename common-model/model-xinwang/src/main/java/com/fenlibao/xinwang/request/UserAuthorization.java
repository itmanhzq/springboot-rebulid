package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hubert
 * @Date: 2018/12/19 14:47
 */
@Data
@ApiModel(value = "用户授权实体类")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthorization extends BasePO{

    @NotNull(message = "用户授权列表不能为空")
    @ApiModelProperty(required = true,value = "用户授权列表",example = "TENDER,REPAYMENT")
    private String authList;

    @ApiModelProperty(value = "授权期限")
    private String failTime;

    @ApiModelProperty(value = "授权金额")
    private BigDecimal amount;

    @NotNull(message = "页面回跳 URL不能为空")
    @ApiModelProperty(required = true,value = "页面回跳 URL",example = "www.fenliabo.com")
    private String redirectUrl;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "INVESTOR5728720")
    private String platformUserNo;
}
