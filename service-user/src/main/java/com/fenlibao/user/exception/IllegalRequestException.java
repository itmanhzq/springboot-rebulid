package com.fenlibao.user.exception;

/**
 * 非法请求异常
 *
 * @author LeiXinXin
 * @date 2018/11/30
 */
public class IllegalRequestException extends RuntimeException {

    private static final long serialVersionUID = 8047289684542247982L;

    public IllegalRequestException(String message) {
        super(message);
    }
}
