package com.fenlibao.pms.mapper.system;

import com.fenlibao.common.core.BaseMapper;
import com.fenlibao.pms.model.po.idmt.UserRolePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chen
 * @date 2018/11/21
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRolePO> {
    /**
     * 根据用户Id查询角色信息
     *
     * @param userId 用户Id
     * @return List
     */
    List<UserRolePO> listUserRoleByUserId(@Param("userId") Integer userId);
}
