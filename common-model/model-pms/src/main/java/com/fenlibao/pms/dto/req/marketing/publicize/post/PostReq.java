package com.fenlibao.pms.dto.req.marketing.publicize.post;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostReq extends BaseReq {

    @ApiModelProperty(value = "公告标题", required = true)
    @NotBlank(message = "公告标题不能为空")
    private String title;

    @ApiModelProperty(value = "展示时间", required = true,example = "yyyy-MM-dd HH:mm:ss")
    @NotBlank(message = "展示时间不能为空")
    private String showTime;

    @ApiModelProperty(value = "排序时间", required = true,example = "yyyy-MM-dd HH:mm:ss")
    @NotBlank(message = "排序时间不能为空")
    private String sortTime;

    @ApiModelProperty(value = "是否置顶 true:是; false:否", required = true)
    @NotBlank(message = "是否置顶不能为空")
    private Boolean topPlace;

    @ApiModelProperty(value = "公告状态 [1.未发布，2.已发布，3.预发布]", required = true)
    @NotBlank(message = "请选择文章状态")
    private Integer status;

    @ApiModelProperty(value = "预发布时间",example = "yyyy-MM-dd HH:mm:ss")
    private String onlineTime;

    @ApiModelProperty(value = "公告关键字")
    private String keyWord;

    @ApiModelProperty(value = "公告摘要", required = true)
    @NotBlank(message = "公告摘要不能为空")
    private String summary;

    @ApiModelProperty(value = "文章内容", required = true)
    @NotBlank(message = "文章内容不能为空")
    private String context;
}
