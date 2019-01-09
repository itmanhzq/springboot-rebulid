package com.fenlibao.pms.dto.req.marketing.publicize.article;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author WangBoRan
 * @date 2018-12-28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("ArticleStickTopReq[设置文章置顶请求类]")
public class ArticleStickTopReq extends BaseReq {

    @ApiModelProperty(value = "是否置顶 true:是; false:否", required = true)
    @NotBlank(message = "是否置顶不能为空")
    private Boolean isStickTop;

    @ApiModelProperty(value = "文章Id", required = true)
    @NotBlank(message = "文章Id不能为空")
    private Integer id;
}
