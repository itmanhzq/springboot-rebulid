package com.fenlibao.pms.service;
import org.springframework.stereotype.Service;

/**
 * 对token进行操作的接口
 * @author chen
 * @date 2018/12/11
 */
@Service
public interface TokenService {

    /**
     * 保存token到redis
     * @param userId
     * @param token
     */
     void saveTokenToReids(Integer userId,String token);

    /**
     *
     * 校验token是否有效
     * @param userId
     * @param token
     * @return
     */
     boolean checkToken(Integer userId,String token);

    /**
     * 删除用户缓存
     * @param userName
     */
    void deleteCache(String userName);

}
