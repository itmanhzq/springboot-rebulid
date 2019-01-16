package com.fenlibao.pms.service.marketing.publicize.impl;


import com.fenlibao.pms.dto.req.marketing.publicize.post.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostRespBody;
import com.fenlibao.pms.service.marketing.publicize.PostService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @author WangBoRan
 * @date 2019/1/10
 */
@Service
public class PostServiceImpl implements PostService {

    @Override
    public PageInfo<PostListRespBody> getPostList(PostGetListReq postGetListReq) {
        return null;
    }

    @Override
    public PostRespBody getPost(PostGetReq postGetReq) {
        return null;
    }

    @Override
    public void addPost(PostAddReq bulletinAddReq) {

    }

    @Override
    public void updatePost(PostUpdateReq postUpdateReq) {

    }

    @Override
    public void stickTopPost(PostStickTopReq postStickTopReq) {

    }

    @Override
    public void deletePost(PostDeleteReq postDeleteReq) {

    }
}
