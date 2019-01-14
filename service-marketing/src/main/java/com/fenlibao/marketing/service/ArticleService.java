package com.fenlibao.marketing.service;

import com.fenlibao.pms.dto.req.marketing.publicize.article.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleRespBody;

import java.util.List;


/**
 * @author WangBoRan
 * @date 2018-12-27
 */
public interface ArticleService {

    /**
     * 文章列表
     *
     * @param essayGetListReq
     * @return
     */
    List<ArticleListRespBody> getArticleList(ArticleGetListReq essayGetListReq);

    /**
     * 查询文章
     *
     * @param articleGetReq
     * @return
     */
    ArticleRespBody getArticle(ArticleGetReq articleGetReq);

    /**
     * 新增文章
     *
     * @param essayAddReq
     * @return
     */
    void addArticle(ArticleAddReq essayAddReq);

    /**
     * 修改文章
     *
     * @param essayUpdateReq
     * @return
     */
    void updateArticle(ArticleUpdateReq essayUpdateReq);

    /**
     * 设置文章置顶状态
     *
     * @param bulletinUpdateReq
     * @return
     */
    void topPlaceArticle(ArticleStickTopReq bulletinUpdateReq);

    /**
     * 删除文章
     *
     * @param essayDeleteReq
     * @return
     */
    void deleteArticle(ArticleDeleteReq essayDeleteReq);
}
