package com.fenlibao.bid.dto.req;

import com.fenlibao.base.dto.AbstractPagingReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 借款管理列表查询类
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@ApiModel("BorrowingListReq[借款管理列表查询类]")
public class BorrowingListReq extends AbstractPagingReq {
    @ApiModelProperty(value = "发标起始时间")
    private Date startSendBidTime;
    @ApiModelProperty(value = "发标结束时间")
    private Date endSendBidTime;
    @ApiModelProperty(value = "开始放款日期")
    private Date startLoanTime;
    @ApiModelProperty(value = "放款结束日期")
    private Date endLoanTime;
    @ApiModelProperty(value = "标的状态")
    private String state;
    @ApiModelProperty(value = "资产类型")
    private Integer assetType;
    @ApiModelProperty(value = "借款标题")
    private String title;
    @ApiModelProperty(value = "借款账户")
    private String borrowingAccount;
    @ApiModelProperty(value = "借款人姓名")
    private String borrowerName;
    @ApiModelProperty(value = "进件人")
    private String incomer;
}
