package com.fenlibao.pms.mapper;

import com.fenlibao.pms.model.po.IdentifyImagePO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author:chen
 * @Date 2018-12-10
 */
@Repository
public interface IdentifyImageDao extends Mapper<IdentifyImagePO>, MySqlMapper<IdentifyImagePO> {

}