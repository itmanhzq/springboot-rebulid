package com.fenlibao.marketing.dto.resp.publicize;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @ApiModelProperty(value = "展示时间", required = true)
    private Date showTime;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @ApiModelProperty(value = "排序时间", required = true)
    private Date sortTime;

    @ApiModelProperty(value = "发布者", required = true)
    private String userName;

    @ApiModelProperty(value = "是否置顶 true:是; false:否", required = true)
    private Boolean isStickTop;

    @ApiModelProperty(value = "user_id")
    private Integer userId;
}
