/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 */

package com.fenlibao.xinwang.exception;

import com.fenlibao.base.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Flynn
 * @date 2018/11/3
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 授权失败异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Object customHandler(AuthenticationException e) {
        log.error("AuthenticationException: ", e);
        return getUnauthorizedResp(e);
    }

    /**
     * 授权失败异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public Object customHandler(AccessDeniedException e) {
        log.error("AccessDeniedException: ", e);
        return getUnauthorizedResp(e);
    }


    /**
     * 其他未处理的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        log.error("Exception: ", e);
        return Response.builder()
                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .msg(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();
    }

    private Response getUnauthorizedResp(RuntimeException e) {
        return Response.builder()
                .code(String.valueOf(HttpServletResponse.SC_UNAUTHORIZED))
                .msg(e.getMessage())
                .build();
    }
}
