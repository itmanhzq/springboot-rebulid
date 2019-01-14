package com.fenlibao.pms.dto.req.marketing.publicize.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("PostAddReq[添加公告求类]")
public class PostAddReq extends PostReq {
    @ApiModelProperty(value = "user_id")
    private Integer userId;
}
