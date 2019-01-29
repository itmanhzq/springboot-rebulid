package com.fenlibao.pms.service.marketing.publicize.impl;

import com.fenlibao.marketing.dto.resp.publicize.PostListRespBody;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.config.Config;
import com.fenlibao.marketing.dto.req.publicize.frinedlink.*;
import com.fenlibao.marketing.dto.resp.publicize.FriendLinkListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.FriendLinkRespBody;
import com.fenlibao.pms.config.PropertiesConfig;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.service.marketing.publicize.FriendLinkService;
import com.fenlibao.pms.service.system.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author WangBoRan
 * @date 2019/1/10
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    private Config config;
    @Autowired
    private UserService userService;
    @Autowired
    private PropertiesConfig propertiesConfig;

    @Override
    public PageInfo<FriendLinkListRespBody> getFriendLinkList(FriendLinkGetListReq friendLinkGetListReq) {
        UserBO userBO = userService.getUser(friendLinkGetListReq.getUserName());
        PageInfo<FriendLinkListRespBody> pageInfo = new PageInfo<>();
        pageInfo.setList(new ArrayList<>());
        if (Objects.nonNull(userBO)) {
            friendLinkGetListReq.setUserId(userBO.getId());
            String url = config.getMarketing() + propertiesConfig.getGetFriendLinkList();
            String request = RequestUtil.toJson(friendLinkGetListReq);
            pageInfo = RequestUtil.postReqPage(url, request, FriendLinkListRespBody.class);
            addInfo(pageInfo);
        }
        return pageInfo;
    }

    @Override
    public FriendLinkRespBody getFriendLink(FriendLinkGetReq friendLinkGetReq) {
        String url = config.getMarketing() + propertiesConfig.getGetFriendLink();
        String request = RequestUtil.toJson(friendLinkGetReq);
        return RequestUtil.postReqBody(url, request, FriendLinkRespBody.class);
    }

    @Override
    public Boolean addFriendLink(FriendLinkAddReq friendLinkAddReq) {
        String url = config.getMarketing() + propertiesConfig.getAddFriendLink();
        String request = RequestUtil.toJson(friendLinkAddReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    @Override
    public Boolean updateFriendLink(FriendLinkUpdateReq friendLinkUpdateReq) {
        String url = config.getMarketing() + propertiesConfig.getUpdateFriendLink();
        String request = RequestUtil.toJson(friendLinkUpdateReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    @Override
    public Boolean deleteFriendLink(FriendLinkDeleteReq friendLinkDeleteReq) {
        String url = config.getMarketing() + propertiesConfig.getDeleteFriendLink();
        String request = RequestUtil.toJson(friendLinkDeleteReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    /**
     * 添加FriendLinkListRespBody字段信息
     * @param pageInfo
     */
    private void addInfo(PageInfo<FriendLinkListRespBody> pageInfo) {
        pageInfo.getList().forEach(body -> {
            UserBO userBO = userService.getUserById(body.getUserId());
            body.setUserName(userBO.getUserName());
        });
    }
}
