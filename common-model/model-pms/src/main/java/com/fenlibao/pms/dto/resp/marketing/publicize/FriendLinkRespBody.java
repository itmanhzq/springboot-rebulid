package com.fenlibao.pms.dto.resp.marketing.publicize;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Api("FriendLinkRespBody[获取友情链接返回类]")
public class FriendLinkRespBody extends BaseReq {

    @ApiModelProperty( value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "网站名称", required = true)
    private String websiteName;

    @ApiModelProperty(value = "链接地址", required = true)
    private String url;

    @ApiModelProperty(value = "位置排序", required = true)
    private Integer sort;

}
