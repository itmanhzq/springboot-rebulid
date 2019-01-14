package com.fenlibao.marketing.controller.publicize;

import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.dto.req.marketing.publicize.frinedlink.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkRespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author WangBoRan
 * @date 2018-12-26
 */

@Slf4j
@RestController
@RequestMapping("/marketing/publicize/friendLink")
@Api(tags = {"友情链接查询接口"})
public class FriendLinkController {

    @ApiOperation("友情链接列表")
    @PostMapping("/getFriendLinkList")
    @PreAuthorize("hasPermission('friendLink','view')")
    @ApiResponse(code = 200, message = "请求成功", response = FriendLinkListRespBody.class)
    public Response<FriendLinkListRespBody> getFriendLink(@RequestBody @Valid FriendLinkGetListReq friendLinkGetListReq) {
        return Response.ok();
    }

    @ApiOperation("查询友情链接")
    @PostMapping("/getFriendLink")
    @PreAuthorize("hasPermission('friendLink','view')")
    @ApiResponse(code = 200, message = "请求成功", response = FriendLinkRespBody.class)
    public Response<FriendLinkRespBody> getFriendLink(@RequestBody @Valid FriendLinkGetReq friendLinkGetReq) {
        return Response.ok();
    }

    @ApiOperation("新增友情链接")
    @PostMapping("/addFriendLink")
    @PreAuthorize("hasPermission('friendLink','add')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> addFriendLink(@RequestBody @Valid FriendLinkAddReq friendLinkAddReq) {

        return Response.ok();
    }

    @ApiOperation("修改友情链接")
    @PostMapping("/updateFriendLink")
    @PreAuthorize("hasPermission('friendLink','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> updateFriendLink(@RequestBody @Valid FriendLinkUpdateReq friendLinkUpdateReq) {

        return Response.ok();
    }

    @ApiOperation("删除友情链接")
    @PostMapping("/deleteFriendLink")
    @PreAuthorize("hasPermission('friendLink','delete')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> deleteFriendLink(@RequestBody @Valid FriendLinkDeleteReq friendLinkDeleteReq) {
        return Response.ok();
    }
}
