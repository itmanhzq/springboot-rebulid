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

package com.fenlibao.common.core;

/**
 * @author Toby
 * @date 2018/11/13
 */
public class Constants {
    private Constants() {
    }

    /**
     * 默认展示第一页数据
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 默认一页显示10条数据
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 用户密码正则表达式
     */
    public static final String PAWD_PATTERN = "[a-zA-Z0-9]{6,20}";

    /**
     * 手机号正则表达式
     */
    public static final String PHONE_PATTERN = "^(13|14|15|16|17|18|19)[0-9]{9}$";


}
