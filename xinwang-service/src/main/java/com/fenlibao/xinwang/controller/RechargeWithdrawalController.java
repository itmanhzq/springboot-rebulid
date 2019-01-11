package com.fenlibao.xinwang.controller;

import com.fenlibao.base.dto.Response;
import com.fenlibao.xinwang.request.Recharge;
import com.fenlibao.xinwang.request.Withdraw;
import com.fenlibao.xinwang.service.XinwangService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 充提接口
 */
@Slf4j
@RestController
@RequestMapping("/xinwang")
public class RechargeWithdrawalController {

    @Resource
    private XinwangService xinwangService;

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
}
