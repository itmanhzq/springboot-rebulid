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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码需按照规范来定义
 * @author Toby
 * @date 2018/11/3
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {
    /**
     *  操作成功不另定义响应码，只返回"编码200,操作成功"
     * 自定义错误码
     *  微服务类型以首字母大写区分，例如pms则定义'p'
     *  首位数字表示消息的权重（1=给开发者，2=用户弱提示，其他前缀按业务区分给用户强提示 例如：P30117-用户名已存在）
     *  业务区分的用户强提示错误码说明
     * 1. 错误码定义规则为首字母+5位数字
     * 2. 前两位数字表示业务场景，最后三位表示错误码。例如：P300001。30:系统管理模块 001:系统未知异常
     * 3. 维护错误码后需要维护错误描述
     *  系统管理 P30***
     *  用户鉴权 P31***
     */
    COMMON_OPERATION_SUCCESS("200","操作成功"),

    COMMON_NOT_VALID_TOKEN("P10111", "用户token验证不通过"),
    COMMON_NOT_VALID_EXPIRED("P10113", "用户token失效,请重新登录"),

    COMMON_GAIN_ERROR("P20111","获取失败"),
    COMMON_DELETE_ERROR("P20112","删除失败"),
    COMMON_UPDATE_ERROR("P20115","更新失败"),
    COMMON_VALIDATE_ERROR("P20123","验证失败"),

    SYSTEM_USER_USERNAME_ERROR("P30117","用户名已存在"),
    SYSTEM_USER_PASSWORD_ERROR("P30118","两次密码不一致"),
    SYSTEM_USER_OLD_PASSWORD_ERROR("P30122", "旧密码确认错误"),
    SYSTEM_USER_PASSWORD_ALIKE("P30123", "新旧密码一致"),
    SYSTEM_PERMISSION_NO_EXIST("P30124", "权限不存在"),
    SYSTEM_PERMISSION_ALREADY_EXIST("P30125", "权限已存在"),

    USER_NOT_VALID_ACCOUNT("P31112", "用户名或密码验证不通过"),
    USER_NOT_LOGIN_STATUS("P31114", "用户已被禁用，请联系客服"),
    USER_LOGIN_VALIDATE_ERROR("P31115","验证码验证失败")
    ;



    private String code;

    private String msg;

}
