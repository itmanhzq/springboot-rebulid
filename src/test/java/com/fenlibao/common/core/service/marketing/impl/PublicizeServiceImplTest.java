package com.fenlibao.common.core.service.marketing.impl;

import cn.hutool.core.util.IdUtil;
import com.fenlibao.pms.PmsApplication;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.dto.req.marketing.publicize.article.ArticleGetListReq;
import com.fenlibao.pms.dto.req.marketing.publicize.frinedlink.FriendLinkGetListReq;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkListRespBody;
import com.fenlibao.pms.service.marketing.publicize.ArticleService;
import com.fenlibao.pms.service.marketing.publicize.FriendLinkService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author WangBoRan
 * @date 2019/1/16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PmsApplication.class)
public class PublicizeServiceImplTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private FriendLinkService friendLinkService;

    @Test
    public void getArticleListTest() {
        ArticleGetListReq articleGetListReq = new ArticleGetListReq();
        PageInfo<ArticleListRespBody> pageInfo = articleService.getArticleList(articleGetListReq);
        log.info(pageInfo.toString());
    }

    @Test
    public void getFriendLinkListTest() {
        FriendLinkGetListReq friendLinkGetListReq = new FriendLinkGetListReq();
        PageInfo<FriendLinkListRespBody> pageInfo = friendLinkService.getFriendLinkList(friendLinkGetListReq);
        log.info(pageInfo.toString());
    }

}
