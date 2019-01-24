package com.fenlibao.bid.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 借款管理查看
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@Data
@Builder
@ApiModel("BorrowingReq[借款管理查看]")
public class BorrowingReq {
    @NotNull(message = "标Id不能为空")
    @ApiModelProperty(value = "标Id", required = true)
    private Integer bid;
}
