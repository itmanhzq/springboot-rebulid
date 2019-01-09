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


import com.fenlibao.marketing.dto.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Getter
@Setter
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 2908865859860576687L;
    private final String code;

    public BizException(String code ,String msg) {
        super(msg);
        this.code = code;
    }

    public BizException(ResponseStatus responseStatus) {
        super(responseStatus.getMsg());
        this.code = responseStatus.getCode();
    }
}
