package com.fenlibao.xinwang.model.enums;

/**
 * 请求头枚举
 *
 * @author Flynn
 */
public enum RequestHeaderEnum {

    /**
     * 接入密钥
     */
    ACCESS_KEY("accessKey");



    private final String value;

    RequestHeaderEnum(String key) {
        this.value = key;
    }

    public String getValue() {
        return value;
    }
}
