package com.fenlibao.pms.service.marketing.publicize.impl;

import com.fenlibao.pms.dto.req.marketing.publicize.frinedlink.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkRespBody;
import com.fenlibao.pms.service.marketing.publicize.FriendLinkService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @author WangBoRan
 * @date 2019/1/10
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Override
    public PageInfo<FriendLinkListRespBody> getFriendLink(FriendLinkGetListReq friendLinkGetListReq) {
        return null;
    }

    @Override
    public FriendLinkRespBody getFriendLink(FriendLinkGetReq friendLinkGetReq) {
        return null;
    }

    @Override
    public void addFriendLink(FriendLinkAddReq friendLinkAddReq) {

    }

    @Override
    public void updateFriendLink(FriendLinkUpdateReq friendLinkUpdateReq) {

    }

    @Override
    public void deleteFriendLink(FriendLinkDeleteReq friendLinkDeleteReq) {

    }
}
