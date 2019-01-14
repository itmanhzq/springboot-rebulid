package com.fenlibao.pms.model.po;

/**
 * @author Toby
 * @date 2018/11/3
 */
public enum UserStatusEnum {
    /**
     * 开启
     */
    OPEN(1),

    /**
     * 关闭
     */
    CLOSE(0);

    private Integer status;

    UserStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
}
