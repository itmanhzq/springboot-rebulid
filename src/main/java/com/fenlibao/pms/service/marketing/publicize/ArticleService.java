package com.fenlibao.pms.service.marketing.publicize;

import com.fenlibao.marketing.dto.req.publicize.article.*;
import com.fenlibao.marketing.dto.resp.publicize.ArticleListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.ArticleRespBody;
import com.github.pagehelper.PageInfo;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */
public interface ArticleService {

    /**
     * 文章列表
     *
     * @param articleGetListReq
     * @return
     */
    PageInfo<ArticleListRespBody> getArticleList(ArticleGetListReq articleGetListReq);

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
     * @param articleAddReq
     * @return
     */
    Boolean addArticle(ArticleAddReq articleAddReq);

    /**
     * 修改文章
     *
     * @param articleUpdateReq
     * @return
     */
    Boolean updateArticle(ArticleUpdateReq articleUpdateReq);

    /**
     * 设置文章置顶状态
     *
     * @param articleStickTopReq
     * @return
     */
    Boolean topPlaceArticle(ArticleStickTopReq articleStickTopReq);

    /**
     * 删除文章
     *
     * @param articleDeleteReq
     * @return
     */
    Boolean deleteArticle(ArticleDeleteReq articleDeleteReq);
}
