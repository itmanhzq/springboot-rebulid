package com.fenlibao.pms.dto.req.marketing.publicize.frinedlink;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("FriendLinkAddReq[添加友情链接请求类]")
public class FriendLinkAddReq extends FriendLinkReq {
    @ApiModelProperty(value = "user_id")
    private Integer userId;
}
