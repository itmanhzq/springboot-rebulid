package com.fenlibao.pms.dto.req.stirmarketing.frinedlink;

import com.fenlibao.pms.dto.base.BaseReq;
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
public class FriendLinkReq extends BaseReq {

    @ApiModelProperty(value = "网站名称", required = true)
    @NotBlank(message = "网站名称不能为空")
    private String websiteName;

    @ApiModelProperty(value = "链接地址", required = true)
    @NotBlank(message = "链接地址不能为空")
    private String url;

    @ApiModelProperty(value = "位置排序", required = true)
    @NotBlank(message = "位置排序不能为空")
    private Integer sort;

}
