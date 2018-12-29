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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import com.fenlibao.common.core.Constants;
/**
 * @author Toby
 * @date 2018/11/3
 */
@Data
public abstract class AbstractPagingReq extends BaseReq {

    @NotNull
    @ApiModelProperty("分页页数")
    private int pageNum = Constants.DEFAULT_PAGE_NUM;

    @Max(10)
    @ApiModelProperty("每页显示数据条数")
    private int pageSize = Constants.DEFAULT_PAGE_SIZE;
}
