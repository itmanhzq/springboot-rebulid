package com.fenlibao.marketing.service.impl;

import com.fenlibao.marketing.mapper.publicize.ArticleMapper;
import com.fenlibao.marketing.model.po.publicize.ArticlePO;
import com.fenlibao.marketing.model.po.publicize.ContentPO;
import com.fenlibao.marketing.service.ArticleService;
import com.fenlibao.marketing.service.ContentService;
import com.fenlibao.pms.dto.req.marketing.publicize.article.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleRespBody;
import com.fenlibao.pms.model.enums.publicize.PublicizeStats;
import com.fenlibao.pms.model.enums.publicize.AticleType;
import com.github.pagehelper.PageHelper;
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
    public List<ArticleListRespBody> getArticleList(ArticleGetListReq essayGetListReq) {
        Weekend<ArticlePO> weekend = new Weekend<>(ArticlePO.class);
        Example example = new Example(ArticlePO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("title", essayGetListReq.getTitle());
        criteria.andEqualTo("type", essayGetListReq.getType());
        criteria.andEqualTo("userId", essayGetListReq.getUserId());
        criteria.andEqualTo("state", essayGetListReq.getState());
        criteria.andLessThanOrEqualTo("showTime", essayGetListReq.getShowEndTime());
        criteria.andGreaterThanOrEqualTo("showTime", essayGetListReq.getShowStartTime());
        weekend.and(criteria);
        weekend.setOrderByClause("is_stick_top DESC,sort_time DESC");
        PageHelper.startPage(essayGetListReq.getPageNum(), essayGetListReq.getPageSize());
        List<ArticlePO> pos = articleMapper.selectByExample(weekend);
        return this.posConvertRespBody(pos, essayGetListReq.getPageNum(), essayGetListReq.getPageSize());
    }


    @Override
    public ArticleRespBody getArticle(ArticleGetReq articleGetReq) {
        ArticlePO articlePO = articleMapper.selectByPrimaryKey(articleGetReq.getId());
        return this.poConvertBody(articlePO);
    }

    @Override
    public void addArticle(ArticleAddReq essayAddReq) {
        articleMapper.insert(this.reqConvertPO(essayAddReq));
        contentService.addContent(essayAddReq.getContent());
    }

    @Override
    public void updateArticle(ArticleUpdateReq essayUpdateReq) {
        ArticlePO articlePO = articleMapper.selectByPrimaryKey(essayUpdateReq.getId());
        articleMapper.updateByPrimaryKey(this.reqConvertPO(essayUpdateReq));
        contentService.updateContent(new ContentPO(articlePO.getContentId(), essayUpdateReq.getContent()));
    }

    @Override
    public void topPlaceArticle(ArticleStickTopReq bulletinUpdateReq) {
        ArticlePO articlePO = articleMapper.selectByPrimaryKey(bulletinUpdateReq.getId());
        articlePO.setIsStickTop(bulletinUpdateReq.getIsStickTop());
        articleMapper.updateByPrimaryKey(articlePO);
    }

    @Override
    public void deleteArticle(ArticleDeleteReq essayDeleteReq) {
        List<Integer> ids = essayDeleteReq.getIds();
        ids.forEach(id -> articleMapper.deleteByPrimaryKey(id));
    }

    /**
     * 转换文章集合
     *
     * @param list
     * @return
     */
    private List<ArticleListRespBody> posConvertRespBody(List<ArticlePO> list, int pageNum, int pageSize) {
        ModelMapper modelMapper = new ModelMapper();
        List<ArticleListRespBody> articleList = new ArrayList<>();
        int index = pageNum * pageSize;
        for (ArticlePO articlePO : list) {
            ArticleListRespBody article = modelMapper.map(articlePO, ArticleListRespBody.class);
            article.setOrder(index);
            article.setState(PublicizeStats.getMessage(articlePO.getState()));
            article.setType(AticleType.getMessage(articlePO.getType()));
            articleList.add(article);
            index++;
        }
        return articleList;
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
