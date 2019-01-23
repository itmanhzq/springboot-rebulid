package com.fenlibao.marketing.service.publicize;

import com.fenlibao.pms.dto.req.marketing.publicize.frinedlink.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkRespBody;
import com.github.pagehelper.PageInfo;

/**
 * @author WangBoRan
 * @date 2019/1/10
 */
public interface FriendLinkService {

    /**
     * 友链列表
     *
     * @param friendLinkGetListReq
     * @return
     */
    PageInfo<FriendLinkListRespBody> getFriendLinkList(FriendLinkGetListReq friendLinkGetListReq);

    /**
     * 友链信息
     *
     * @param friendLinkGetReq
     * @return
     */
    FriendLinkRespBody getFriendLink(FriendLinkGetReq friendLinkGetReq);

    /**
     * 添加友链
     *
     * @param friendLinkAddReq
     */
    void addFriendLink(FriendLinkAddReq friendLinkAddReq);

    /**
     * 修改友链
     *
     * @param friendLinkUpdateReq
     */
    void updateFriendLink(FriendLinkUpdateReq friendLinkUpdateReq);

    /**
     * 删除友链
     *
     * @param friendLinkDeleteReq
     */
    void deleteFriendLink(FriendLinkDeleteReq friendLinkDeleteReq);
}
