package com.fenlibao.pms.dto.req.stirmarketing.bulletion;

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
@ApiModel("UpdateBulletinReq[修改公告请求类]")
public class BulletinUpdateReq extends BulletinReq{

    @ApiModelProperty(value = "公告Id", required = true)
    @NotBlank(message = "公告Id不能为空")
    private String id;
}
