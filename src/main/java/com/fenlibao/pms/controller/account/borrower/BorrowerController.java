package com.fenlibao.pms.controller.account.borrower;

import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.user.dto.req.borrower.BorrowerDetailReq;
import com.fenlibao.user.dto.req.borrower.DefriendReq;
import com.fenlibao.user.dto.req.borrower.SearchBorrowerReq;
import com.fenlibao.pms.dto.resp.SignUpRespBody;
import com.fenlibao.user.dto.resp.borrower.BorrowerInfoRespBody;
import com.fenlibao.user.dto.resp.borrower.EnterpriseDetailRespBody;
import com.fenlibao.user.dto.resp.borrower.PersonalDetailRespBody;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


/**
 * @author Toby
 * @date 2018/11/13
 */
@Slf4j
@RestController
@RequestMapping("/borrower")
@Api(tags = {"借款用户管理"})
public class BorrowerController {

    @ApiOperation("查询借款用户列表")
    @ApiResponse(code = 200, message = "请求成功", response = BorrowerInfoRespBody.class)
    @PostMapping("/list")
    public Response<PageInfo<BorrowerInfoRespBody>> borrowerList(@Valid @RequestBody SearchBorrowerReq searchBorrowerReq) {
        try {
            return Response.ok("hello");
        } catch (Exception e) {
            log.error("获取列表失败", e);
        }
        return Response.error("获取列表失败");
    }

    @ApiOperation("拉黑/取消拉黑")
    @ApiResponse(code = 200, message = "请求成功", response = SignUpRespBody.class)
    @PostMapping("/defriend")
    public Response<SignUpRespBody> defriend(@Valid @RequestBody DefriendReq defriendReq) {
       try {
            return Response.ok(ResponseStatus.COMMON_OPERATION_SUCCESS);
        } catch (Exception e) {
            log.error("拉黑成功：", e);
        }
        return Response.error(ResponseStatus.COMMON_UPDATE_ERROR.getMsg());
    }

    @ApiOperation("个人借款人信息")
    @ApiResponse(code = 200, message = "请求成功", response = PersonalDetailRespBody.class)
    @PostMapping("/personalBorrower")
    public Response<PersonalDetailRespBody> personalBorrower(@Valid @RequestBody BorrowerDetailReq detailReq) {
        try {
            return Response.ok(ResponseStatus.COMMON_OPERATION_SUCCESS);
        } catch (Exception e) {
            log.error("获取信息失败：", e);
        }
        return Response.error(ResponseStatus.COMMON_UPDATE_ERROR.getMsg());
    }


    @ApiOperation("企业借款人信息")
    @ApiResponse(code = 200, message = "请求成功", response = EnterpriseDetailRespBody.class)
    @PostMapping("/enteroriseBorrower")
    public Response<EnterpriseDetailRespBody> enteroriseBorrower(@Valid @RequestBody BorrowerDetailReq detailReq) {
        try {
            return Response.ok(ResponseStatus.COMMON_OPERATION_SUCCESS);
        } catch (Exception e) {
            log.error("获取信息失败：", e);
        }
        return Response.error(ResponseStatus.COMMON_UPDATE_ERROR.getMsg());
    }



}
