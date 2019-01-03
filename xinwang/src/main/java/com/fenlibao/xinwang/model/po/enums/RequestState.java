package com.fenlibao.xinwang.model.po.enums;

/**
 *
 */
public enum RequestState {
    DTJ(1,"待提交"),
    DQR(2,"待确认"),
    CG(3,"成功"),
    SB(4,"失败"),
    BCZ(5,"不存在的请求"),
    ;

    protected final int code;
    protected final String name;

    RequestState(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
