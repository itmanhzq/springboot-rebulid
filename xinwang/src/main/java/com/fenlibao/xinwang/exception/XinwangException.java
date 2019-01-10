
package com.fenlibao.xinwang.exception;

import com.fenlibao.xinwang.dto.base.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Flynn
 * @date 2018/11/3
 */
@Getter
@Setter
public class XinwangException extends RuntimeException {
    private final String code;

    public XinwangException(String code , String msg) {
        super(msg);
        this.code = code;
    }

    public XinwangException(ResponseStatus responseStatus) {
        super(responseStatus.getMsg());
        this.code = responseStatus.getCode();
    }
}
