package com.fenlibao.user.service;

import com.fenlibao.pms.dto.req.RegisterReq;
import org.springframework.stereotype.Service;

/**
 * 用户登录注册鉴权等接口
 * @author chen
 * @date 2019/01/10
 */
@Service
public interface AuthService {

    /**
     * 用户注册
     * @param registerReq
     */
    void register(RegisterReq registerReq);
}
