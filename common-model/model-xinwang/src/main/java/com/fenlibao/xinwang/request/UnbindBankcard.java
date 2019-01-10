package com.fenlibao.xinwang.request;

import lombok.Data;

/**
 * 解绑银行卡实体类
 * @author hubert
 * @Date: 2018/12/12 8:56
 */
@Data
public class UnbindBankcard extends BasePO {
    /**
     * 页面回跳 URL
     */
    private String redirectUrl;

}
