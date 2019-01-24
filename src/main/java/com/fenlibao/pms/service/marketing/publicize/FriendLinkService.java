package com.fenlibao.pms.service.marketing.publicize;

import com.fenlibao.marketing.dto.req.publicize.frinedlink.*;
import com.fenlibao.marketing.dto.resp.publicize.FriendLinkListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.FriendLinkRespBody;
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
    Boolean addFriendLink(FriendLinkAddReq friendLinkAddReq);

    /**
     * 修改友链
     *
     * @param friendLinkUpdateReq
     */
    Boolean updateFriendLink(FriendLinkUpdateReq friendLinkUpdateReq);

    /**
     * 删除友链
     *
     * @param friendLinkDeleteReq
     */
    Boolean deleteFriendLink(FriendLinkDeleteReq friendLinkDeleteReq);
}
