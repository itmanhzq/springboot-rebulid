package com.fenlibao.pms.service.system.impl;

import com.fenlibao.pms.mapper.system.UserMapper;
import com.fenlibao.pms.mapper.system.UserOrganizationMapper;
import com.fenlibao.pms.mapper.system.UserRoleMapper;
import com.fenlibao.pms.model.po.idmt.OrganizationPO;
import com.fenlibao.pms.service.system.UserService;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.exception.SystemException;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.model.po.idmt.IdmtUserOrganizationPO;
import com.fenlibao.pms.model.po.idmt.UserPO;
import com.fenlibao.pms.model.po.idmt.UserRolePO;
import com.fenlibao.pms.dto.req.system.SaveUserReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;
import tk.mybatis.mapper.util.StringUtil;

import java.util.*;

/**
 * @author chen
 * @date 2018-11-26
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserOrganizationMapper userOrganizationMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    private static final String USER_ID_PROPERTY = "userId";

    /**
     * 初始的密码错误值
     */
    private static final int ERROR_NUM = 0 ;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createUser(SaveUserReq saveUserReq) {
        if (existsUsername(saveUserReq.getUserName())) {
            throw new SystemException(ResponseStatus.SYSTEM_USER_USERNAME_ERROR);
        }
        if (!saveUserReq.getPassword().equals(saveUserReq.getComfirmPassword())) {
            throw new SystemException(ResponseStatus.SYSTEM_USER_PASSWORD_ERROR);
        }
        UserPO userPO = new UserPO();
        userPO.setUserName(saveUserReq.getUserName());
        userPO.setPassword(passwordEncoder.encode(saveUserReq.getPassword()));
        userPO.setRealName(saveUserReq.getRealName());
        userPO.setPhone(saveUserReq.getPhone());
        userPO.setEmail(saveUserReq.getEmail());
        userPO.setStatus(Integer.valueOf(saveUserReq.getStatus()));
        userPO.setCreateTime(new Date());
        userPO.setErrorNumber(ERROR_NUM);
        userMapper.insertUseGeneratedKeys(userPO);

        IdmtUserOrganizationPO idmtUserOrganizationPO = new IdmtUserOrganizationPO();
        idmtUserOrganizationPO.setOrganizationId(Integer.valueOf(saveUserReq.getOrganizationId()));
        idmtUserOrganizationPO.setUserId(userPO.getId());
        userOrganizationMapper.insertUseGeneratedKeys(idmtUserOrganizationPO);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(SaveUserReq saveUserReq) {
        if (!saveUserReq.getPassword().equals(saveUserReq.getComfirmPassword())) {
            throw new SystemException(ResponseStatus.SYSTEM_USER_PASSWORD_ERROR);
        }
        UserPO userPO = userMapper.selectByPrimaryKey(saveUserReq.getUserId());
        userPO.setUserName(saveUserReq.getUserName());
        userPO.setPassword(passwordEncoder.encode(saveUserReq.getPassword()));
        userPO.setRealName(saveUserReq.getRealName());
        userPO.setPhone(saveUserReq.getPhone());
        userPO.setEmail(saveUserReq.getEmail());
        userMapper.updateByPrimaryKey(userPO);
        Example example = Example.builder(IdmtUserOrganizationPO.class).where(Sqls.custom().andEqualTo(USER_ID_PROPERTY, userPO.getId())).build();
        IdmtUserOrganizationPO idmtUserOrganizationPO = userOrganizationMapper.selectOneByExample(example);
        idmtUserOrganizationPO.setOrganizationId(Integer.valueOf(saveUserReq.getOrganizationId()));
        userOrganizationMapper.updateByPrimaryKey(idmtUserOrganizationPO);
    }

    @Override
    public PageInfo<UserPO> getSearchUser(int pageNum, int pageSize, List<OrganizationPO> organizationPOS, String name) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("organization", organizationPOS);
        if (!StringUtil.isEmpty(name)) {
            params.put("name", name);
        }
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> userMapper.getSearchUser(params));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delUser(Integer userId) {
        int count = userMapper.deleteByPrimaryKey(userId);
        Example userRoleExample = Example.builder(UserRolePO.class).where(Sqls.custom().andEqualTo(USER_ID_PROPERTY, userId)).build();
        userRoleMapper.deleteByExample(userRoleExample);
        Example organizationExample = Example.builder(IdmtUserOrganizationPO.class).where(Sqls.custom().andEqualTo(USER_ID_PROPERTY, userId)).build();
        userOrganizationMapper.deleteByExample(organizationExample);
        return count;
    }

    /**
     * 检查用户是否存在
     *
     * @param userName
     * @return
     */
    private boolean existsUsername(String userName) {
        Example userRoleExample = Example.builder(UserPO.class).where(Sqls.custom().andEqualTo("userName", userName)).build();
        UserPO user = this.userMapper.selectOneByExample(userRoleExample);
        return user != null;
    }


    @Override
    public UserBO getUser(String name) {
        if (name != null) {
            if (name.length() == 0) {
                return new UserBO();
            }
            Example example = Example.builder(UserPO.class).where(Sqls.custom().andEqualTo("userName", name)).build();
            UserPO userPO = userMapper.selectOneByExample(example);
            UserBO userBO = new UserBO();
            if (userPO != null) {
                BeanUtils.copyProperties(userPO, userBO);
                return userBO;
            }
        }
        return null;
    }

    @Override
    public Integer getUserId(String name) {
        Integer id = null;
        if (Strings.isNotEmpty(name)) {
            UserBO user = getUser(name);
            if (Objects.nonNull(user)) {
                id = user.getId();
            }
        }
        return id;
    }

    @Override
    public UserBO getUserById(Integer id) {
        UserPO userPO = userMapper.selectByPrimaryKey(id);
        UserBO userBO = new UserBO();
        if (Objects.nonNull(userPO)) {
            BeanUtils.copyProperties(userPO, userBO);
        }
        return userBO;
    }

    @Override
    public List<UserPO> listUserByRoleId(Integer pageNum, Integer pageSize, Integer roleId) {
        PageHelper.startPage(pageSize, pageNum);
        return userMapper.listUserByRoleId(roleId);
    }

    @Override
    public void updatePassword(Integer userId, String oldPassword, String newPassword) {
        UserPO userPO = userMapper.selectByPrimaryKey(userId);
        if(!passwordEncoder.matches(oldPassword,userPO.getPassword())){
            throw new SystemException(ResponseStatus.SYSTEM_USER_OLD_PASSWORD_ERROR);
        }
        if(oldPassword.equals(newPassword)){
            throw new SystemException(ResponseStatus.SYSTEM_USER_PASSWORD_ALIKE);
        }
        userPO.setPassword(passwordEncoder.encode(newPassword));
        userMapper.updateByPrimaryKey(userPO);

    }
}
