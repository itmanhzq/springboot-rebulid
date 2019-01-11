package com.fenlibao.marketing.service;

import com.fenlibao.pms.dto.req.marketing.publicize.post.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostRespBody;

import java.util.List;

/**
 * @author WangBoRan
 * @date 2019/1/10
 */
public interface PostService {
    /**
     * 查询公告列表
     *
     * @param postGetListReq
     * @return
     */
    List<PostListRespBody> getPostList(PostGetListReq postGetListReq);

    /**
     * 查询公告信息
     *
     * @param postGetReq
     * @return
     */
    PostRespBody getPost(PostGetReq postGetReq);

    /**
     * 添加公告
     *
     * @param bulletinAddReq
     */
    void addPost(PostAddReq bulletinAddReq);

    /**
     * 修改公告
     *
     * @param postUpdateReq
     */
    void updatePost(PostUpdateReq postUpdateReq);

    /**
     * 指定公告
     *
     * @param postStickTopReq
     */
    void stickTopPost(PostStickTopReq postStickTopReq);

    /**
     * 删除公告
     *
     * @param postDeleteReq
     */
    void deletePost(PostDeleteReq postDeleteReq);

}
