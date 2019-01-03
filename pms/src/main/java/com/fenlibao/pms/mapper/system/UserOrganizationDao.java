package com.fenlibao.pms.mapper.system;

import com.fenlibao.pms.model.po.idmt.IdmtUserOrganizationPO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author chen
 * @date 2018/12/06
 */
@Repository
public interface UserOrganizationDao extends Mapper<IdmtUserOrganizationPO>, MySqlMapper<IdmtUserOrganizationPO> {
}