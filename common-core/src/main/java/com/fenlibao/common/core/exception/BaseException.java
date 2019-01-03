package com.fenlibao.common.core.exception;

/**
 * BaseException
 *
 * @author LeiXinXin
 * @date 2019/1/3
 */
public interface BaseException {
    /**
     * 异常消息
     *
     * @return String
     */
    String getMessage();

    /**
     * 异常信息
     *
     * @return String
     */
    String getCode();
}
