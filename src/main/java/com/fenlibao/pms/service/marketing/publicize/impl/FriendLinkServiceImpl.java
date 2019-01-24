package com.fenlibao.pms.service.marketing.publicize.impl;

import com.fenlibao.marketing.dto.req.publicize.frinedlink.*;
import com.fenlibao.marketing.dto.resp.publicize.FriendLinkListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.FriendLinkRespBody;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.config.Config;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.service.marketing.publicize.FriendLinkService;
import com.fenlibao.pms.service.system.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public PageInfo<FriendLinkListRespBody> getFriendLinkList(FriendLinkGetListReq friendLinkGetListReq) {
        addUserIdValue(friendLinkGetListReq);
        String url = config.getMarketing() + "/publicize/friendLink/getFriendLinkList";
        String request = RequestUtil.toJson(friendLinkGetListReq);
        PageInfo<FriendLinkListRespBody> pageInfo = RequestUtil.postReqPage(url, request, FriendLinkListRespBody.class);
        addInfo(pageInfo);
        return pageInfo;
    }

    @Override
    public FriendLinkRespBody getFriendLink(FriendLinkGetReq friendLinkGetReq) {
        String url = config.getMarketing() + "/publicize/friendLink/getFriendLink";
        String request = RequestUtil.toJson(friendLinkGetReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean addFriendLink(FriendLinkAddReq friendLinkAddReq) {
        String url = config.getMarketing() + "/publicize/friendLink/addFriendLink";
        String request = RequestUtil.toJson(friendLinkAddReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean updateFriendLink(FriendLinkUpdateReq friendLinkUpdateReq) {
        String url = config.getMarketing() + "/publicize/friendLink/updateFriendLink";
        String request = RequestUtil.toJson(friendLinkUpdateReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean deleteFriendLink(FriendLinkDeleteReq friendLinkDeleteReq) {
        String url = config.getMarketing() + "/publicize/friendLink/deleteFriendLink";
        String request = RequestUtil.toJson(friendLinkDeleteReq);
        return RequestUtil.postReqBody(url, request);
    }

    /**
     * 添加userId字段
     *
     * @param friendLinkGetListReq
     */
    private void addUserIdValue(FriendLinkGetListReq friendLinkGetListReq) {
        String userName = friendLinkGetListReq.getUserName();
        if (Strings.isNotEmpty(userName)) {
            UserBO user = userService.getUser(userName);
            friendLinkGetListReq.setUserId(user.getId());
        }
    }

    /**
     * 添加FriendLinkListRespBody字段信息
     *
     * @param pageInfo
     */
    private void addInfo(PageInfo<FriendLinkListRespBody> pageInfo) {
        pageInfo.getList().forEach(body -> {
            UserBO userBO = userService.getUserById(body.getUserId());
            body.setUserName(userBO.getUserName());
        });
    }
}
