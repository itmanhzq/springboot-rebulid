package com.fenlibao.marketing.mapper.publiceize;

import com.fenlibao.marketing.MarketingApplicationTests;
import com.fenlibao.marketing.service.publicize.FriendLinkService;
import com.fenlibao.marketing.dto.req.publicize.frinedlink.FriendLinkGetListReq;
import com.fenlibao.marketing.dto.resp.publicize.FriendLinkListRespBody;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WangBoRan
 * @date 2019/1/11
 */
@Slf4j
public class FriendLinkTest extends MarketingApplicationTests {
    @Autowired
    private FriendLinkService friendLinkService;

    @Test
    public void testGetFriendLinkList() {
        FriendLinkGetListReq friendLinkGetListReq = new FriendLinkGetListReq();
        PageInfo<FriendLinkListRespBody> friendLinks = friendLinkService.getFriendLinkList(friendLinkGetListReq);
        log.debug("查询结果：");
        log.debug(friendLinks.toString());
    }

}
