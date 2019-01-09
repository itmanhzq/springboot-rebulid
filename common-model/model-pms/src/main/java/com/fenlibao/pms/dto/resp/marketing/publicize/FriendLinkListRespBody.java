package com.fenlibao.pms.dto.resp.marketing.publicize;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Api("FriendLinkRespBody[友情链接列表返回类]")
public class FriendLinkListRespBody {

    @ApiModelProperty( value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "序号", required = true)
    private Integer order;

    @ApiModelProperty(value = "网站名称", required = true)
    private String websiteName;

    @ApiModelProperty(value = "浏览次数", required = true)
    private String views;

    @ApiModelProperty(value = "发布者", required = true)
    private String userName;

    @ApiModelProperty(value = "链接地址", required = true)
    private String url;

    @ApiModelProperty(value = "最后修改时间", required = true,example = "yyyy-MM-dd HH:mm:ss")
    private String updatedTime;

    @ApiModelProperty(value = "位置排序", required = true)
    private Integer sort;

}
