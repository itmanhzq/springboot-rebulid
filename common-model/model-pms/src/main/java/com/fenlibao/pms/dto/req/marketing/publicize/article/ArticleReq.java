package com.fenlibao.pms.dto.req.marketing.publicize.article;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author WangBoRan
 * @date 2018-12-26
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleReq extends BaseReq {

    @ApiModelProperty(value = "文章标题", required = true)
    @NotBlank(message = "文章标题不能为空")
    private String title;

    @ApiModelProperty(value = "文章类型 [1.行业新闻，2.媒体报道，3.公司动态]", required = true)
    @NotBlank(message = "请选择文章类型")
    private Integer type;

    @ApiModelProperty(value = "文章来源", required = true)
    @NotBlank(message = "文章来源不能为空")
    private String source;

    @ApiModelProperty(value = "文章作者")
    private String author;

    @ApiModelProperty("原文链接")
    private String originalUrl;

    @ApiModelProperty(value = "展示时间", required = true)
    @NotBlank(message = "展示时间不能为空")
    private Date showTime;

    @ApiModelProperty(value = "列表页图片", required = true)
    @NotBlank(message = "列表页图片不能为空")
    private String imageUrl;

    @ApiModelProperty(value = "排序时间", required = true)
    @NotBlank(message = "排序时间不能为空")
    private Date sortTime;

    @ApiModelProperty(value = "是否置顶 0:是; 1:否", required = true)
    @NotBlank(message = "是否置顶不能为空")
    private Boolean isStickTop;

    @ApiModelProperty(value = "文章状态 [1.未发布，2.已发布，3.预发布]", required = true)
    @NotBlank(message = "请选择文章状态")
    private Integer state;

    @ApiModelProperty(value = "预发布时间")
    private Date onlineTime;

    @ApiModelProperty(value = "文章关键字")
    private String keyword;

    @ApiModelProperty(value = "文章摘要")
    private String summary;

    @ApiModelProperty(value = "文章内容", required = true)
    @NotBlank(message = "文章内容不能为空")
    private String content;
}
