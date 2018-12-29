package com.fenlibao.pms.controller.marketing.publicize;

import com.fenlibao.pms.dto.base.Response;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.dto.req.stirmarketing.essay.*;
import com.fenlibao.pms.dto.resp.stirmarketing.EssayListRespBody;
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
@RequestMapping("/marketing/publicize/essay")
@Api(tags = {"文章管理接口"})
public class EssayController {

    @ApiOperation("文章列表")
    @PostMapping("/getEssayList")
    @PreAuthorize("hasPermission('essay','view')")
    @ApiResponse(code = 200, message = "请求成功", response = EssayListRespBody.class)
    public Response<EssayListRespBody> getEssayList(@RequestBody @Valid EssayGetListReq essayGetListReq) {
        return Response.ok();
    }

    @ApiOperation("新增文章")
    @PostMapping("/addEssay")
    @PreAuthorize("hasPermission('essay','add')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> addEssay(@ApiIgnore @CurrentUser UserPrincipal currentUser,
                                      @RequestBody @Valid EssayAddReq essayAddReq) {

        return Response.ok();
    }

    @ApiOperation("修改文章")
    @PostMapping("/updateEssay")
    @PreAuthorize("hasPermission('stirMarketing','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> updateEssay(@ApiIgnore @CurrentUser UserPrincipal currentUser,
                                         @RequestBody @Valid EssayUpdateReq essayUpdateReq) {
        return Response.ok();
    }

    @ApiOperation("设置文章置顶状态")
    @PostMapping("/topPlaceEssay")
    @PreAuthorize("hasPermission('essay','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> topPlaceEssay(@ApiIgnore @CurrentUser UserPrincipal currentUser,
                                              @RequestBody @Valid EssayTopPlaceReq bulletinUpdateReq) {

        return Response.ok();
    }

    @ApiOperation("删除文章")
    @PostMapping("/deleteEssay")
    @PreAuthorize("hasPermission('essay','delete')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> deleteEssay(@RequestBody @Valid EssayDeleteReq essayDeleteReq) {
        return Response.ok();
    }
}
