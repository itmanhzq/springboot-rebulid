package com.fenlibao.pms.dto.resp.marketing.publicize;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

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

    @ApiModelProperty(value = "展示时间", required = true,example = "yyyy-MM-dd HH:mm:ss")
    private String showTime;

    @ApiModelProperty(value = "排序时间", required = true,example = "yyyy-MM-dd HH:mm:ss")
    private String sortTime;

    @ApiModelProperty(value = "是否置顶 true:是; false:否", required = true)
    private Boolean topPlace;

    @ApiModelProperty(value = "公告状态 [1.未发布，2.已发布，3.预发布]", required = true)
    private Integer status;

    @ApiModelProperty(value = "预发布时间",example = "yyyy-MM-dd HH:mm:ss")
    private String onlineTime;

    @ApiModelProperty(value = "公告关键字")
    private String keyWord;

    @ApiModelProperty(value = "公告摘要", required = true)
    private String summary;

    @ApiModelProperty(value = "文章内容", required = true)
    private String context;
}
