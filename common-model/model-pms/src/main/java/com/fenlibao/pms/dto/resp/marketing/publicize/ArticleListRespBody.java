package com.fenlibao.pms.dto.resp.marketing.publicize;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangBoRan
 * @date 2018-12-26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Api("ArticleListRespBody[文章列表返回类]")
public class ArticleListRespBody {

    @ApiModelProperty( value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "序号", required = true)
    private Integer order;

    @ApiModelProperty(value = "文章标题", required = true)
    private String title;

    @ApiModelProperty(value = "分类", required = true)
    private String type;

    @ApiModelProperty(value = "文章来源", required = true)
    private String source;

    @ApiModelProperty(value = "原文链接", required = true)
    private String originalUrl;

    @ApiModelProperty(value = "文章状态 [1.未发布，2.已发布，3.预发布]", required = true)
    private String state;

    @ApiModelProperty(value = "展示时间", required = true,example = "yyyy-MM-dd HH:mm:ss")
    private String showTime;

    @ApiModelProperty(value = "排序时间", required = true,example = "yyyy-MM-dd HH:mm:ss")
    private String sortTime;

    @ApiModelProperty(value = "发布者", required = true)
    private String userName;
}
