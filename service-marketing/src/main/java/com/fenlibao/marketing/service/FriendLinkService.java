package com.fenlibao.marketing.service;

import com.fenlibao.pms.dto.req.marketing.publicize.frinedlink.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkRespBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    List<FriendLinkListRespBody> getFriendLink(FriendLinkGetListReq friendLinkGetListReq);

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
