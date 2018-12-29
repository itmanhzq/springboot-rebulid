package com.fenlibao.pms.service.system.impl;

import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.dto.req.system.SaveUserReq;
import com.fenlibao.pms.exception.SystemException;
import com.fenlibao.pms.mapper.system.UserDao;
import com.fenlibao.pms.mapper.system.UserOrganizationDao;
import com.fenlibao.pms.mapper.system.UserRoleDao;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.model.po.idmt.IdmtUserOrganizationPO;
import com.fenlibao.pms.model.po.idmt.OrganizationPO;
import com.fenlibao.pms.model.po.idmt.UserPO;
import com.fenlibao.pms.model.po.idmt.UserRolePO;
import com.fenlibao.pms.service.system.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2018-11-26
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserOrganizationDao userOrganizationDao;

    @Autowired
    private UserRoleDao userRoleDao;

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
        userDao.insertUseGeneratedKeys(userPO);

        IdmtUserOrganizationPO idmtUserOrganizationPO = new IdmtUserOrganizationPO();
        idmtUserOrganizationPO.setOrganizationId(Integer.valueOf(saveUserReq.getOrganizationId()));
        idmtUserOrganizationPO.setUserId(userPO.getId());
        userOrganizationDao.insertUseGeneratedKeys(idmtUserOrganizationPO);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(SaveUserReq saveUserReq) {
        if (!saveUserReq.getPassword().equals(saveUserReq.getComfirmPassword())) {
            throw new SystemException(ResponseStatus.SYSTEM_USER_PASSWORD_ERROR);
        }
        UserPO userPO = userDao.selectByPrimaryKey(saveUserReq.getUserId());
        userPO.setUserName(saveUserReq.getUserName());
        userPO.setPassword(passwordEncoder.encode(saveUserReq.getPassword()));
        userPO.setRealName(saveUserReq.getRealName());
        userPO.setPhone(saveUserReq.getPhone());
        userPO.setEmail(saveUserReq.getEmail());
        userDao.updateByPrimaryKey(userPO);
        Example example = Example.builder(IdmtUserOrganizationPO.class).where(Sqls.custom().andEqualTo(USER_ID_PROPERTY, userPO.getId())).build();
        IdmtUserOrganizationPO idmtUserOrganizationPO = userOrganizationDao.selectOneByExample(example);
        idmtUserOrganizationPO.setOrganizationId(Integer.valueOf(saveUserReq.getOrganizationId()));
        userOrganizationDao.updateByPrimaryKey(idmtUserOrganizationPO);
    }

    @Override
    public PageInfo<UserPO> getSearchUser(int pageNum, int pageSize, List<OrganizationPO> organizationPOS, String name) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("organization", organizationPOS);
        if (!StringUtil.isEmpty(name)) {
            params.put("name", name);
        }
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> userDao.getSearchUser(params));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delUser(Integer userId) {
        int count = userDao.deleteByPrimaryKey(userId);
        Example userRoleExample = Example.builder(UserRolePO.class).where(Sqls.custom().andEqualTo(USER_ID_PROPERTY, userId)).build();
        userRoleDao.deleteByExample(userRoleExample);
        Example organizationExample = Example.builder(IdmtUserOrganizationPO.class).where(Sqls.custom().andEqualTo(USER_ID_PROPERTY, userId)).build();
        userOrganizationDao.deleteByExample(organizationExample);
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
        UserPO user = this.userDao.selectOneByExample(userRoleExample);
        return user != null;
    }


    @Override
    public UserBO getUser(String name) {
        Example example = Example.builder(UserPO.class).where(Sqls.custom().andEqualTo("userName", name)).build();
        UserPO userPO = userDao.selectOneByExample(example);
        UserBO userBO = new UserBO();
        if(userPO!=null) {
            BeanUtils.copyProperties(userPO, userBO);
            return userBO;
        }
        return null;
    }

    @Override
    public List<UserPO> listUserByRoleId(Integer pageNum, Integer pageSize, Integer roleId) {
        PageHelper.startPage(pageSize, pageNum);
        return userDao.listUserByRoleId(roleId);
    }

    @Override
    public void updatePassword(Integer userId, String oldPassword, String newPassword) {
        UserPO userPO = userDao.selectByPrimaryKey(userId);
        if(!passwordEncoder.matches(oldPassword,userPO.getPassword())){
            throw new SystemException(ResponseStatus.SYSTEM_USER_OLD_PASSWORD_ERROR);
        }
        if(oldPassword.equals(newPassword)){
            throw new SystemException(ResponseStatus.SYSTEM_USER_PASSWORD_ALIKE);
        }
        userPO.setPassword(passwordEncoder.encode(newPassword));
        userDao.updateByPrimaryKey(userPO);

    }
}
