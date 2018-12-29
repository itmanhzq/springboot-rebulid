package com.fenlibao.pms.model.enums.user;

/**
 * 用户状态枚举
 *
 * @author LeiXinXin
 * @date 2018/12/14
 */
public enum UserStatusEnum {
    /**
     * 禁用
     */
    PROHIBITPRO(0),

    /**
     *  启用
     */
    OPEN(1)
    ;

    private final Integer status;

    UserStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
