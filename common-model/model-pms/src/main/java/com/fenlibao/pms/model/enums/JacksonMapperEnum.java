package com.fenlibao.pms.model.enums;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 单例json枚举
 * @author chen
 * @date 2018/12/11
 */
public enum JacksonMapperEnum {

    /**
     * 单例
     */
    INSTANCE;

    private ObjectMapper mapper;

    JacksonMapperEnum() {
        mapper = new ObjectMapper();
    }

    public ObjectMapper getInstance() {
        return mapper;
    }
}
