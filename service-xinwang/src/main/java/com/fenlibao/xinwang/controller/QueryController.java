package com.fenlibao.xinwang.controller;

import com.fenlibao.base.dto.Response;
import com.fenlibao.xinwang.request.QueryProjectInformation;
import com.fenlibao.xinwang.request.QueryTransaction;
import com.fenlibao.xinwang.request.QueryUserInformation;
import com.fenlibao.xinwang.service.XinwangService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 查询接口
 */
@Slf4j
@RestController
@RequestMapping("/xinwang")
public class QueryController {

    @Resource
    private XinwangService xinwangService;

    @ApiOperation("用户信息查询")
    @PostMapping("/queryUserInformation")
    public Response queryUserInformation(@RequestBody QueryUserInformation req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("标的信息查询")
    @PostMapping("/queryProjectInformation")
    public Response queryProjectInformation(@RequestBody QueryProjectInformation req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("单笔查询")
    @PostMapping("/queryTransaction")
    public Response queryTransaction(@RequestBody QueryTransaction req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }
}
