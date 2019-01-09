package com.fenlibao.pms.dto.resp.marketing.publicize;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


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
    private Integer type;

    @ApiModelProperty(value = "文章来源", required = true)
    private String source;

    @ApiModelProperty(value = "文章作者")
    private String author;

    @ApiModelProperty("原文链接")
    private String originalUrl;

    @ApiModelProperty(value = "展示时间", required = true,example = "yyyy-MM-dd HH:mm:ss")
    private String showTime;

    @ApiModelProperty(value = "列表页图片", required = true)
    private String imageUrl;

    @ApiModelProperty(value = "排序时间", required = true,example = "yyyy-MM-dd HH:mm:ss")
    private String sortTime;

    @ApiModelProperty(value = "是否置顶 0:是; 1:否", required = true)
    private Boolean isStickTop;

    @ApiModelProperty(value = "文章状态 [1.未发布，2.已发布，3.预发布]", required = true)
    private Integer state;

    @ApiModelProperty(value = "预发布时间",example = "yyyy-MM-dd HH:mm:ss")
    private String onlineTime;

    @ApiModelProperty(value = "文章关键字")
    private String keyword;

    @ApiModelProperty(value = "文章摘要")
    private String summary;

    @ApiModelProperty(value = "文章内容", required = true)
    private String context;

}
