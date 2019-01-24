package com.fenlibao.bid.controller;

import com.fenlibao.base.dto.Response;
import com.fenlibao.bid.dto.req.PublishBidManagementReq;
import com.fenlibao.bid.dto.resp.PublishBidListRespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发标管理接口
 *
 * @author LeiXinXin
 * @date 2019/1/24
 */
@RestController
@RequestMapping("/rehearBid")
@Api(tags = {"发标管理接口"})
public class PublishBidManagementController {
    @PostMapping("/bidManagement")
    @ApiOperation("发标管理列表")
    public Response<PublishBidListRespBody> bidManagement(@RequestBody PublishBidManagementReq req) {
        return null;
    }
}
