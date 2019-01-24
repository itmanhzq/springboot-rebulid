package com.fenlibao.bid.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 借款人
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@Data
@Builder
@ApiModel("BorrowerReq[借款人查询请求类]")
public class BorrowerReq {
    @ApiModelProperty(value = "借款人姓名")
    private String name;
    @ApiModelProperty(value = "借款人手机号")
    private String phone;
    @ApiModelProperty(value = "借款人用户名")
    private String username;
}
