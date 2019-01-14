package com.fenlibao.pms.dto.req.marketing.publicize.article;

import com.fenlibao.base.dto.AbstractPagingReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author WangBoRan
 * @date 2018-12-26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("ArticleGetListReq[获取文章列表请求类]")
public class ArticleGetListReq extends AbstractPagingReq {

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("发布者")
    private String userName;

    @ApiModelProperty(value = "展示时间（开始）")
    private Date showStartTime;

    @ApiModelProperty(value = "展示时间（结束）")
    private Date showEndTime;

    @ApiModelProperty("分类 [1.行业新闻，2.媒体报道，3.公司动态]")
    private Integer type;

    @ApiModelProperty("文章状态 [1.未发布，2.已发布，3.预发布]")
    private Integer state;

    @ApiModelProperty("user_id")
    private Integer userId;
}
