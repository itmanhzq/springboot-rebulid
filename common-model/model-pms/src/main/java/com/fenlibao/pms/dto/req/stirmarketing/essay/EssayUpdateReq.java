package com.fenlibao.pms.dto.req.stirmarketing.essay;

import io.swagger.annotations.ApiModel;
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
@ApiModel("UpdateEssayReq[修改文章请求类]")
public class EssayUpdateReq extends EssayReq {

    @ApiModelProperty(value = "文章Id", required = true)
    @NotBlank(message = "文章Id不能为空")
    private Integer id;

}
