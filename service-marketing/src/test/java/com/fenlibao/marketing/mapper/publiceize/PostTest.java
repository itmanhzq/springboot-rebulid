package com.fenlibao.marketing.mapper.publiceize;

import com.fenlibao.marketing.MarketingApplicationTests;
import com.fenlibao.marketing.service.publicize.PostService;
import com.fenlibao.pms.dto.req.marketing.publicize.post.PostGetListReq;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostListRespBody;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WangBoRan
 * @date 2019/1/14
 */
@Slf4j
public class PostTest extends MarketingApplicationTests {
    @Autowired
    private PostService postService;

    @Test
    public void testGetArticleList() {
        PostGetListReq postGetListReq = new PostGetListReq();
        PageInfo<PostListRespBody> postList = postService.getPostList(postGetListReq);
        log.debug("查询结果：");
        log.debug(postList.toString());
    }
}
