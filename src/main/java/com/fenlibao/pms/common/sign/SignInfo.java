package com.fenlibao.pms.common.sign;

import lombok.Builder;
import lombok.Data;

/**
 * 签名信息
 *
 * @author LeiXinXin
 * @date 2018/11/30
 */
@Data
@Builder
public class SignInfo {
    /**
     * 签名值
     */
    private String sign;
}
