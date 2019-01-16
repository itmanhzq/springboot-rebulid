package com.fenlibao.user.service.impl;

import com.fenlibao.pms.dto.req.RegisterReq;
import com.fenlibao.user.mapper.UserMapper;
import com.fenlibao.user.model.po.ExtInfoPO;
import com.fenlibao.user.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chen
 * @date 2018/12/11
 */
@Slf4j
@Service("AuthService")
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(RegisterReq registerReq) {
    }
}
