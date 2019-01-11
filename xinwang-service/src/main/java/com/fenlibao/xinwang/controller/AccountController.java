package com.fenlibao.xinwang.controller;

import com.fenlibao.base.dto.Response;
import com.fenlibao.xinwang.request.*;
import com.fenlibao.xinwang.service.XinwangService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 账户接口
 */
@Slf4j
@RestController
@RequestMapping("/xinwang")
public class AccountController {

    @Resource
    private XinwangService xinwangService;

    @ApiOperation("个人绑卡注册")
    @PostMapping("/personalRegisterExpand")
    public Response personalRegisterExpand(@RequestBody @Valid PersonalRegisterExpand req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("企业绑卡注册")
    @PostMapping("/enterpriseRegister")
    public Response enterpriseRegister(@RequestBody EnterpriseRegister req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("企业绑卡注册失败", e);
            return Response.error("企业绑卡注册失败");
        }
    }

    @ApiOperation("个人换绑卡")
    @PostMapping("/personalBindBankcardExpand")
    public Response personalBindBankcardExpand(@RequestBody PersonalBindBankcardExpand req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("个人换绑卡失败", e);
            return Response.error("个人换绑卡失败");
        }
    }

    @ApiOperation("企业换绑卡")
    @PostMapping("/enterpriseBindBankcard")
    public Response enterpriseBindBankcard(@RequestBody EnterpriseBindBankcard req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("企业换绑卡失败", e);
            return Response.error("企业换绑卡失败");
        }
    }

    @ApiOperation("解绑银行卡")
    @PostMapping("/modifyMobileExpand")
    public Response modifyMobileExpand(@RequestBody ModifyMobileExpand req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("修改密码")
    @PostMapping("/resetPassword")
    public Response resetPassword(@RequestBody ResetPassword req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("企业信息修改")
    @PostMapping("/enterpriseInformationUpdate")
    public Response enterpriseInformationUpdate(@RequestBody EnterpriseInformationUpdate req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("企业信息修改失败", e);
            return Response.error("企业信息修改失败");
        }
    }

    @ApiOperation("会员激活")
    @PostMapping("/activateStockedUser")
    public Response activateStockedUser(@RequestBody ActivateStockedUser req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("会员激活失败", e);
            return Response.error("会员激活失败");
        }
    }

}
