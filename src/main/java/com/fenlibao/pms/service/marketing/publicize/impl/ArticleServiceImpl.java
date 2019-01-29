package com.fenlibao.pms.service.marketing.publicize.impl;


import cn.hutool.core.util.IdUtil;
import com.fenlibao.common.core.Constants;
import com.fenlibao.marketing.dto.req.publicize.article.*;
import com.fenlibao.marketing.dto.resp.publicize.ArticleListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.ArticleRespBody;
import com.fenlibao.pms.common.http.QiniuFileUpload;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.config.Config;
import com.fenlibao.pms.config.PropertiesConfig;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.service.marketing.publicize.ArticleService;
import com.fenlibao.pms.service.system.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;


/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private Config config;
    @Autowired
    private UserService userService;
    @Autowired
    private PropertiesConfig propertiesConfig;

    private static final String FILE_NAME = "article_";

    @Override
    public PageInfo<ArticleListRespBody> getArticleList(ArticleGetListReq articleGetListReq) {
        PageInfo<ArticleListRespBody> pageInfo = new PageInfo<>();
        pageInfo.setList(new ArrayList<>());
        UserBO userBO = userService.getUser(articleGetListReq.getUserName());
        if (Objects.nonNull(userBO)) {
            articleGetListReq.setUserId(userBO.getId());
            String url = config.getMarketing() + propertiesConfig.getArticleList();
            String request = RequestUtil.toJson(articleGetListReq);
            pageInfo = RequestUtil.postReqPage(url, request, ArticleListRespBody.class);
            addInfo(pageInfo);
        }
        return pageInfo;
    }

    @Override
    public ArticleRespBody getArticle(ArticleGetReq articleGetReq) {
        String url = config.getMarketing() + propertiesConfig.getGetArticle();
        String request = RequestUtil.toJson(articleGetReq);
        ArticleRespBody body = RequestUtil.postReqBody(url, request, ArticleRespBody.class);
        body.setImageUrl(QiniuFileUpload.getUrl(body.getImageUrl()));
        return body;
    }

    @Override
    public Boolean addArticle(ArticleAddReq articleAddReq) {
        addArticleImage(articleAddReq);
        String url = config.getMarketing() + propertiesConfig.getAddArticle();
        String request = RequestUtil.toJson(articleAddReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    @Override
    public Boolean updateArticle(ArticleUpdateReq articleUpdateReq) {
        if (Strings.isNotEmpty(articleUpdateReq.getImageUrl())) {
            addArticleImage(articleUpdateReq);
        }
        String url = config.getMarketing() + propertiesConfig.getUpdateArticle();
        String request = RequestUtil.toJson(articleUpdateReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    @Override
    public Boolean stickTopArticle(ArticleStickTopReq articleStickTopReq) {
        String url = config.getMarketing() + propertiesConfig.getStickTopArticle();
        String request = RequestUtil.toJson(articleStickTopReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    @Override
    public Boolean deleteArticle(ArticleDeleteReq articleDeleteReq) {
        delteArticleImage(articleDeleteReq);
        String url = config.getMarketing() + propertiesConfig.getDeleteArticle();
        String request = RequestUtil.toJson(articleDeleteReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    /**
     * 删除文章图片
     *
     * @param articleDeleteReq
     */
    private void delteArticleImage(ArticleDeleteReq articleDeleteReq) {
        articleDeleteReq.getIds().forEach(id -> {
            ArticleGetReq articleGetReq = new ArticleGetReq();
            articleGetReq.setId(id);
            ArticleRespBody articleRespBody = getArticle(articleGetReq);
            QiniuFileUpload.deleteImage(articleRespBody.getImageUrl());
        });
    }

    /**
     * 上传文章图片
     *
     * @param articleReq
     */
    private void addArticleImage(ArticleReq articleReq) {
        String fileName = FILE_NAME + IdUtil.fastSimpleUUID() + Constants.IMAGE_TYPE_JPG;
        QiniuFileUpload.putBaes64(articleReq.getImageUrl(), fileName);
        articleReq.setImageUrl(fileName);
    }

    /**
     * 添加ArticleListRespBody字段信息
     *
     * @param pageInfo
     */
    private void addInfo(PageInfo<ArticleListRespBody> pageInfo) {
        pageInfo.getList().forEach(body -> {
            UserBO userBO = userService.getUserById(body.getUserId());
            body.setUserName(userBO.getUserName());
        });
    }
}
