package com.fenlibao.pms.dto.req.marketing.publicize.article;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.ApiModel;
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
@ApiModel("ArticleDeleteReq[删除文章请求类]")
public class ArticleDeleteReq extends BaseReq {

    @ApiModelProperty(value = "文章Id", required = true)
    @NotBlank(message = "文章Id不能为空")
    private List<Integer> ids;
}
