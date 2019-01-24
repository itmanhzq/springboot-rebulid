package com.fenlibao.marketing.service.publicize;

import com.fenlibao.marketing.dto.req.publicize.post.*;
import com.fenlibao.marketing.dto.resp.publicize.PostListRespBody;
import com.fenlibao.marketing.dto.resp.publicize.PostRespBody;
import com.github.pagehelper.PageInfo;

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
    PageInfo<PostListRespBody> getPostList(PostGetListReq postGetListReq);

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
     * @param postAddReq
     */
    void addPost(PostAddReq postAddReq);

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
