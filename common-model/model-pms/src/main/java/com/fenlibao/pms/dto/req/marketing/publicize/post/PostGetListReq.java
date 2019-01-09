package com.fenlibao.pms.dto.req.marketing.publicize.post;

import com.fenlibao.base.dto.AbstractPagingReq;
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
@ApiModel("PostGetListReq[获取公告列表请求类]")
public class PostGetListReq extends AbstractPagingReq {

    @ApiModelProperty("公告标题")
    private String title;

    @ApiModelProperty("发布者")
    private String userName;

    @ApiModelProperty(value = "展示时间（开始）",example = "yyyy-MM-dd HH:mm:ss")
    private String showStartTime;

    @ApiModelProperty(value = "展示时间（结束）",example = "yyyy-MM-dd HH:mm:ss")
    private String showEndTime;

    @ApiModelProperty("公告状态 [1.未发布，2.已发布，3.预发布]")
    private Integer status;

}
