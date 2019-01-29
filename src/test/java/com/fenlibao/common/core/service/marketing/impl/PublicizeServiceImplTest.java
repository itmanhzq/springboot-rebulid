package com.fenlibao.common.core.service.marketing.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fenlibao.marketing.dto.req.publicize.article.*;
import com.fenlibao.marketing.dto.req.publicize.frinedlink.FriendLinkAddReq;
import com.fenlibao.marketing.dto.req.publicize.frinedlink.FriendLinkGetListReq;
import com.fenlibao.marketing.dto.req.publicize.frinedlink.FriendLinkGetReq;
import com.fenlibao.marketing.dto.req.publicize.frinedlink.FriendLinkUpdateReq;
import com.fenlibao.marketing.dto.req.publicize.post.*;
import com.fenlibao.marketing.dto.resp.publicize.*;
import com.fenlibao.pms.PmsApplication;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.service.marketing.publicize.ArticleService;
import com.fenlibao.pms.service.marketing.publicize.FriendLinkService;
import com.fenlibao.pms.service.marketing.publicize.PostService;
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
    @Autowired
    private PostService postService;

    @Test
    public void getArticleList() {
        ArticleGetListReq articleGetListReq = new ArticleGetListReq();
        articleGetListReq.setUserName("toby");
        articleGetListReq.setTitle("");
        articleGetListReq.setState(1);
        PageInfo<ArticleListRespBody> pageInfo = articleService.getArticleList(articleGetListReq);
        log.info(RequestUtil.toJson(pageInfo));
    }

    @Test
    public void getArticle() {
        ArticleGetReq articleGetReq = new ArticleGetReq();
        articleGetReq.setId(1);
        ArticleRespBody pageInfo = articleService.getArticle(articleGetReq);
        log.info(pageInfo.toString());
    }

    @Test
    public void deleteArticle() {
        ArticleDeleteReq articleDeleteReq = new ArticleDeleteReq();
        List list = new ArrayList() {
        };
        list.add(1);
        articleDeleteReq.setIds(list);
        articleService.deleteArticle(articleDeleteReq);
    }

    @Test
    public void isTopArticle() {
        ArticleStickTopReq articleStickTopReq = new ArticleStickTopReq();
        articleStickTopReq.setId(862);
        articleStickTopReq.setIsStickTop(false);
        articleService.stickTopArticle(articleStickTopReq);
        log.debug("添加成功：");
    }

    @Test
    public void addArticle() {
        ArticleAddReq articleAddReq = new ArticleAddReq();
        articleAddReq.setUserId(0);
        articleAddReq.setTitle("大叉裤啊");
        articleAddReq.setType(1);
        articleAddReq.setSource("中央人民电视台");
        articleAddReq.setAuthor("");
        articleAddReq.setOriginalUrl("http");
        articleAddReq.setShowTime(new Date());
        articleAddReq.setImageUrl("");
        articleAddReq.setSortTime(new Date());
        articleAddReq.setIsStickTop(false);
        articleAddReq.setState(0);
        articleAddReq.setPreOnlineTime(new Date());
        articleAddReq.setKeyword("wer");
        articleAddReq.setSummary("waer");
        articleAddReq.setContent("<p>zdfaegaeg W</p>");
        articleService.addArticle(articleAddReq);
        log.debug("添加成功：");
    }

    @Test
    public void getFriendLinkList() {
        FriendLinkGetListReq friendLinkGetListReq = new FriendLinkGetListReq();
        friendLinkGetListReq.setWebsiteName("");
        PageInfo<FriendLinkListRespBody> pageInfo = friendLinkService.getFriendLinkList(friendLinkGetListReq);
        log.info(pageInfo.toString());
    }

    @Test
    public void getFriendLink() {
        FriendLinkGetReq friendLinkGetReq = new FriendLinkGetReq();
        friendLinkGetReq.setId(1);
        FriendLinkRespBody pageInfo = friendLinkService.getFriendLink(friendLinkGetReq);
        log.info(pageInfo.toString());
    }

    @Test
    public void addFriendLink() {
        FriendLinkAddReq friendLinkAddReq = new FriendLinkAddReq();
        friendLinkAddReq.setUserId(2);
        friendLinkAddReq.setWebsiteName("百度");
        friendLinkAddReq.setUrl("https://www.baidu.com");
        friendLinkAddReq.setSort(1);
        friendLinkService.addFriendLink(friendLinkAddReq);
    }

    @Test
    public void updateFriendLink() {
        FriendLinkUpdateReq friendLinkUpdateReq = new FriendLinkUpdateReq();
        friendLinkUpdateReq.setId(1);
        friendLinkUpdateReq.setWebsiteName("百度");
        friendLinkUpdateReq.setUrl("https://www.baidu.com");
        friendLinkUpdateReq.setSort(1);
        friendLinkService.updateFriendLink(friendLinkUpdateReq);
    }

    @Test
    public void getPostList() {
        PostGetListReq postGetListReq = new PostGetListReq();
        postGetListReq.setTitle("银行");
        postGetListReq.setPageSize(10);
        PageInfo<PostListRespBody> pageInfo = postService.getPostList(postGetListReq);
        log.info(pageInfo.toString());
    }

    @Test
    public void addPost() {
        PostAddReq postAddReq = new PostAddReq();
        postAddReq.setUserId(1);
        postAddReq.setTitle("银行");
        postAddReq.setShowTime(new Date());
        postAddReq.setSortTime(new Date());
        postAddReq.setIsStickTop(false);
        postAddReq.setState(1);
        postAddReq.setPreOnlineTime(new Date());
        postAddReq.setKeyword("阿萨大大");
        postAddReq.setSummary("afgesafaf");
        postAddReq.setContent("asfaf");
        postAddReq.setExtData("fhsgjfsegyj");
        postService.addPost(postAddReq);
    }

    @Test
    public void isTopPost() {
        PostStickTopReq postStickTopReq = new PostStickTopReq();
        postStickTopReq.setId(8);
        postStickTopReq.setIsStickTop(true);
        postService.stickTopPost(postStickTopReq);
        log.debug("添加成功：");
    }

    @Test
    public void getPost() {
        PostGetReq postGetReq = new PostGetReq();
        postGetReq.setId(383);
        PostRespBody postRespBody = postService.getPost(postGetReq);
        log.info(postRespBody.toString());
    }
}
