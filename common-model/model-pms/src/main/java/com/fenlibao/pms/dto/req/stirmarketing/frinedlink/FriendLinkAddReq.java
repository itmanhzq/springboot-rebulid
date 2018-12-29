package com.fenlibao.pms.dto.req.stirmarketing.frinedlink;

import io.swagger.annotations.Api;
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
@Api("FriendLinkAddReq[添加友情链接请求类]")
public class FriendLinkAddReq extends FriendLinkReq {
    @ApiModelProperty(value = "友情链接Id", required = true)
    @NotBlank(message = "友情链接Id不能为空")
    private Integer id;
}
