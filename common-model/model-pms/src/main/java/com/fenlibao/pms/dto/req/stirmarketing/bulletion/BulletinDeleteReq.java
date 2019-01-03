package com.fenlibao.pms.dto.req.stirmarketing.bulletion;

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
@Api("DeleteBulletinReq[删除公告请求类]")
public class BulletinDeleteReq extends BaseReq {

    @ApiModelProperty(value = "公告Id", required = true)
    @NotBlank(message = "公告Id不能为空")
    private List<Integer> ids;

}
