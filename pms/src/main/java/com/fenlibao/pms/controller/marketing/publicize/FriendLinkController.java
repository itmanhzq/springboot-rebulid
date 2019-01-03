package com.fenlibao.pms.controller.marketing.publicize;

import com.fenlibao.pms.dto.base.Response;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.dto.req.stirmarketing.frinedlink.FriendLinkDeleteReq;
import com.fenlibao.pms.dto.req.stirmarketing.frinedlink.FriendLinkGetListReq;
import com.fenlibao.pms.dto.req.stirmarketing.frinedlink.FriendLinkAddReq;
import com.fenlibao.pms.dto.req.stirmarketing.frinedlink.FriendLinkUpdateReq;
import com.fenlibao.pms.dto.resp.stirmarketing.FriendLinkRespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
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

    @ApiOperation("友情链接列表")
    @PostMapping("/getFriendLink")
    @PreAuthorize("hasPermission('friendLink','view')")
    @ApiResponse(code = 200, message = "请求成功", response = FriendLinkRespBody.class)
    public Response<FriendLinkRespBody> getFriendLink(@RequestBody @Valid FriendLinkGetListReq getEssayListReq) {
        return Response.ok();
    }

    @ApiOperation("新增友情链接")
    @PostMapping("/addFriendLink")
    @PreAuthorize("hasPermission('friendLink','add')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> addFriendLink(@ApiIgnore @CurrentUser UserPrincipal currentUser,
                                      @RequestBody @Valid FriendLinkAddReq friendLinkAddReq) {

        return Response.ok();
    }

    @ApiOperation("修改友情链接")
    @PostMapping("/updateFriendLink")
    @PreAuthorize("hasPermission('friendLink','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> updateFriendLink(@ApiIgnore @CurrentUser UserPrincipal currentUser,
                                         @RequestBody @Valid FriendLinkUpdateReq friendLinkUpdateReq) {

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
