package com.fenlibao.marketing.mapper.publiceize;
import java.util.Date;



import com.fenlibao.marketing.MarketingApplicationTests;
import com.fenlibao.marketing.service.ArticleService;
import com.fenlibao.pms.dto.req.marketing.publicize.article.ArticleAddReq;
import com.fenlibao.pms.dto.req.marketing.publicize.article.ArticleGetListReq;
import com.fenlibao.pms.dto.req.marketing.publicize.article.ArticleGetReq;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleRespBody;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author WangBoRan
 * @date 2019/1/10
 */
@Slf4j
@Transactional
public class ArticlsTest extends MarketingApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testGetArticleList() {
        ArticleGetListReq articleGetListReq = new ArticleGetListReq();
        articleGetListReq.setTitle("投资新锐光大分利宝加入广州互联网金融协会");
        List<ArticleListRespBody> articleList = articleService.getArticleList(articleGetListReq);
        log.debug("查询结果：");
        log.debug(articleList.toString());
    }

    @Test
    public void testGetArticle() {
        ArticleGetReq articleGetReq = new ArticleGetReq();
        articleGetReq.setId(1406);
        ArticleRespBody articleList = articleService.getArticle(articleGetReq);
        log.debug("查询结果：");
        log.debug(articleList.toString());
    }

    @Test
    public void testAddArticle() {
        ArticleAddReq articleAddReq = new ArticleAddReq();
        articleAddReq.setUserId(0);
        articleAddReq.setTitle("");
        articleAddReq.setType(0);
        articleAddReq.setSource("");
        articleAddReq.setAuthor("");
        articleAddReq.setOriginalUrl("");
        articleAddReq.setShowTime(new Date());
        articleAddReq.setImageUrl("");
        articleAddReq.setSortTime(new Date());
        articleAddReq.setIsStickTop(false);
        articleAddReq.setState(0);
        articleAddReq.setOnlineTime(new Date());
        articleAddReq.setKeyword("");
        articleAddReq.setSummary("");
        articleAddReq.setContent("");
        articleService.addArticle(articleAddReq);
        log.debug("添加成功：");
    }
}
