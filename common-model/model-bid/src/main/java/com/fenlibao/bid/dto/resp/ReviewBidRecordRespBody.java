package com.fenlibao.bid.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 审核标的记录
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@Data
@Builder
@ApiModel("ReviewBidRecordRespBody[审核标的记录]")
public class ReviewBidRecordRespBody {
    @ApiModelProperty(value = "序号")
    private Integer serialNumber;
    @ApiModelProperty(value = "审核人")
    private String reviewer;
    @ApiModelProperty(value = "审核时间")
    private String reviewTime;
    @ApiModelProperty(value = "审核结果")
    private String reviewState;
    @ApiModelProperty(value = "备注")
    private String remark;
}
