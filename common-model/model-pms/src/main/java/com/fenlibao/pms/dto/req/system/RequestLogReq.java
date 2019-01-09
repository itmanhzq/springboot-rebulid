package com.fenlibao.pms.dto.req.system;

import com.fenlibao.base.dto.AbstractPagingReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangBoRan
 * @date 2018-12-20
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("RequestLogReq[访问日志请求类]")
public class RequestLogReq extends AbstractPagingReq {

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

}
