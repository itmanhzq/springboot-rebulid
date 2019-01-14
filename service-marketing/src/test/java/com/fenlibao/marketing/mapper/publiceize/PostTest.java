package com.fenlibao.marketing.mapper.publiceize;

import com.fenlibao.marketing.MarketingApplicationTests;
import com.fenlibao.marketing.service.PostService;
import com.fenlibao.pms.dto.req.marketing.publicize.post.PostGetListReq;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostListRespBody;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        List<PostListRespBody> postList = postService.getPostList(postGetListReq);
        log.debug("查询结果：");
        log.debug(postList.toString());
    }
}
