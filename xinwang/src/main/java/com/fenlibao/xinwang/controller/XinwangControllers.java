package com.fenlibao.xinwang.controller;

import com.fenlibao.base.dto.Response;
import com.fenlibao.xinwang.model.po.*;
import com.fenlibao.xinwang.service.XinwangService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 新网对接接口
 * @author hubert
 */
@Slf4j
@RestController
@RequestMapping("/xinwang")
public class XinwangControllers {

    @Resource
    private XinwangService xinwangService;

    @ApiOperation("取消债权转让")
    @PostMapping("/cancelDebentureSale")
    public Response queryByRequestNo(@RequestBody CancelDebentureSale req)  {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("取消债权转让失败",e);
            return Response.error("取消债权转让失败");
        }
    }

    @ApiOperation("个人换绑卡")
    @PostMapping("/personalBindBankcardExpand")
    public Response personalBindBankcardExpand(@RequestBody PersonalBindBankcardExpand req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("个人换绑卡失败",e);
            return Response.error("个人换绑卡失败");
        }
    }

    @ApiOperation("变更标的")
    @PostMapping("/modifyProject")
    public Response modifyProject(@RequestBody ModifyProject req) {
        try {
            return xinwangService.serviceRequest(req);
        }catch (Exception e){
            log.error("变更标的状态失败",e);
            return Response.error("变更标的失败");
        }
    }

    @ApiOperation("企业信息修改")
    @PostMapping("/enterpriseInformationUpdate")
    public Response enterpriseInformationUpdate(@RequestBody EnterpriseInformationUpdate req){
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("企业信息修改失败",e);
            return Response.error("企业信息修改失败");
        }
    }

    @ApiOperation("企业绑卡注册")
    @PostMapping("/enterpriseRegister")
    public Response enterpriseRegister(@RequestBody EnterpriseRegister req){
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("企业绑卡注册失败",e);
            return Response.error("企业绑卡注册失败");
        }
    }

    @ApiOperation("取消已冻结的预处理金额")
    @PostMapping("/cancelPreTransaction")
    public Response cancelPreTransaction(@RequestBody CancelPreTransaction req){
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("取消已冻结的预处理金额失败",e);
            return Response.error("取消已冻结的预处理金额失败");
        }
    }

    @ApiOperation("企业换绑卡")
    @PostMapping("/enterpriseBindBankcard")
    public Response enterpriseBindBankcard(@RequestBody EnterpriseBindBankcard req){
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("企业换绑卡失败",e);
            return Response.error("企业换绑卡失败");
        }
    }

    @ApiOperation("对账文件确认")
    @PostMapping("/confirmCheckfile")
    public Response confirmCheckfile(@RequestBody ConfirmCheckfile req){
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("对账文件确认失败",e);
            return Response.error("对账文件确认失败");
        }
    }

    @ApiOperation("会员激活")
    @PostMapping("/activateStockedUser")
    public Response activateStockedUser(@RequestBody ActivateStockedUser req){
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("会员激活失败",e);
            return Response.error("会员激活失败");
        }
    }

    @ApiOperation("解除用户自动授权")
    @PostMapping("/cancelUserAuthorization")
    public Response cancelUserAuthorization(@RequestBody CancelUserAuthorization req){
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("解除用户自动授权失败",e);
            return Response.error("解除用户自动授权失败");
        }
    }

    @ApiOperation("用户授权")
    @PostMapping("/userAuthorization")
    public Response userAuthorization(@RequestBody UserAuthorization req){
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("用户授权失败",e);
            return Response.error("用户授权失败");
        }
    }

    @ApiOperation("委托支付授权")
    @PostMapping("/authorizationEntrustPay")
    public Response authorizationEntrustPay(@RequestBody AuthorizationEntrustPay req){
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("委托支付授权失败",e);
            return Response.error("委托支付授权失败");
        }
    }

    @ApiOperation("委托支付授权记录查询")
    @PostMapping("/queryAuthorizationEntrustPayRecord")
    public Response queryAuthorizationEntrustPayRecord(@RequestBody QueryAuthorizationEntrustPayRecord req){
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("委托支付授权记录查询失败",e);
            return Response.error("委托支付授权记录查询失败");
        }
    }

}
