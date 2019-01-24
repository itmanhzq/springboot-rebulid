package com.fenlibao.bid.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 借款人列表
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@Data
@Builder
@ApiModel("BorrowerRespBody[借款人列表响应类]")
public class BorrowerRespBody {
    @ApiModelProperty(value = "借款人用户ID")
    private Integer userId;
    @ApiModelProperty(value = "借款人姓名")
    private Integer name;
    @ApiModelProperty(value = "手机号码")
    private Integer phone;
    @ApiModelProperty(value = "用户名")
    private Integer username;
    @ApiModelProperty(value = "账号状态")
    private Integer status;
    @ApiModelProperty(value = "开户状态")
    private Integer accountOpeningStatus;
    @ApiModelProperty(value = "账户类型")
    private Integer accountType;
    @ApiModelProperty(value = "注册时间")
    private Integer registryTime;
}
