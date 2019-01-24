package com.fenlibao.marketing.dto.req.publicize.article;

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
@ApiModel("ArticleAddReq[新增文章请求类]")
public class ArticleAddReq extends ArticleReq {
    @ApiModelProperty(value = "user_id")
    private Integer userId;
}
