package com.fenlibao.marketing.mapper.publiceize;

import java.util.Date;


import com.fenlibao.marketing.MarketingApplicationTests;
import com.fenlibao.marketing.service.ArticleService;
import com.fenlibao.pms.dto.req.marketing.publicize.article.ArticleGetListReq;
import com.fenlibao.pms.dto.req.marketing.publicize.article.ArticleGetReq;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleRespBody;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author WangBoRan
 * @date 2019/1/10
 */
@Slf4j
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
        articleGetReq.setId(1);
        ArticleRespBody articleList = articleService.getArticle(articleGetReq);
        log.debug("查询结果：");
        log.debug(articleList.toString());
    }
}
