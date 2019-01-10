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
 * @author Flynn
 * @date 2018/11/19
 */
@Slf4j
@RestController
@RequestMapping("/xinwang")
public class XinwangController {

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

    @ApiOperation("单笔查询")
    @PostMapping("/queryTransaction")
    public Response queryTransaction(@RequestBody QueryTransaction req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("充值")
    @PostMapping("/recharge")
    public Response recharge(@RequestBody Recharge req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("提现")
    @PostMapping("/withdraw")
    public Response withdraw(@RequestBody Withdraw req) {
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

    @ApiOperation("解绑银行卡")
    @PostMapping("/modifyMobileExpand")
    public Response modifyMobileExpand(@RequestBody ModifyMobileExpand req) {
        try {
            return xinwangService.gatewayRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
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


    @ApiOperation("创建标的")
    @PostMapping("/establishProject")
    public Response establishProject(@RequestBody EstablishProject req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
        }
    }

    @ApiOperation("标的信息查询")
    @PostMapping("/queryProjectInformation")
    public Response queryProjectInformation(@RequestBody QueryProjectInformation req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
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

    @ApiOperation("单笔交易")
    @PostMapping("/syncTransaction")
    public Response syncTransaction(@RequestBody SyncTransaction req) {
        try {
            return xinwangService.serviceRequest(req);
        } catch (Exception e) {
            return Response.error(e.getMessage());
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
}
