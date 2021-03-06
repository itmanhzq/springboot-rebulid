package com.fenlibao.pms.controller.marketing.publicize;

import com.fenlibao.base.dto.Response;
import com.fenlibao.marketing.dto.req.publicize.frinedlink.*;
import com.fenlibao.marketing.dto.resp.publicize.FriendLinkListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.FriendLinkRespBody;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.service.marketing.publicize.FriendLinkService;
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
import springfox.documentation.annotations.ApiIgnore;

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

    @Autowired
    private FriendLinkService friendLinkService;

    @ApiOperation("友情链接列表")
    @PostMapping("/getFriendLinkList")
    @PreAuthorize("hasPermission('friendLink','view')")
    @ApiResponse(code = 200, message = "请求成功", response = FriendLinkListRespBody.class)
    public Response<PageInfo<FriendLinkListRespBody>> getFriendLinkList(@RequestBody @Valid FriendLinkGetListReq friendLinkGetListReq) {
        return Response.ok(friendLinkService.getFriendLinkList(friendLinkGetListReq));
    }

    @ApiOperation("查询友情链接")
    @PostMapping("/getFriendLink")
    @ApiResponse(code = 200, message = "请求成功", response = FriendLinkRespBody.class)
    public Response<FriendLinkRespBody> getFriendLink(@RequestBody @Valid FriendLinkGetReq friendLinkGetReq) {
        return Response.ok(friendLinkService.getFriendLink(friendLinkGetReq));
    }

    @ApiOperation("新增友情链接")
    @PostMapping("/addFriendLink")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> addFriendLink(@ApiIgnore @CurrentUser UserPrincipal currentUser, @RequestBody @Valid FriendLinkAddReq friendLinkAddReq) {
        friendLinkAddReq.setUserId(currentUser.getUserBO().getId());
        return Response.ok(friendLinkService.addFriendLink(friendLinkAddReq));
    }

    @ApiOperation("修改友情链接")
    @PostMapping("/updateFriendLink")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> updateFriendLink(@RequestBody @Valid FriendLinkUpdateReq friendLinkUpdateReq) {
        return Response.ok(friendLinkService.updateFriendLink(friendLinkUpdateReq));
    }

    @ApiOperation("删除友情链接")
    @PostMapping("/deleteFriendLink")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> deleteFriendLink(@RequestBody @Valid FriendLinkDeleteReq friendLinkDeleteReq) {
        return Response.ok(friendLinkService.deleteFriendLink(friendLinkDeleteReq));
    }
}
