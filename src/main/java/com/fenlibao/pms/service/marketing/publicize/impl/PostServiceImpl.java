package com.fenlibao.pms.service.marketing.publicize.impl;


import com.fenlibao.marketing.dto.resp.publicize.ArticleListRespBody;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.config.Config;
import com.fenlibao.marketing.dto.req.publicize.post.*;
import com.fenlibao.marketing.dto.resp.publicize.PostListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.PostRespBody;
import com.fenlibao.pms.config.PropertiesConfig;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.service.marketing.publicize.PostService;
import com.fenlibao.pms.service.system.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author WangBoRan
 * @date 2019/1/10
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private Config config;
    @Autowired
    private UserService userService;
    @Autowired
    private PropertiesConfig propertiesConfig;

    @Override
    public PageInfo<PostListRespBody> getPostList(PostGetListReq postGetListReq) {
        UserBO userBO = userService.getUser(postGetListReq.getUserName());
        PageInfo<PostListRespBody> pageInfo = new PageInfo<>();
        pageInfo.setList(new ArrayList<>());
        if (Objects.nonNull(userBO)) {
            postGetListReq.setUserId(userBO.getId());
            addUserIdValue(postGetListReq);
            String url = config.getMarketing() + propertiesConfig.getGetPostList();
            String request = RequestUtil.toJson(postGetListReq);
            pageInfo = RequestUtil.postReqPage(url, request, PostListRespBody.class);
            addInfo(pageInfo);
        }
        return pageInfo;
    }

    @Override
    public PostRespBody getPost(PostGetReq postGetReq) {
        String url = config.getMarketing() + propertiesConfig.getGetPost();
        String request = RequestUtil.toJson(postGetReq);
        return RequestUtil.postReqBody(url, request, PostRespBody.class);
    }

    @Override
    public Boolean addPost(PostAddReq postAddReq) {
        String url = config.getMarketing() + propertiesConfig.getAddPost();
        String request = RequestUtil.toJson(postAddReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    @Override
    public Boolean updatePost(PostUpdateReq postUpdateReq) {
        String url = config.getMarketing() + propertiesConfig.getUpdatePost();
        String request = RequestUtil.toJson(postUpdateReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    @Override
    public Boolean stickTopPost(PostStickTopReq postStickTopReq) {
        String url = config.getMarketing() + propertiesConfig.getStickTopPost();
        String request = RequestUtil.toJson(postStickTopReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    @Override
    public Boolean deletePost(PostDeleteReq postDeleteReq) {
        String url = config.getMarketing() + "/publicize/post/deletePost";
        String request = RequestUtil.toJson(postDeleteReq);
        return RequestUtil.postReqBody(url, request, Boolean.class);
    }

    /**
     * 添加userId字段
     * @param postGetListReq
     */
    private void addUserIdValue(PostGetListReq postGetListReq) {
        String userName = postGetListReq.getUserName();
        userService.getUser(userName);
    }

    /**
     * 添加PostListRespBody字段信息
     * @param pageInfo
     */
    private void addInfo(PageInfo<PostListRespBody> pageInfo) {
        pageInfo.getList().forEach(body -> {
            UserBO userBO = userService.getUserById(body.getUserId());
            body.setUserName(userBO.getUserName());
        });
    }
}
