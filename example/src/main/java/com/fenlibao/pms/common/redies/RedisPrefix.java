package com.fenlibao.pms.common.redies;


/**
 * 命名统一规范redis后缀
 * @author chen
 * @date 2018/12/05
 */
public enum RedisPrefix {

    /**
     * user-token保存地址
     */
    USER_TOKEN("user:token"),
    /**
     * 验证码图片保存地址
     */
    IDENTIFY_UUID("identify:uuid:"),
    /**
     * 请求随机数保存前缀
     */
    REQUEST_NONCE_PREFIX("request:nonce:"),;


    private String prefix;

    RedisPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return this.prefix;
    }

}
