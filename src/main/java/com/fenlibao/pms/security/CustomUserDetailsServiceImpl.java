package com.fenlibao.pms.security;

import cn.hutool.core.bean.BeanUtil;
import com.fenlibao.pms.mapper.system.UserMapper;
import com.fenlibao.pms.mapper.system.UserRoleMapper;
import com.fenlibao.pms.model.convert.RoleConvert;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.model.bo.idmt.RoleBO;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.model.bo.idmt.UserRoleBO;
import com.fenlibao.pms.model.po.idmt.UserPO;
import com.fenlibao.pms.model.po.idmt.UserRolePO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Toby
 * @date 2018/11/3
 */

@Slf4j
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) {
        return UserPrincipal.create(validateUser(0, usernameOrEmail));
    }

    public UserDetails loadUserById(Integer userId) {
        return UserPrincipal.create(validateUser(userId, null));
    }

    public UserBO validateUser(Integer userId, String userName) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("userId", userId);
        map.put("userName", userName);
        UserPO userPO = userMapper.getUserByUserNameOrUserId(map);
        if (userPO != null) {
            List<UserRoleBO> userRoleBOs = new ArrayList<>();
            List<UserRolePO> userRolePOS = userRoleMapper.listUserRoleByUserId(userPO.getId());
            try {
                userRolePOS.forEach(
                        userRolePO -> {
                            UserRoleBO userRoleBO = UserRoleBO.builder().build();
                            BeanUtil.copyProperties(userRolePO, userRoleBO);
                            RoleBO roleBO = RoleConvert.poConvertBO(userRolePO.getRole());
                            userRoleBO.setRole(roleBO);
                            userRoleBOs.add(userRoleBO);
                        }
                );
            }catch (Exception e){
                log.error(e.getMessage());
            }

            return UserBO.builder().id(userPO.getId()).userName(userPO.getUserName()).password(userPO.getPassword()).userRoles(userRoleBOs).build();

        }
        throw new UsernameNotFoundException(ResponseStatus.USER_NOT_LOGIN_STATUS.getMsg());
    }
}