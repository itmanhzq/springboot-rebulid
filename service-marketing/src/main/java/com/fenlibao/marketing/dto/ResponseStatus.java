package com.fenlibao.marketing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码需按照规范来定义
 *
 * @author wangboran
 * @date 2018/11/3
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {

    COMMON_OPERATION_SUCCESS("200", "操作成功"),
    COMMON_OPERATION_FAIL("200", "失败");

    private String code;

    private String msg;

}
