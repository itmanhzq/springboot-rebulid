package com.fenlibao.pms.mapper.system;

import com.fenlibao.pms.model.po.idmt.UserRolePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author chen
 * @date 2018/11/21
 */
@Repository
public interface UserRoleDao extends Mapper<UserRolePO>, MySqlMapper<UserRolePO> {
    /**
     * 根据用户Id查询角色信息
     *
     * @param userId 用户Id
     * @return List
     */
    List<UserRolePO> listUserRoleByUserId(@Param("userId") Integer userId);
}
