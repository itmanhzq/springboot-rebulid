package com.fenlibao.pms.controller.marketing.publicize;

import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.dto.req.marketing.publicize.post.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostRespBody;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostListRespBody;
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
 * @date 2018-12-27
 */
@Slf4j
@RestController
@RequestMapping("/marketing/publicize/post")
@Api(tags = {"公告管理接口"})
public class PostController {

    @ApiOperation("公告列表")
    @PostMapping("/getPostList")
    @PreAuthorize("hasPermission('post','view')")
    @ApiResponse(code = 200, message = "请求成功", response = PostListRespBody.class)
    public Response<PostListRespBody> getPostList(@RequestBody @Valid PostGetListReq postGetListReq) {
        return Response.ok();
    }

    @ApiOperation("查询公告")
    @PostMapping("/getPost")
    @PreAuthorize("hasPermission('post','view')")
    @ApiResponse(code = 200, message = "请求成功", response = PostRespBody.class)
    public Response<PostRespBody> getPost(@RequestBody @Valid PostGetReq postGetReq) {
        return Response.ok();
    }

    @ApiOperation("新增公告")
    @PostMapping("/addPost")
    @PreAuthorize("hasPermission('post','add')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> addPost(@ApiIgnore @CurrentUser UserPrincipal currentUser,
                                      @RequestBody @Valid PostAddReq bulletinAddReq) {

        return Response.ok();
    }

    @ApiOperation("修改公告")
    @PostMapping("/updatePost")
    @PreAuthorize("hasPermission('post','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> updatePost(@ApiIgnore @CurrentUser UserPrincipal userPrincipal,
                                         @RequestBody @Valid PostUpdateReq postUpdateReq) {

        return Response.ok();
    }

    @ApiOperation("设置公告置顶状态")
    @PostMapping("/stickTopPost")
    @PreAuthorize("hasPermission('post','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> stickTopPost(@ApiIgnore @CurrentUser UserPrincipal userPrincipal,
                                            @RequestBody @Valid PostStickTopReq postStickTopReq) {

        return Response.ok();
    }

    @ApiOperation("删除公告")
    @PostMapping("/deletePost")
    @PreAuthorize("hasPermission('post','delete')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> deletePost(@RequestBody @Valid PostDeleteReq postDeleteReq) {
        return Response.ok();
    }

}
