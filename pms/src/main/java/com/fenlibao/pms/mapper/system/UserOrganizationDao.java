package com.fenlibao.pms.mapper.system;

import com.fenlibao.pms.model.po.idmt.IdmtUserOrganizationPO;
import org.springframework.stereotype.Repository;

/**
 * @author chen
 * @date 2018/12/06
 */
@Repository
public interface UserOrganizationDao extends tk.mybatis.mapper.common.Mapper<IdmtUserOrganizationPO>, tk.mybatis.mapper.common.MySqlMapper<IdmtUserOrganizationPO> {
}