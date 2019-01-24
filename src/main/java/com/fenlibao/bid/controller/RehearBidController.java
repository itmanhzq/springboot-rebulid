package com.fenlibao.bid.controller;

import com.fenlibao.base.dto.Response;
import com.fenlibao.bid.dto.req.ReviewBidReq;
import com.fenlibao.bid.dto.resp.RehearListRespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 复审列表接口
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@RestController
@RequestMapping("/rehearBid")
@Api(tags = {"复审列表接口"})
public class RehearBidController {
    @PostMapping("/rehearList")
    @ApiOperation("复审列表")
    public Response<RehearListRespBody> rehearList(@RequestBody ReviewBidReq req) {
        return null;
    }

}
