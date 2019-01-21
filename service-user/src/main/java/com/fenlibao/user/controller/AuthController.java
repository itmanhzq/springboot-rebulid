package com.fenlibao.user.controller;
import com.fenlibao.base.dto.Response;
import com.fenlibao.user.common.json.ExtDataJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fenlibao.user.dto.base.ResponseStatus;

import javax.validation.Valid;

/**
 * @author chen
 * @date 2019/01/10
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = {"用户鉴权相关接口"})
public class AuthController {
}
