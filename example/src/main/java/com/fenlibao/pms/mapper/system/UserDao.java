package com.fenlibao.pms.mapper.system;

import com.fenlibao.pms.common.BaseMapper;
import com.fenlibao.pms.model.po.idmt.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2018/11/21
 */
@Repository
public interface UserDao extends BaseMapper<UserPO> {

    /**
     * 复杂查询示例
     * @param map
     * @return List<UserPo>
     */
    List<UserPO> getSearchUser(Map map);


    /**
     * 根据账号或id获取用户
     * @param map
     * @return
     */
    UserPO getUserByUserNameOrUserId(Map map);

    /**
     * 通过角色ID获取用户信息
     *
     * @param roleId 角色ID
     * @return List
     */
    List<UserPO> listUserByRoleId(@Param("roleId") Integer roleId);
}
