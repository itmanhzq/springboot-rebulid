package com.fenlibao.pms.service.marketing.publicize.impl;


import cn.hutool.http.HttpUtil;
import com.fenlibao.pms.dto.req.marketing.publicize.article.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleRespBody;
import com.fenlibao.pms.service.marketing.publicize.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;


/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public PageInfo<ArticleListRespBody> getArticleList(ArticleGetListReq essayGetListReq) {
//        HttpUtil.post();
        return null;
    }

    @Override
    public ArticleRespBody getArticle(ArticleGetReq articleGetReq) {
        return null;
    }

    @Override
    public void addArticle(ArticleAddReq essayAddReq) {

    }

    @Override
    public void updateArticle(ArticleUpdateReq essayUpdateReq) {

    }

    @Override
    public void topPlaceArticle(ArticleStickTopReq bulletinUpdateReq) {

    }

    @Override
    public void deleteArticle(ArticleDeleteReq essayDeleteReq) {

    }
}
