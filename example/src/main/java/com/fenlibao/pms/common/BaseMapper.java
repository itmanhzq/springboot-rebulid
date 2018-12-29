package com.fenlibao.pms.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Toby
 * @date 2018/11/12
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
