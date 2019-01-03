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

package com.fenlibao.pms.exception;

import com.fenlibao.common.core.exception.BaseException;
import com.fenlibao.pms.dto.base.ResponseStatus;
import lombok.Getter;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Getter
public class SystemException extends RuntimeException implements BaseException {
    private static final long serialVersionUID = -5279102685099291009L;
    private final String code;

    public SystemException(String msg, String code) {
        super(msg);
        this.code = code;
    }

    public SystemException(ResponseStatus response) {
        super(response.getMsg());
        this.code = String.valueOf(response.getCode());
    }
}
