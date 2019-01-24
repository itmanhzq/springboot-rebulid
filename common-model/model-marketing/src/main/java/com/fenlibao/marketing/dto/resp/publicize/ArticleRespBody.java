package com.fenlibao.marketing.dto.resp.publicize;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @author WangBoRan
 * @date 2018-12-26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Api("ArticleRespBody[获取文章返回类]")
public class ArticleRespBody extends BaseReq {

    @ApiModelProperty( value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "文章标题", required = true)
    private String title;

   @ApiModelProperty(value = "文章类型 [1.行业新闻，2.媒体报道，3.公司动态]", required = true)
   private String type;

    @ApiModelProperty(value = "文章来源", required = true)
    private String source;

    @ApiModelProperty(value = "文章作者")
    private String author;

    @ApiModelProperty("原文链接")
    private String originalUrl;

 @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
 @ApiModelProperty(value = "展示时间", required = true)
 private Date showTime;

    @ApiModelProperty(value = "列表页图片", required = true)
    private String imageUrl;

 @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
 @ApiModelProperty(value = "排序时间", required = true)
 private Date sortTime;

    @ApiModelProperty(value = "是否置顶 0:是; 1:否", required = true)
    private Boolean isStickTop;

    @ApiModelProperty(value = "文章状态 [1.未发布，2.已发布，3.预发布]", required = true)
    private String state;

 @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
 @ApiModelProperty(value = "预发布时间")
 private Date onlineTime;

    @ApiModelProperty(value = "文章关键字")
    private String keyword;

    @ApiModelProperty(value = "文章摘要")
    private String summary;

    @ApiModelProperty(value = "文章内容", required = true)
    private String content;

}
