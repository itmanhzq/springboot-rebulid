package com.fenlibao.bid.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 发标管理
 *
 * @author LeiXinXin
 * @date 2019/1/24
 */
@Data
@Builder
@ApiModel("PublishBidManagementReq[发标管理]")
public class PublishBidManagementReq {
    @ApiModelProperty(value = "起始申请时间")
    private Date startApplyForTime;
    @ApiModelProperty(value = "结束申请时间")
    private Date endApplyForTime;
    @ApiModelProperty(value = "起始发表时间")
    private Date startPublishBidTime;
    @ApiModelProperty(value = "结束申请时间")
    private Date endPublishBidTime;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "资产类型")
    private Integer assetType;
    @ApiModelProperty(value = "借款标题")
    private String title;
    @ApiModelProperty(value = "借款人姓名")
    private String borrowerName;
    @ApiModelProperty(value = "进件人")
    private String incomer;

}
