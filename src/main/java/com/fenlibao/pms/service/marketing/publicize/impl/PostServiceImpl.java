package com.fenlibao.pms.service.marketing.publicize.impl;


import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.config.Config;
import com.fenlibao.pms.dto.req.marketing.publicize.post.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostRespBody;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.service.marketing.publicize.PostService;
import com.fenlibao.pms.service.system.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public PageInfo<PostListRespBody> getPostList(PostGetListReq postGetListReq) {
        UserBO userBO = userService.getUser(postGetListReq.getUserName());
        postGetListReq.setUserId(userBO.getId());
        String url = config.getMarketing() + "/publicize/post/getPostList";
        String request = RequestUtil.toJson(postGetListReq);
        return RequestUtil.postReqPage(url, request);
    }

    @Override
    public PostRespBody getPost(PostGetReq postGetReq) {
        String url = config.getMarketing() + "/publicize/post/getPost";
        String request = RequestUtil.toJson(postGetReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean addPost(PostAddReq postAddReq) {
        String url = config.getMarketing() + "/publicize/post/addPost";
        String request = RequestUtil.toJson(postAddReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean updatePost(PostUpdateReq postUpdateReq) {
        String url = config.getMarketing() + "/publicize/post/updatePost";
        String request = RequestUtil.toJson(postUpdateReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean stickTopPost(PostStickTopReq postStickTopReq) {
        String url = config.getMarketing() + "/publicize/post/stickTopPost";
        String request = RequestUtil.toJson(postStickTopReq);
        return RequestUtil.postReqBody(url, request);
    }

    @Override
    public Boolean deletePost(PostDeleteReq postDeleteReq) {
        String url = config.getMarketing() + "/publicize/post/deletePost";
        String request = RequestUtil.toJson(postDeleteReq);
        return RequestUtil.postReqBody(url, request);
    }

    /**
     * FriendLinkListRespBody
     *
     * @param pageInfo
     */
    private void addInfo(PageInfo<PostListRespBody> pageInfo) {
        pageInfo.getList().forEach(body -> {
            UserBO userBO = userService.getUserById(body.getUserId());
            body.setUserName(userBO.getUserName());
        });
    }
}
