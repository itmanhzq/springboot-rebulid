package com.fenlibao.pms.model.enums;

/**
 * 请求头枚举
 *
 * @author LeiXinXin
 * @date 2018/12/14
 */
public enum RequestHeaderEnum {
    /**
     * 请求头随机字符串
     */
    HEADER_NONCE("nonce"),
    /**
     * 请求头时间戳
     */
    HEADER_TIMESTAMP("timestamp"),
    /**
     * 请求头令牌
     */
    HEADER_TOKEN("Authorization"),
    /**
     * 请求头签名
     */
    HEADER_SIGN("sign"),
    ;

    private final String key;

    RequestHeaderEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
