package com.fenlibao.xinwang.dto.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码需按照规范来定义
 * @author Flynn
 * @date 2018/11/3
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {

    COMMON_OPERATION_SUCCESS("200","操作成功"),
    COMMON_OPERATION_FAIL("500","失败");

    private String code;

    private String msg;

}
