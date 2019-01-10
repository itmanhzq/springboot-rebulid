package com.fenlibao.pms.dto.req.marketing.publicize.frinedlink;

import com.fenlibao.base.dto.AbstractPagingReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("FriendLinkGetListReq[获取文章列表请求体]")
public class FriendLinkGetListReq extends AbstractPagingReq {

    @ApiModelProperty("网站名称")
    private String websiteName;

    @ApiModelProperty("发布者")
    private String userName;

    @ApiModelProperty(value = "修改时间（开始）")
    private Date updatedStartTime;

    @ApiModelProperty(value = "修改时间（结束）")
    private Date updatedEndTime;

}
