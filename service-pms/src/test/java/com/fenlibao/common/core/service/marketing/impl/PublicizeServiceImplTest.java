package com.fenlibao.common.core.service.marketing.impl;

import cn.hutool.core.util.IdUtil;
import com.fenlibao.pms.PmsApplication;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.dto.req.marketing.publicize.article.ArticleGetListReq;
import com.fenlibao.pms.dto.req.marketing.publicize.frinedlink.FriendLinkGetListReq;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkListRespBody;
import com.fenlibao.pms.service.marketing.publicize.ArticleService;
import com.fenlibao.pms.service.marketing.publicize.FriendLinkService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author WangBoRan
 * @date 2019/1/16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PmsApplication.class)
public class PublicizeServiceImplTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private FriendLinkService friendLinkService;

    @Test
    public void getArticleListTest() {
        ArticleGetListReq articleGetListReq = new ArticleGetListReq();
        PageInfo<ArticleListRespBody> pageInfo = articleService.getArticleList(articleGetListReq);
        log.info(pageInfo.toString());
    }

    @Test
    public void getFriendLinkListTest() {
        FriendLinkGetListReq friendLinkGetListReq = new FriendLinkGetListReq();
        PageInfo<FriendLinkListRespBody> pageInfo = friendLinkService.getFriendLinkList(friendLinkGetListReq);
        log.info(pageInfo.toString());
    }


    @Test
    public void test() {
        String ss = "[{\"id\":1154.0,\"order\":10.0,\"title\":\"广州市金融主管部门领导莅临分利宝广州总部指导工作！\",\"type\":\"公司动态\",\"source\":\"分利宝\",\"originalUrl\":\"www.fenlibao.com\",\"state\":\"\",\"showTime\":1.54654093E12,\"sortTime\":1.54654093E12,\"isStickTop\":true,\"userId\":1045.0},{\"id\":862.0,\"order\":11.0,\"title\":\"南粤基金领导认可分利宝，并给予分利宝工作支持！\",\"type\":\"公司动态\",\"source\":\"分利宝\",\"originalUrl\":\"www.fenlibao.com\",\"state\":\"未发布\",\"showTime\":1.5010272E12,\"sortTime\":1.546540911E12,\"isStickTop\":true,\"userId\":1045.0},{\"id\":1404.0,\"order\":12.0,\"title\":\"分利宝提前提交整改验收自查材料，合规再下一城！\",\"type\":\"公司动态\",\"source\":\"分利宝\",\"originalUrl\":\"www.fenlibao.com\",\"state\":\"未发布\",\"showTime\":1.539773022E12,\"sortTime\":1.539773031E12,\"isStickTop\":true,\"userId\":1045.0},{\"id\":1403.0,\"order\":13.0,\"title\":\"分利宝合规再升级！新网银行入围中国互金协会首批公示存管白名单\",\"type\":\"公司动态\",\"source\":\"分利宝\",\"originalUrl\":\"www.fenlibao.com\",\"state\":\"未发布\",\"showTime\":1.539772237E12,\"sortTime\":1.539772354E12,\"isStickTop\":true,\"userId\":1045.0},{\"id\":1402.0,\"order\":14.0,\"title\":\"分利宝首届「特约产品体验官」名单公示，速来围观！\",\"type\":\"公司动态\",\"source\":\"分利宝\",\"originalUrl\":\"www.fenlibao.com\",\"state\":\"未发布\",\"showTime\":1.5397344E12,\"sortTime\":1.539772199E12,\"isStickTop\":true,\"userId\":1045.0},{\"id\":1401.0,\"order\":15.0,\"title\":\"访谈实记：零距离对话分利宝总经理刘维国\",\"type\":\"公司动态\",\"source\":\"分利宝\",\"originalUrl\":\"www.fenlibao.com\",\"state\":\"未发布\",\"showTime\":1.5355008E12,\"sortTime\":1.535554494E12,\"isStickTop\":true,\"userId\":1045.0},{\"id\":1400.0,\"order\":16.0,\"title\":\"分利宝受邀参加广州互金协会举办第十期互联网金融机构高管培训会\",\"type\":\"公司动态\",\"source\":\"分利宝\",\"originalUrl\":\"www.fenlibao.com\",\"state\":\"未发布\",\"showTime\":1.5355008E12,\"sortTime\":1.535553729E12,\"isStickTop\":true,\"userId\":1045.0},{\"id\":1393.0,\"order\":17.0,\"title\":\"新手如何理财呢？有什么方法及建议？\",\"type\":\"行业新闻\",\"source\":\"分利宝\",\"state\":\"未发布\",\"showTime\":1.524938621E12,\"sortTime\":1.524938733E12,\"isStickTop\":true,\"userId\":1045.0},{\"id\":1392.0,\"order\":18.0,\"title\":\"P2P投资理财比较适合哪些人群呢？\",\"type\":\"行业新闻\",\"source\":\"分利宝\",\"state\":\"未发布\",\"showTime\":1.524938461E12,\"sortTime\":1.524938472E12,\"isStickTop\":true,\"userId\":1045.0},{\"id\":1391.0,\"order\":19.0,\"title\":\"新手投资理财有哪些比较好的技巧呢？\",\"type\":\"行业新闻\",\"source\":\"分利宝\",\"state\":\"未发布\",\"showTime\":1.524938276E12,\"sortTime\":1.524938287E12,\"isStickTop\":true,\"userId\":1045.0}]";
        RequestUtil.toList(ss, ArticleListRespBody.class);
    }


}
