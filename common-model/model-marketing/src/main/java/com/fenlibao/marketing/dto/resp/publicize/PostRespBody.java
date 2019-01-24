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
 * @date 2018-12-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Api("PostRespBody[获取公告返回类]")
public class PostRespBody extends BaseReq {

    @ApiModelProperty( value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "公告标题", required = true)
    private String title;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @ApiModelProperty(value = "展示时间", required = true)
    private Date showTime;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @ApiModelProperty(value = "排序时间", required = true)
    private Date sortTime;

    @ApiModelProperty(value = "是否置顶 0:是; 1:否", required = true)
    private Integer topPlace;

    @ApiModelProperty(value = "公告状态 [1.未发布，2.已发布，3.预发布]", required = true)
    private String state;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @ApiModelProperty(value = "预发布时间")
    private Date onlineTime;

    @ApiModelProperty(value = "公告关键字")
    private String keyWord;

    @ApiModelProperty(value = "公告摘要", required = true)
    private String summary;

    @ApiModelProperty(value = "文章内容", required = true)
    private String content;
}
