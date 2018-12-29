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

package com.fenlibao.pms.dto.base;

import com.fenlibao.pms.exception.SystemException;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @author Toby
 * @date 2018/11/13
 */
@Data
@Builder
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -4714820258897775115L;
    /**
     * 状态码
     */
    private String code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 各个接口返回的数据
     */
    @SuppressWarnings("squid:S1948")
    private T body;

    /**
     * 默认返回成功的Response
     *
     * @param body
     * @return
     */
    public static Response ok(Object body) {
        return Response.builder()
                .code(String.valueOf(HttpServletResponse.SC_OK))
                .msg(HttpStatus.OK.getReasonPhrase())
                .body(body)
                .build();
    }

    public static Response ok() {
        return Response.builder()
                .code(String.valueOf(HttpServletResponse.SC_OK))
                .msg(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    public static Response error(String message) {
        return Response.builder()
                .code(String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR))
                .msg(message)
                .build();
    }

    public static Response error(ResponseStatus responseStatus) {
        return Response.builder()
                .code(responseStatus.getCode())
                .msg(responseStatus.getMsg())
                .build();
    }

    public static Response error(String code, String msg) {
        return Response.builder()
                .code(code)
                .msg(msg)
                .build();
    }

    public static Response error(SystemException e) {
        return Response.builder()
                .code(e.getCode())
                .msg(e.getMessage())
                .build();
    }

    /**
     * 根据flag，返回对应的消息
     *
     * @param error   失败消息
     * @param success 成功消息
     * @param flag    用于成功或失败
     * @param body    返回数据
     * @return Response
     */
    public static Response okOrError(ResponseStatus error, ResponseStatus success, boolean flag, Object... body) {
        if (flag) {
            return Response.builder()
                    .msg(success.getMsg())
                    .body(body)
                    .code(String.valueOf(HttpServletResponse.SC_OK))
                    .build();
        }
        return Response.builder()
                .msg(error.getMsg())
                .body(body)
                .code(error.getCode())
                .build();
    }
}
