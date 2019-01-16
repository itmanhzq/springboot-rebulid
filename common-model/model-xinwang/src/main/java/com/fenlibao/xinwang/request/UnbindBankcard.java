package com.fenlibao.xinwang.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 解绑银行卡实体类
 * @author hubert
 * @Date: 2018/12/12 8:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnbindBankcard extends BasePO {
    /**
     * 页面回跳 URL
     */
    private String redirectUrl;

    private String platformUserNo;

}
