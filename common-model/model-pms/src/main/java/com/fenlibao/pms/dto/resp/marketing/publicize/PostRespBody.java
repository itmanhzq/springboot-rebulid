package com.fenlibao.pms.dto.resp.marketing.publicize;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
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

    @ApiModelProperty(value = "展示时间", required = true)
    private Date showTime;

    @ApiModelProperty(value = "排序时间", required = true)
    private Date sortTime;

    @ApiModelProperty(value = "是否置顶 0:是; 1:否", required = true)
    private Integer topPlace;

    @ApiModelProperty(value = "公告状态 [1.未发布，2.已发布，3.预发布]", required = true)
    private String state;

    @ApiModelProperty(value = "预发布时间")
    private Date onlineTime;

    @ApiModelProperty(value = "公告关键字")
    private String keyWord;

    @ApiModelProperty(value = "公告摘要", required = true)
    private String summary;

    @ApiModelProperty(value = "文章内容", required = true)
    private String content;
}
