package com.fenlibao.marketing.service.publicize.impl;

import com.fenlibao.marketing.dto.ResponseStatus;
import com.fenlibao.marketing.exception.MarketingException;
import com.fenlibao.marketing.mapper.publicize.ArticleMapper;
import com.fenlibao.marketing.model.po.publicize.ArticlePO;
import com.fenlibao.marketing.model.po.publicize.ContentPO;
import com.fenlibao.marketing.service.publicize.ArticleService;
import com.fenlibao.marketing.service.publicize.ContentService;
import com.fenlibao.pms.dto.req.marketing.publicize.article.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleRespBody;
import com.fenlibao.pms.model.enums.publicize.PublicizeStats;
import com.fenlibao.pms.model.enums.publicize.AticleType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.ArrayList;
import java.util.List;


/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ContentService contentService;

    @SuppressWarnings("Duplicates")
    @Override
    public PageInfo<ArticleListRespBody> getArticleList(ArticleGetListReq articleGetListReq) throws MarketingException {
        if(articleGetListReq.getShowEndTime()!=null && articleGetListReq.getShowStartTime()!=null){
            throw new MarketingException(ResponseStatus.COMMON_SELECT_DATE_LACK);
        }
        Weekend<ArticlePO> weekend = new Weekend<>(ArticlePO.class);
        Example example = new Example(ArticlePO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("title", articleGetListReq.getTitle());
        criteria.andEqualTo("type", articleGetListReq.getType());
        criteria.andEqualTo("userId", articleGetListReq.getUserId());
        criteria.andEqualTo("state", articleGetListReq.getState());
        criteria.andLessThanOrEqualTo("showTime", articleGetListReq.getShowEndTime());
        criteria.andGreaterThanOrEqualTo("showTime", articleGetListReq.getShowStartTime());
        weekend.and(criteria);
        weekend.setOrderByClause("is_stick_top DESC,sort_time DESC");
        PageInfo<ArticlePO> pos=PageHelper.startPage(articleGetListReq.getPageNum(), articleGetListReq.getPageSize())
                .doSelectPageInfo(() -> articleMapper.selectByExample(weekend));
        return this.posConvertRespBody(pos, articleGetListReq.getPageNum(), articleGetListReq.getPageSize());
    }


    @Override
    public ArticleRespBody getArticle(ArticleGetReq articleGetReq) {
        ArticlePO articlePO = articleMapper.selectByPrimaryKey(articleGetReq.getId());

        return this.poConvertBody(articlePO);
    }

    @Override
    public void addArticle(ArticleAddReq articleAddReq) {
        ArticlePO articlePO = this.reqConvertPO(articleAddReq);
        int contentId = contentService.addContent(articleAddReq.getContent());
        articlePO.setContentId(contentId);
        articleMapper.insert(articlePO);

    }

    @Override
    public void updateArticle(ArticleUpdateReq articleUpdateReq) {
        ArticlePO articlePO = articleMapper.selectByPrimaryKey(articleUpdateReq.getId());
        articleMapper.updateByPrimaryKey(this.reqConvertPO(articleUpdateReq));
        contentService.updateContent(new ContentPO(articlePO.getContentId(), articleUpdateReq.getContent()));
    }

    @Override
    public void topPlaceArticle(ArticleStickTopReq articleStickTopReq) {
        ArticlePO articlePO = articleMapper.selectByPrimaryKey(articleStickTopReq.getId());
        articlePO.setIsStickTop(articleStickTopReq.getIsStickTop());
        articleMapper.updateByPrimaryKey(articlePO);
    }

    @Override
    public void deleteArticle(ArticleDeleteReq articleDeleteReq) {
        List<Integer> ids = articleDeleteReq.getIds();
        ids.forEach(id -> articleMapper.deleteByPrimaryKey(id));
    }

    /**
     * 转换文章集合
     *
     * @param list
     * @return
     */
    @SuppressWarnings("Duplicates")
    private PageInfo<ArticleListRespBody> posConvertRespBody(PageInfo<ArticlePO> list, int pageNum, int pageSize) {
        ModelMapper modelMapper = new ModelMapper();
        PageInfo<ArticleListRespBody> pageInfo = modelMapper.map(list, PageInfo.class);
        List<ArticleListRespBody> articleList = new ArrayList<>();
        int index = pageNum * pageSize;
        for (ArticlePO articlePO : list.getList()) {
            ArticleListRespBody article = modelMapper.map(articlePO, ArticleListRespBody.class);
            article.setOrder(index);
            article.setState(PublicizeStats.getMessage(articlePO.getState()));
            article.setType(AticleType.getMessage(articlePO.getType()));
            articleList.add(article);
            index++;
        }
        pageInfo.setList(articleList);
        return pageInfo;
    }


    /**
     * 转换文章对象到Body
     *
     * @param articlePO
     * @return
     */
    private ArticleRespBody poConvertBody(ArticlePO articlePO) {
        ModelMapper modelMapper = new ModelMapper();
        ArticleRespBody article = modelMapper.map(articlePO, ArticleRespBody.class);
        article.setState(PublicizeStats.getMessage(articlePO.getState()));
        article.setType(AticleType.getMessage(articlePO.getType()));
        article.setContent(contentService.getContent(articlePO.getContentId()));
        return article;
    }


    /**
     * 转换文章对象到Po
     *
     * @param articleReq
     * @return
     */
    private ArticlePO reqConvertPO(ArticleReq articleReq) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(articleReq, ArticlePO.class);
    }
}
