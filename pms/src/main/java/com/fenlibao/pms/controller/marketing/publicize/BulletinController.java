package com.fenlibao.pms.controller.marketing.publicize;

import com.fenlibao.pms.dto.base.Response;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.dto.req.stirmarketing.bulletion.*;
import com.fenlibao.pms.dto.resp.stirmarketing.BulletinListRespBody;
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
@RequestMapping("/marketing/publicize/bulletin")
@Api(tags = {"公告管理接口"})
public class BulletinController  {

    @ApiOperation("公告列表")
    @PostMapping("/getBulletinList")
    @PreAuthorize("hasPermission('bulletin','view')")
    @ApiResponse(code = 200, message = "请求成功", response = BulletinListRespBody.class)
    public Response<BulletinListRespBody> getBulletinList(@RequestBody @Valid BulletinGetListReq bulletionGetListReq) {
        return Response.ok();
    }

    @ApiOperation("新增公告")
    @PostMapping("/addBulletin")
    @PreAuthorize("hasPermission('bulletin','add')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> addBulletin(@ApiIgnore @CurrentUser UserPrincipal currentUser,
                                      @RequestBody @Valid BulletinAddReq bulletinAddReq) {

        return Response.ok();
    }

    @ApiOperation("修改公告")
    @PostMapping("/updateBulletin")
    @PreAuthorize("hasPermission('bulletin','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> updateBulletin(@ApiIgnore @CurrentUser UserPrincipal currentUser,
                                         @RequestBody @Valid BulletinUpdateReq bulletinUpdateReq) {

        return Response.ok();
    }

    @ApiOperation("设置公告置顶状态")
    @PostMapping("/topPlaceBulletin")
    @PreAuthorize("hasPermission('bulletin','update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> topPlaceBulletin(@ApiIgnore @CurrentUser UserPrincipal currentUser,
                                            @RequestBody @Valid BulletinTopPlaceReq bulletinUpdateReq) {

        return Response.ok();
    }

    @ApiOperation("删除公告")
    @PostMapping("/deleteBulletin")
    @PreAuthorize("hasPermission('bulletin','delete')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    public Response<Boolean> deleteBulletin(@RequestBody @Valid BulletinDeleteReq bulletinDeleteReq) {
        return Response.ok();
    }

}
