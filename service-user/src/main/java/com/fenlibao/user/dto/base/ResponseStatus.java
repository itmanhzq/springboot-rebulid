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

package com.fenlibao.user.dto.base;

import com.fenlibao.base.dto.BaseResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码需按照规范来定义
 * @author chen
 * @date 2019/01/10
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus implements BaseResponseStatus {
    /**
     *  操作成功不另定义响应码，只返回"编码200,操作成功"
     * 自定义错误码
     *  微服务类型以首字母大写区分，例如user则定义'U'
     *  首位数字表示消息的权重（1=给开发者，2=用户弱提示，其他前缀按业务区分给用户强提示 例如：P30117-用户名已存在）
     *  业务区分的用户强提示错误码说明
     * 1. 错误码定义规则为首字母+5位数字
     * 2. 前两位数字表示业务场景，最后三位表示错误码。例如：P300001。30:系统管理模块 001:系统未知异常
     * 3. 维护错误码后需要维护错误描述
     *  系统管理 P30***
     *  用户鉴权 P31***
     */
    COMMON_OPERATION_SUCCESS("200","操作成功")
    ;



    private String code;

    private String msg;

}
