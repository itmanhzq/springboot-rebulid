package com.fenlibao.marketing.mapper.publiceize;

import com.fenlibao.marketing.MarketingApplicationTests;
import com.fenlibao.marketing.service.FriendLinkService;
import com.fenlibao.pms.dto.req.marketing.publicize.frinedlink.FriendLinkGetListReq;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkListRespBody;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        List<FriendLinkListRespBody> friendLinks = friendLinkService.getFriendLink(friendLinkGetListReq);
        log.debug("查询结果：");
        log.debug(friendLinks.toString());
    }

}
