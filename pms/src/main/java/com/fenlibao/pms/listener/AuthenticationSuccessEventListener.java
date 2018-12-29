package com.fenlibao.pms.listener;


import com.fenlibao.pms.mapper.system.UserDao;
import com.fenlibao.pms.model.po.UserStatusEnum;
import com.fenlibao.pms.model.po.idmt.UserPO;
import com.fenlibao.pms.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;


/**
 * 登录成功监听
 * @author chen
 * @date 2018-12-10
 */
@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    /**
     * 重置的错误次数
     */
    private static final int ERROR_NUM = 0;

    @Autowired
    UserDao userDao;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        UserPrincipal userPrincipal = (UserPrincipal) authenticationSuccessEvent.getAuthentication().getPrincipal();
        UserPO userPO = userDao.selectByPrimaryKey(userPrincipal.getId());
        //重置错误次数
        userPO.setErrorNumber(ERROR_NUM);
        userPO.setStatus(UserStatusEnum.OPEN.getStatus());
        userDao.updateByPrimaryKey(userPO);
    }
}
