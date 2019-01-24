package com.fenlibao.pms.controller.bid;

import com.fenlibao.base.dto.Response;
import com.fenlibao.bid.dto.req.InitialReviewBidInfoSaveReq;
import com.fenlibao.bid.dto.req.InitialReviewBidListReq;
import com.fenlibao.bid.dto.req.ReviewBidReq;
import com.fenlibao.bid.dto.resp.ReviewBidInfoRespBody;
import com.fenlibao.bid.dto.resp.InitialReviewListRespBody;
import com.fenlibao.bid.dto.resp.ReviewBorrowingRespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 初审列表
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@RestController
@RequestMapping("/initialReview")
@Api(tags = {"初审列表接口"})
public class InitialReviewController {
    @PostMapping("/initialReviewList")
    @ApiOperation("初审列表")
    public Response<InitialReviewListRespBody> initialReviewList(@RequestBody InitialReviewBidListReq req) {
        return null;
    }

    @PostMapping("/review")
    @ApiOperation("审核")
    public Response<ReviewBidInfoRespBody> review(@Valid @RequestBody ReviewBidReq req) {
        return null;
    }

    @PostMapping("/commitReview")
    @ApiOperation("提交审核")
    public Response commitReview(@Valid @RequestBody InitialReviewBidInfoSaveReq req) {
        return null;
    }

    @PostMapping("/view")
    @ApiOperation("查看项目信息")
    public Response<ReviewBorrowingRespBody> view(@Valid @RequestBody ReviewBidReq req) {
        return null;
    }
}
