package com.fenlibao.pms.controller.system;

import com.fenlibao.pms.dto.base.Response;
import com.fenlibao.pms.service.system.RequestLogService;
import com.fenlibao.pms.dto.req.system.RequestLogReq;
import com.fenlibao.pms.dto.resp.system.RequestLogRespBody;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author WangBoRan
 * @date 2018-12-14
 */
@Slf4j
@RestController
@RequestMapping("/system/log")
@Api(tags = {"系统访问日志接口"})
public class RequestLogController {
    @Autowired
    private RequestLogService requestLogService;

    @ApiOperation("系统访问日志列表")
    @ApiResponse(code = 200, message = "请求成功", response = RequestLogRespBody.class)
    @PostMapping("/getLogList")
    @PreAuthorize("hasPermission('log','view')")
    public Response<RequestLogRespBody> getLogList(@RequestBody @Valid RequestLogReq requestLogReq) {
        PageInfo<RequestLogRespBody> requestLogRespBodies=requestLogService.getLogList(requestLogReq);
        return Response.ok(requestLogRespBodies);
    }


}
