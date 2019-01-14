package com.fenlibao.pms.controller;

import com.fenlibao.base.dto.Response;
import com.fenlibao.common.core.redis.RedisPrefix;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.dto.req.IdentifyReq;
import com.fenlibao.pms.dto.req.SigninReq;
import com.fenlibao.pms.dto.resp.SignUpRespBody;
import com.fenlibao.pms.dto.resp.SigninRespBody;
import com.fenlibao.pms.exception.BizException;
import com.fenlibao.pms.model.bo.IdentifyImageBO;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.model.enums.user.UserStatusEnum;
import com.fenlibao.pms.security.JwtTokenProvider;
import com.fenlibao.pms.service.IdentifyImageService;
import com.fenlibao.pms.service.TokenService;
import com.fenlibao.pms.service.system.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Toby
 * @date 2018/11/13
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
@Api(tags = {"用户授权认证相关接口"})
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IdentifyImageService identifyImageService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @ApiOperation("用户登录接口")
    @ApiResponse(code = 200, message = "请求成功", response = SigninRespBody.class)
    @PostMapping("/signin")
    public Response<SigninRespBody> authenticateUser(@Valid @RequestBody SigninReq loginRequest) {
        UserBO userBO = userService.getUser(loginRequest.getUserUniqueSign());
        Optional<Object> optional = Optional.ofNullable(userBO);
        if (optional.isPresent() && !userBO.getStatus().equals(UserStatusEnum.OPEN.getStatus())) {
            return Response.error(ResponseStatus.USER_NOT_LOGIN_STATUS);
        }

        //验证码是否通过
        String reidsKey = RedisPrefix.IDENTIFY_UUID.getPrefix().concat(loginRequest.getValidateId());
        String uuId = String.valueOf(redisTemplate.boundValueOps(reidsKey).get());
        if (!loginRequest.getValidateId().equals(uuId)) {
            return Response.error(ResponseStatus.USER_LOGIN_VALIDATE_ERROR);
        }

        try {
            //删除存在磁盘的用户缓存,重新获取用户数据
            tokenService.deleteCache(loginRequest.getUserUniqueSign());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUserUniqueSign(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateToken(authentication);
            //保存token到redis
            tokenService.saveTokenToReids(tokenProvider.getUserIdFromJWT(jwt), jwt);

            return Response.ok(SigninRespBody.get(jwt));
        } catch (AuthenticationException e) {
            return Response.error(e.getMessage());
        }catch (BizException bz){
            return Response.error(bz.getCode(),bz.getMessage());
        }catch (Exception ex) {
            return Response.error("系统异常");
        }
    }

    @ApiOperation("用户注销")
    @ApiResponse(code = 200, message = "请求成功", response = SigninRespBody.class)
    @PostMapping("/signup")
    public Response<SignUpRespBody> registerUser(@Valid @RequestBody SigninReq signUpRequest) {
        return Response.ok(SignUpRespBody.builder().build());
    }


    @ApiOperation("获取滑动验证码图片")
    @ApiResponse(code = 200, message = "请求成功", response = IdentifyImageBO.class)
    @PostMapping("/getIdentifyImg")
    public Response<IdentifyImageBO> getIdentifyImg() {
        try {
            IdentifyImageBO identifyImageBO = identifyImageService.randomImg();
            return Response.ok(identifyImageBO);
        } catch (Exception e) {
            log.error("获取滑动验证码失败", e);
        }
        return Response.error(ResponseStatus.COMMON_GAIN_ERROR);

    }

    @ApiOperation("校验验证码")
    @ApiResponse(code = 200, message = "请求成功", response = String.class)
    @PostMapping("/validateImg")
    public Response<String> validateImg(@RequestBody @Valid IdentifyReq req) {
        try {
            String validateId = identifyImageService.validateImg(req.getUuId(), req.getCoordinateX(), req.getCoordinateY());
            return Response.ok(validateId);
        } catch (Exception e) {
            log.error("获取滑动验证码失败", e);
        }
        return Response.error(ResponseStatus.COMMON_VALIDATE_ERROR);

    }
}
