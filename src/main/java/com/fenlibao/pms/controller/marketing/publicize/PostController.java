package com.fenlibao.pms.controller.marketing.publicize;


import com.fenlibao.base.dto.Response;
import com.fenlibao.marketing.dto.req.publicize.post.*;
import com.fenlibao.marketing.dto.resp.publicize.PostListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.PostRespBody;
import com.fenlibao.pms.service.marketing.publicize.PostService;
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
 * @date 2018-12-27
 */
@Slf4j
@RestController
@RequestMapping("/marketing/publicize/post")
@Api(tags = {"公告管理接口"})
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation("公告列表")
    @PostMapping("/getPostList")
    @PreAuthorize("hasPermission('post','view')")
    @ApiResponse(code = 200, message = "请求成功", response = PostListRespBody.class)
    public Response<PageInfo<PostListRespBody>> getPostList(@RequestBody @Valid PostGetListReq postGetListReq) {
        return Response.ok(postService.getPostList(postGetListReq));
    }

    @ApiOperation("查询公告")
    @PostMapping("/getPost")
    @ApiResponse(code = 200, message = "请求成功", response = PostListRespBody.class)
    public Response<PostRespBody> getPost(@RequestBody @Valid PostGetReq postGetReq) {
        return Response.ok(postService.getPost(postGetReq));
    }

    @ApiOperation("新增公告")
    @PostMapping("/addPost")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> addPost(@RequestBody @Valid PostAddReq postAddReq) {

        return Response.ok(postService.addPost(postAddReq));
    }

    @ApiOperation("修改公告")
    @PostMapping("/updatePost")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> updatePost(@RequestBody @Valid PostUpdateReq postUpdateReq) {
        return Response.ok(postService.updatePost(postUpdateReq));
    }

    @ApiOperation("设置公告置顶状态")
    @PostMapping("/stickTopPost")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> stickTopPost(@RequestBody @Valid PostStickTopReq postStickTopReq) {
        return Response.ok(postService.stickTopPost(postStickTopReq));
    }

    @ApiOperation("删除公告")
    @PostMapping("/deletePost")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> deletePost(@RequestBody @Valid PostDeleteReq postDeleteReq) {
        return Response.ok(postService.deletePost(postDeleteReq));
    }

}
