package com.fenlibao.bid.controller;

import com.fenlibao.base.dto.Response;
import com.fenlibao.bid.dto.req.BorrowerReq;
import com.fenlibao.bid.dto.req.BorrowingListReq;
import com.fenlibao.bid.dto.req.BorrowingReq;
import com.fenlibao.bid.dto.req.NewBorrowingReq;
import com.fenlibao.bid.dto.resp.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 标的发布控制器
 *
 * @author LeiXinXin
 * @date 2019/1/22
 */
@RestController
@RequestMapping("/loanManagement")
@Api(tags = {"借款管理接口"})
public class LoanManagementController {

    @PostMapping("/newBorrowing")
    @ApiOperation("新增借款")
    public Response newBorrowing(@Valid @RequestBody NewBorrowingReq req) {
        return null;
    }

    @PostMapping("/queryBorrowingList")
    @ApiOperation("借款管理列表")
    public Response<BorrowingRespBody> queryBorrowingList(@RequestBody BorrowingListReq req) {
        return null;
    }

    @PostMapping("/view")
    @ApiOperation("查看单个借款信息")
    public Response<ViewBorrowingRespBody> view(@Valid @RequestBody BorrowingReq req) {
        return null;
    }

    @PostMapping("/saveTempBorrowing")
    @ApiOperation("临时保存借款信息")
    public Response saveTempBorrowing(@Valid @RequestBody NewBorrowingReq req) {
        return null;
    }

    @PostMapping("/borrowerList")
    @ApiOperation("借款人列表")
    public Response<BorrowerRespBody> borrowerList(@RequestBody BorrowerReq req) {
        return null;
    }

    @PostMapping("/incomerList")
    @ApiOperation("进件人列表")
    public Response<IncomerListRespBody> incomerList() {
        return null;
    }

    @PostMapping("/regionalLocation")
    @ApiOperation("项目区域列表")
    public Response<RegionalLocationRespBody> regionalLocation() {
        return null;
    }
}
