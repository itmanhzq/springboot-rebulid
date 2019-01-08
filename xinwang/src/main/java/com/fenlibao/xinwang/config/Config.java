package com.fenlibao.xinwang.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Flynn
 * 新网配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "xinwang")
public class Config {

    /**
     * 新网接口地址
     */
    private String url;
    /**
     * 商户编号
     */
    private String platformNo;
    /**
     * 证书序号
     */
    private String keySerial;
    /**
     * 商户私钥
     */
    private String privateKey;
    /**
     * 存管公钥
     */
    private String lmPublicKey;


}
