package com.fenlibao.pms.controller.marketing.publicize;

import com.fenlibao.base.dto.Response;
import com.fenlibao.marketing.dto.req.publicize.article.*;
import com.fenlibao.marketing.dto.resp.publicize.ArticleListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.ArticleRespBody;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.service.marketing.publicize.ArticleService;
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
@RequestMapping("/marketing/publicize/article")
@Api(tags = {"文章管理接口"})
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("文章列表")
    @PostMapping("/getArticleList")
    @PreAuthorize("hasPermission('article','view')")
    @ApiResponse(code = 200, message = "请求成功", response = ArticleListRespBody.class)
    public Response<PageInfo<ArticleListRespBody>> getArticleList(@RequestBody @Valid ArticleGetListReq articleGetListReq) {
        return Response.ok(articleService.getArticleList(articleGetListReq));
    }

    @ApiOperation("查询文章")
    @PostMapping("/getArticle")
    @PreAuthorize("hasPermission('article','view')")
    @ApiResponse(code = 200, message = "请求成功", response = ArticleRespBody.class)
    public Response<ArticleRespBody> getArticle(@RequestBody @Valid ArticleGetReq articleGetReq) {
        return Response.ok(articleService.getArticle(articleGetReq));
    }

    @ApiOperation("新增文章")
    @PostMapping("/addArticle")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> addArticle(@ApiIgnore @CurrentUser UserPrincipal currentUser, @RequestBody @Valid ArticleAddReq essayAddReq) {
        essayAddReq.setUserId(currentUser.getUserBO().getId());
        return Response.ok(articleService.addArticle(essayAddReq));
    }

    @ApiOperation("修改文章")
    @PostMapping("/updateArticle")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> updateArticle(@RequestBody @Valid ArticleUpdateReq articleUpdateReq) {
        return Response.ok(articleService.updateArticle(articleUpdateReq));
    }

    @ApiOperation("设置文章置顶状态")
    @PostMapping("/topPlaceArticle")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> topPlaceArticle(@RequestBody @Valid ArticleStickTopReq articleStickTopReq) {
        return Response.ok(articleService.topPlaceArticle(articleStickTopReq));
    }

    @ApiOperation("删除文章")
    @PostMapping("/deleteArticle")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> deleteArticle(@RequestBody @Valid ArticleDeleteReq articleDeleteReq) {
        return Response.ok(articleService.deleteArticle(articleDeleteReq));
    }
}
