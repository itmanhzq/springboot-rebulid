package com.fenlibao.bid.dto.req;

import com.fenlibao.base.dto.AbstractPagingReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  审核查询条件
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@ApiModel("ReviewBidListReq[审核查询条件]")
public class InitialReviewBidListReq extends AbstractPagingReq {
    @ApiModelProperty(value = "借款标题")
    private String title;
    @ApiModelProperty(value = "借款账户")
    private String borrowingAccount;
    @ApiModelProperty(value = "借款人姓名")
    private String borrowerName;
}
