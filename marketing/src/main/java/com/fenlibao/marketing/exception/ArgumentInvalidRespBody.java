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

import lombok.Data;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Data
public class ArgumentInvalidRespBody {
    private String field;
    private Object rejectedValue;
    private String defaultMessage;
}
