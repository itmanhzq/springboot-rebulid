package com.fenlibao.pms.dto.req.stirmarketing.essay;

import com.fenlibao.pms.dto.base.AbstractPagingReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangBoRan
 * @date 2018-12-26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("GetEssayListReq[获取文章列表请求类]")
public class EssayGetListReq extends AbstractPagingReq {

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("发布者")
    private String userName;

    @ApiModelProperty("展示时间（开始）")
    private String showStartTime;

    @ApiModelProperty("展示时间（结束）")
    private String showEndTime;

    @ApiModelProperty("分类 [1.行业新闻，2.媒体报道，3.公司动态]")
    private Integer type;

    @ApiModelProperty("文章状态 [1.未发布，2.已发布，3.预发布]")
    private Integer status;
}
