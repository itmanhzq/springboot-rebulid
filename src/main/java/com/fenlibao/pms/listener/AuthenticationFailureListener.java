package com.fenlibao.pms.listener;

import com.fenlibao.pms.mapper.system.UserDao;
import com.fenlibao.pms.model.po.UserStatusEnum;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.exception.BizException;
import com.fenlibao.pms.model.po.idmt.UserPO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Optional;


/**
 * 记录用户密码错误次数
 * @author:chen
 * @Date 2018-12-10
 */
@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    /**
     * 密码错误次数限制
     */
    private static  final int FAILNUM = 5;



    @Autowired
    UserDao userDao;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent) {
        //账号
        String account = authenticationFailureBadCredentialsEvent.getAuthentication().getPrincipal().toString();

        Example example = Example.builder(UserPO.class).where(Sqls.custom().andEqualTo("userName",account)).build();

        UserPO userPO = userDao.selectOneByExample(example);
        Optional<UserPO> user = Optional.ofNullable(userPO);
        if(user.isPresent()){
            int failNum = userPO.getErrorNumber();
            int num = failNum;
            failNum++;

                // 超出失败次数，停用账户
            if (failNum >= FAILNUM) {
                userPO.setErrorNumber(failNum);
                userPO.setStatus(UserStatusEnum.CLOSE.getStatus());
                userDao.updateByPrimaryKey(userPO);
            } else {
                    // 失败次数++
                userPO.setErrorNumber(failNum);
                userDao.updateByPrimaryKey(userPO);
                }

            throw new BizException(ResponseStatus.USER_NOT_VALID_ACCOUNT.getCode(),String.format("密码错误,剩余次数%s",FAILNUM - num));
        }
        throw new BizException(ResponseStatus.USER_NOT_VALID_ACCOUNT);

    }
}
