package com.fenlibao.pms.controller.marketing.publicize;

import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.dto.req.marketing.publicize.article.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleRespBody;
import com.github.pagehelper.PageInfo;
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
@RequestMapping("/marketing/publicize/article")
@Api(tags = {"文章管理接口"})
public class ArticleController {

    @ApiOperation("文章列表")
    @PostMapping("/getArticleList")
    @ApiResponse(code = 200, message = "请求成功", response = ArticleListRespBody.class)
    public Response<PageInfo<ArticleListRespBody>> getArticleList(@RequestBody @Valid ArticleGetListReq essayGetListReq) {
        return Response.ok();
    }

    @ApiOperation("查询文章")
    @PostMapping("/getArticle")
    @PreAuthorize("hasPermission('article','view')")
    @ApiResponse(code = 200, message = "请求成功", response = ArticleRespBody.class)
    public Response<ArticleRespBody> getArticle(@RequestBody @Valid ArticleGetReq articleGetReq) {
        return Response.ok();
    }

    @ApiOperation("新增文章")
    @PostMapping("/addArticle")
    @PreAuthorize("hasPermission('article','add')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> addArticle(@RequestBody @Valid ArticleAddReq essayAddReq) {

        return Response.ok();
    }

    @ApiOperation("修改文章")
    @PostMapping("/updateArticle")
    @PreAuthorize("hasPermission('article','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> updateArticle(@RequestBody @Valid ArticleUpdateReq essayUpdateReq) {
        return Response.ok();
    }

    @ApiOperation("设置文章置顶状态")
    @PostMapping("/topPlaceArticle")
    @PreAuthorize("hasPermission('article','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> topPlaceArticle(@RequestBody @Valid ArticleStickTopReq bulletinUpdateReq) {

        return Response.ok();
    }

    @ApiOperation("删除文章")
    @PostMapping("/deleteArticle")
    @PreAuthorize("hasPermission('article','delete')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> deleteArticle(@RequestBody @Valid ArticleDeleteReq essayDeleteReq) {
        return Response.ok();
    }
}
