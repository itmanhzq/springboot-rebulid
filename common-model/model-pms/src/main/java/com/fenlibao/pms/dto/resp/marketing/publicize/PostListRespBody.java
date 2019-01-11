package com.fenlibao.pms.dto.resp.marketing.publicize;

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
@Api("PostListRespBody[公告列表返回类]")
public class PostListRespBody {

    @ApiModelProperty( value = "id", required = true)
    private Integer id;

    @ApiModelProperty( value = "序号", required = true)
    private Integer order;

    @ApiModelProperty(value = "公告标题", required = true)
    private String title;

    @ApiModelProperty(value = "公告摘要", required = true)
    private String summary;

    @ApiModelProperty(value = "公告状态", required = true)
    private String state;

    @ApiModelProperty(value = "展示时间", required = true)
    private Date showTime;

    @ApiModelProperty(value = "排序时间", required = true)
    private Date sortTime;

    @ApiModelProperty(value = "发布者", required = true)
    private String userName;

    @ApiModelProperty(value = "是否置顶 true:是; false:否", required = true)
    private Boolean isStickTop;

    @ApiModelProperty(value = "user_id")
    private String userId;
}
