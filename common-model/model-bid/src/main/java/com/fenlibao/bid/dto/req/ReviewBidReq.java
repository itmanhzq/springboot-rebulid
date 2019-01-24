package com.fenlibao.bid.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 审核标请求
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@Data
@Builder
@ApiModel("ReviewBidReq[借款管理列表查询类]")
public class ReviewBidReq {
    @NotNull(message = "标Id不能为空")
    @ApiModelProperty(value = "标Id", required = true)
    private Integer bid;
}
