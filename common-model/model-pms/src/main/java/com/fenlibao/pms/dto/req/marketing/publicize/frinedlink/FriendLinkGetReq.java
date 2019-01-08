package com.fenlibao.pms.dto.req.marketing.publicize.frinedlink;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author WangBoRan
 * @date 2019-01-08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("FriendLinkGetListReq[获取文章列表请求体]")
public class FriendLinkGetReq extends BaseReq {
    @ApiModelProperty(value = "友情链接Id", required = true)
    @NotBlank(message = "友情链接Id不能为空")
    private Integer id;
}
