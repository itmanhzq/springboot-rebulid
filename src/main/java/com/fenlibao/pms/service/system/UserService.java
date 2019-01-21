package com.fenlibao.pms.service.system;

import com.fenlibao.pms.model.po.idmt.OrganizationPO;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.model.po.idmt.UserPO;
import com.fenlibao.pms.dto.req.system.SaveUserReq;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @date 2018/11/22
 */
@Service
public interface UserService {


    /**
     * 查询用户列表
     *
     * @param pageNum
     * @param pageSize
     * @param organizationPOS
     * @param name
     * @return
     */
    PageInfo<UserPO> getSearchUser(int pageNum, int pageSize, List<OrganizationPO> organizationPOS, String name);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int delUser(Integer userId);

    /**
     * 添加用户
     *
     * @param saveUserReq
     */
    void createUser(SaveUserReq saveUserReq);

    /**
     * 更新用户数据
     *
     * @param saveUserReq
     */
    void updateUser(SaveUserReq saveUserReq);

    /**
     * 根据用户名获取用户
     *
     * @param name
     * @return
     */
    UserBO getUser(String name);

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    UserBO getUserById(Integer id);

    /**
     * 通过角色ID获取用户信息
     *
     * @param roleId   角色ID
     * @param pageNum  页数
     * @param pageSize 条数
     * @return List
     */
    List<UserPO> listUserByRoleId(Integer pageNum, Integer pageSize, Integer roleId);

    /**
     * 密码修改
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     */
    void updatePassword(Integer userId, String oldPassword, String newPassword);
}
