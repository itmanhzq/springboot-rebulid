package com.fenlibao.marketing.dto.req.publicize.frinedlink;

import com.fenlibao.base.dto.BaseReq;
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
@Api("FriendLinkDeleteReq[删除友情链接请求类]")
public class FriendLinkDeleteReq extends BaseReq {
    @ApiModelProperty(value = "友情链接Id", required = true)
    @NotBlank(message = "友情链接Id不能为空")
    private List<Integer> ids;
}
