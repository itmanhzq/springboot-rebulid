package com.fenlibao.marketing.dto.req.publicize.article;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author WangBoRan
 * @date 2018-12-26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("ArticleGetReq[获取文章请求类]")
public class ArticleGetReq extends BaseReq {

    @ApiModelProperty(value = "文章Id", required = true)
    @NotBlank(message = "文章Id不能为空")
    private Integer id;

}
