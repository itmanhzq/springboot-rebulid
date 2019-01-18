package com.fenlibao.pms.service.marketing.publicize.impl;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ImageUtil;
import cn.hutool.core.util.RandomUtil;
import com.fenlibao.common.core.Constants;
import com.fenlibao.pms.common.http.QiniuFileUpload;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.config.Config;
import com.fenlibao.pms.dto.req.marketing.publicize.article.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleRespBody;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.service.marketing.publicize.ArticleService;
import com.fenlibao.pms.service.system.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;


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

    private static final String FILE_NAME = "article_";

    @Override
    public PageInfo<ArticleListRespBody> getArticleList(ArticleGetListReq articleGetListReq) {
        UserBO user = userService.getUser(articleGetListReq.getUserName());
        articleGetListReq.setUserId(user.getId());
        String url = config.getMarketing() + "/publicize/article/getArticleList";
        String request = RequestUtil.toJson(articleGetListReq);
        PageInfo<ArticleListRespBody> pageInfo = RequestUtil.postReqPage(url, request);
        this.addInfo(pageInfo);
        return pageInfo;
    }

    @Override
    public ArticleRespBody getArticle(ArticleGetReq articleGetReq) {
        String url = config.getMarketing() + "/publicize/article/getArticle";
        String request = RequestUtil.toJson(articleGetReq);
        ArticleRespBody body = RequestUtil.postReqBody(url, request);
        return body;
    }

    @Override
    public Boolean addArticle(ArticleAddReq articleAddReq) {
        String fileName = FILE_NAME + IdUtil.fastSimpleUUID() + Constants.IMAGE_TYPE_JPG;
        QiniuFileUpload.putBaes64(articleAddReq.getImageUrl(), fileName);
        articleAddReq.setImageUrl(fileName);

        String url = config.getMarketing() + "/publicize/article/addArticle";
        String request = RequestUtil.toJson(articleAddReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean updateArticle(ArticleUpdateReq articleUpdateReq) {
        String url = config.getMarketing() + "/publicize/article/updateArticle";
        String request = RequestUtil.toJson(articleUpdateReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean topPlaceArticle(ArticleStickTopReq articleStickTopReq) {
        String url = config.getMarketing() + "/publicize/article/articleStickTopReq";
        String request = RequestUtil.toJson(articleStickTopReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean deleteArticle(ArticleDeleteReq essayDeleteReq) {
        String url = config.getMarketing() + "/publicize/article/updateArticle";
        String request = RequestUtil.toJson(essayDeleteReq);
        return RequestUtil.postReqBody(url, request);
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
