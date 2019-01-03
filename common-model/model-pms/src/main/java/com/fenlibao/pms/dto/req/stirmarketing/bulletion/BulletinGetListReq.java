package com.fenlibao.pms.dto.req.stirmarketing.bulletion;

import com.fenlibao.pms.dto.base.AbstractPagingReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("GetBulletionListReq[获取公告列表请求类]")
public class BulletinGetListReq extends AbstractPagingReq {

    @ApiModelProperty("公告标题")
    private String title;

    @ApiModelProperty("发布者")
    private String userName;

    @ApiModelProperty("展示时间（开始）")
    private String showStartTime;

    @ApiModelProperty("展示时间（结束）")
    private String showEndTime;

    @ApiModelProperty("公告状态 [1.未发布，2.已发布，3.预发布]")
    private Integer status;

}
