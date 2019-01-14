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

/**
 * 交易接口
 */
@Slf4j
@RestController
@RequestMapping("/xinwang")
public class TradingController {

    @Resource
    private XinwangService xinwangService;

    @ApiOperation("创建标的")
    @PostMapping("/establishProject")
    public Response establishProject(@RequestBody EstablishProject req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("变更标的")
    @PostMapping("/modifyProject")
    public Response modifyProject(@RequestBody ModifyProject req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("变更标的状态失败", e);
            return Response.error("变更标的失败");
        }
    }

    @ApiOperation("批量交易")
    @PostMapping("/asyncTransaction")
    public Response syncTransaction(@RequestBody AsyncTransaction req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("单笔债权出让")
    @PostMapping("/debentureSale")
    public Response debentureSale(@RequestBody DebentureSale req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("取消债权转让")
    @PostMapping("/cancelDebentureSale")
    public Response queryByRequestNo(@RequestBody CancelDebentureSale req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("取消债权转让失败", e);
            return Response.error("取消债权转让失败");
        }
    }

    @ApiOperation("单笔交易")
    @PostMapping("/syncTransaction")
    public Response syncTransaction(@RequestBody SyncTransaction req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("用户授权")
    @PostMapping("/userAuthorization")
    public Response userAuthorization(@RequestBody UserAuthorization req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            log.error("用户授权失败", e);
            return Response.error("用户授权失败");
        }
    }

    @ApiOperation("授权预处理")
    @PostMapping("/userAutoPreTransaction")
    public Response userAutoPreTransaction(@RequestBody UserAutoPreTransaction req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("对账文件确认")
    @PostMapping("/confirmCheckfile")
    public Response confirmCheckfile(@RequestBody ConfirmCheckfile req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("对账文件确认失败", e);
            return Response.error("对账文件确认失败");
        }
    }

    @ApiOperation("下载对账文件")
    @PostMapping("/downloadCheckFile")
    public Response modifyMobileExpand(@RequestBody DownloadCheckFile req) {
        try {
            return xinwangService.download(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("委托支付授权")
    @PostMapping("/authorizationEntrustPay")
    public Response authorizationEntrustPay(@RequestBody AuthorizationEntrustPay req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("委托支付授权失败", e);
            return Response.error("委托支付授权失败");
        }
    }

    @ApiOperation("委托支付授权记录查询")
    @PostMapping("/queryAuthorizationEntrustPayRecord")
    public Response queryAuthorizationEntrustPayRecord(@RequestBody QueryAuthorizationEntrustPayRecord req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("委托支付授权记录查询失败", e);
            return Response.error("委托支付授权记录查询失败");
        }
    }

    @ApiOperation("取消已冻结的预处理金额")
    @PostMapping("/cancelPreTransaction")
    public Response cancelPreTransaction(@RequestBody CancelPreTransaction req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("取消已冻结的预处理金额失败", e);
            return Response.error("取消已冻结的预处理金额失败");
        }
    }

    @ApiOperation("解除用户自动授权")
    @PostMapping("/cancelUserAuthorization")
    public Response cancelUserAuthorization(@RequestBody CancelUserAuthorization req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            log.error("解除用户自动授权失败", e);
            return Response.error("解除用户自动授权失败");
        }
    }

}
