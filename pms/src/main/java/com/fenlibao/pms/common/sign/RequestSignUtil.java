package com.fenlibao.pms.common.sign;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import com.fenlibao.pms.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * 签名工具
 *
 * @author LeiXinXin
 * @date 2018/11/30
 */
@Slf4j
@Component
@SuppressWarnings("squid:S2696")
public class RequestSignUtil {

    /**
     * 签名用的盐值
     */
    private static String salt;
    private static HMac hMac;

    private final Config config;

    @Autowired
    private RequestSignUtil(Config config) {
        this.config = config;
    }

    /**
     * 请求参数签名
     *
     * @param token     授权的令牌
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @param body      请求的JSON数据
     * @return SignInfo 签名信息
     */
    public static SignInfo sign(String token, Long timestamp, String nonce, StringBuilder body) {
        body.append(token).append(timestamp).append(nonce).append(salt);
        String sign = hMac.digestHex(StringUtils.trimAllWhitespace(body.toString()));
        return SignInfo.builder().sign(sign).build();
    }

    @PostConstruct
    private void init() {
        if (Objects.isNull(salt)) {
            salt = config.getRequest().getSalt();
        }
        if (Objects.isNull(hMac)) {
            hMac = new HMac(HmacAlgorithm.HmacSHA256, salt.getBytes());
        }
    }
}
