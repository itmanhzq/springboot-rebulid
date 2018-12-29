package com.fenlibao.pms.dto.req.system;

import com.fenlibao.pms.dto.base.AbstractPagingReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangBoRan
 * @date 2018-12-20
 */
@Data
@Api("访问日志请求类")
public class RequestLogReq extends AbstractPagingReq {

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

}
