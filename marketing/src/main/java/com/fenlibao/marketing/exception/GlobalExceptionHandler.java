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

package com.fenlibao.marketing.exception;

import com.fenlibao.base.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 处理自定义的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Object customHandler(BizException e) {
        log.error("BizException: ", e);
        return Response.builder()
                .code(e.getCode())
                .msg(e.getMessage())
                .build();
    }


    /**
     * 请求参数签名异常
     *
     * @param e 非法请求
     * @return Object
     */
    @ExceptionHandler(IllegalRequestException.class)
    @ResponseBody
    public Object customHandler(IllegalRequestException e) {
        log.error("IllegalRequestException: {}", e.getMessage());
        return Response.builder()
                .code(String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR))
                .msg(e.getMessage())
                .build();
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

    /**
     * 按需重新封装需要返回的错误信息
     * 解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Object methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        List<ArgumentInvalidRespBody> invalidArguments = new ArrayList<>();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            ArgumentInvalidRespBody invalidArgument = new ArgumentInvalidRespBody();
            invalidArgument.setDefaultMessage(error.getDefaultMessage());
            invalidArgument.setField(error.getField());
            invalidArgument.setRejectedValue(error.getRejectedValue());
            invalidArguments.add(invalidArgument);
        }

        return Response.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .msg(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .body(invalidArguments)
                .build();
    }

    private Response getUnauthorizedResp(RuntimeException e) {
        return Response.builder()
                .code(String.valueOf(HttpServletResponse.SC_UNAUTHORIZED))
                .msg(e.getMessage())
                .build();
    }
}
