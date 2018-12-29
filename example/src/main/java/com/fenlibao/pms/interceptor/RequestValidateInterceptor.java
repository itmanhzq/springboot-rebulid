package com.fenlibao.pms.interceptor;

import com.fenlibao.pms.common.WrappedHttpServletRequest;
import com.fenlibao.pms.common.sign.NonceUtil;
import com.fenlibao.pms.common.sign.RequestSignUtil;
import com.fenlibao.pms.common.sign.SignInfo;
import com.fenlibao.pms.exception.IllegalRequestException;
import com.fenlibao.pms.model.enums.RequestHeaderEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * 请求验证拦截器
 *
 * @author LeiXinXin
 * @date 2018/12/6
 */
@Component
public class RequestValidateInterceptor implements HandlerInterceptor {
    /**
     * 默认时间戳
     */
    private static final String DEFAULT_TIMESTAMP = "0";
    /**
     * 默认字符串
     */
    private static final String DEFAULT_STR = "";

    /**
     * 默认通行的请求方式
     */
    private static final String REQUEST_METHOD = "OPTIONS";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!request.getMethod().equals(REQUEST_METHOD)){
            requestValidate(request);
        }
        return true;
    }

    private void requestValidate(HttpServletRequest request) throws IOException {
        final long requestMaxTime = 60L;

        String token = Objects.isNull(request.getHeader(RequestHeaderEnum.HEADER_TOKEN.getKey())) ?
                DEFAULT_STR : request.getHeader(RequestHeaderEnum.HEADER_TOKEN.getKey());

        String timestamp = Objects.isNull(request.getHeader(RequestHeaderEnum.HEADER_TIMESTAMP.getKey())) ?
                DEFAULT_TIMESTAMP : request.getHeader(RequestHeaderEnum.HEADER_TIMESTAMP.getKey());

        String nonce = request.getHeader(RequestHeaderEnum.HEADER_NONCE.getKey());
        String sign = request.getHeader(RequestHeaderEnum.HEADER_SIGN.getKey());

        if (!(request instanceof WrappedHttpServletRequest)) {
            request = new WrappedHttpServletRequest(request);
        }
        long systemTimestamp = System.currentTimeMillis();
        // 请求已超过有效期
        long diffTime = (systemTimestamp - Long.parseLong(timestamp)) / (1000 * 60);
        if (diffTime > requestMaxTime) {
            throw new IllegalRequestException("请求已超时");
        }
        // 是否重复请求
        if (NonceUtil.exists(token, nonce)) {
            throw new IllegalRequestException("请勿重复请求");
        } else {
            NonceUtil.addNonce(token, nonce);
        }
        // 读取request中的流（JSON）
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String temp;
            while (Objects.nonNull((temp = reader.readLine()))) {
                sb.append(temp);
            }
        }
        SignInfo serverSign = RequestSignUtil.sign(token, Long.parseLong(timestamp), nonce, sb);
        if (!serverSign.getSign().equals(sign)) {
            throw new IllegalRequestException("非法请求");
        }
    }
}
