package com.fenlibao.pms.service.marketing.publicize;

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
    Boolean addPost(PostAddReq postAddReq);

    /**
     * 修改公告
     *
     * @param postUpdateReq
     */
    Boolean updatePost(PostUpdateReq postUpdateReq);

    /**
     * 指定公告
     *
     * @param postStickTopReq
     */
    Boolean stickTopPost(PostStickTopReq postStickTopReq);

    /**
     * 删除公告
     *
     * @param postDeleteReq
     */
    Boolean deletePost(PostDeleteReq postDeleteReq);

}
