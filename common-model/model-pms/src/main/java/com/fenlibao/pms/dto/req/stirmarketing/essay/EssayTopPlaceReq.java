package com.fenlibao.pms.dto.req.stirmarketing.essay;

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
@Api("BulletinStatusReq[设置文章置顶请求类]")
public class EssayTopPlaceReq extends BaseReq {
    @ApiModelProperty(value = "是否置顶 0:是; 1:否", required = true)
    @NotBlank(message = "是否置顶不能为空")
    private Boolean topPlace;
}
