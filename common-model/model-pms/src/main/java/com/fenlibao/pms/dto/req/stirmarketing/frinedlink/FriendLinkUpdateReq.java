package com.fenlibao.pms.dto.req.stirmarketing.frinedlink;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("FriendLinkUpdateReq[修改友情链接请求类]")
public class FriendLinkUpdateReq extends FriendLinkReq {
    @ApiModelProperty(value = "友情链接Id", required = true)
    @NotBlank(message = "友情链接Id不能为空")
    private List<Integer> id;
}
