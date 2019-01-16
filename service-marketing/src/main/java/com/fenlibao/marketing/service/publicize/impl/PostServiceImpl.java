package com.fenlibao.marketing.service.publicize.impl;

import com.fenlibao.marketing.mapper.publicize.PostMapper;
import com.fenlibao.marketing.model.po.publicize.ContentPO;
import com.fenlibao.marketing.model.po.publicize.PostPO;
import com.fenlibao.marketing.service.publicize.ContentService;
import com.fenlibao.marketing.service.publicize.PostService;
import com.fenlibao.pms.dto.req.marketing.publicize.post.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.PostRespBody;
import com.fenlibao.pms.model.enums.publicize.PublicizeStats;
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
 * @date 2019/1/10
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private ContentService contentService;


    @SuppressWarnings("Duplicates")
    @Override
    public PageInfo<PostListRespBody> getPostList(PostGetListReq postGetListReq) {
        Weekend<PostPO> weekend = new Weekend<>(PostPO.class);
        Example example = new Example(PostPO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("title", postGetListReq.getTitle());
        criteria.andEqualTo("userId", postGetListReq.getUserId());
        criteria.andEqualTo("state", postGetListReq.getState());
        criteria.andLessThanOrEqualTo("showTime", postGetListReq.getShowEndTime());
        criteria.andGreaterThanOrEqualTo("showTime", postGetListReq.getShowStartTime());
        weekend.and(criteria);
        weekend.setOrderByClause("isStickTop DESC,sortTime DESC");
        PageInfo<PostPO> pos=PageHelper.startPage(postGetListReq.getPageNum(), postGetListReq.getPageSize())
                .doSelectPageInfo(() -> postMapper.selectByExample(weekend));
        return this.posConvertBody(pos, postGetListReq.getPageNum(), postGetListReq.getPageSize());
    }

    @Override
    public PostRespBody getPost(PostGetReq postGetReq) {
        PostPO postPO = postMapper.selectByPrimaryKey(postGetReq.getId());
        return this.poConvertBody(postPO);
    }

    @Override
    public void addPost(PostAddReq bulletinAddReq) {
        postMapper.insert(this.reqConvertPO(bulletinAddReq));
    }

    @Override
    public void updatePost(PostUpdateReq postUpdateReq) {
        PostPO postPO = postMapper.selectByPrimaryKey(postUpdateReq.getId());
        postMapper.updateByPrimaryKey(this.reqConvertPO(postUpdateReq));
        contentService.updateContent(new ContentPO(postPO.getContentId(), postUpdateReq.getContent()));
    }

    @Override
    public void stickTopPost(PostStickTopReq postStickTopReq) {
        PostPO postPO = postMapper.selectByPrimaryKey(postStickTopReq.getId());
        postPO.setIsStickTop(postStickTopReq.getTopPlace());
        postMapper.updateByPrimaryKey(postPO);
    }

    @Override
    public void deletePost(PostDeleteReq postDeleteReq) {
        postMapper.deleteByPrimaryKey(postDeleteReq.getIds());
    }

    /**
     * 转换公告集合
     *
     * @param list
     * @param pageNum
     * @param pageSize
     * @return
     */
    @SuppressWarnings("Duplicates")
    private PageInfo<PostListRespBody> posConvertBody(PageInfo<PostPO> list, int pageNum, int pageSize) {
        ModelMapper modelMapper = new ModelMapper();
        PageInfo<PostListRespBody> postBodyPage = modelMapper.map(list,PageInfo.class);
        List<PostListRespBody> postListRespBodies = new ArrayList<>();
        int index = pageNum * pageSize;
        for (PostPO postPO : list.getList()) {
            PostListRespBody postListRespBody = modelMapper.map(postPO, PostListRespBody.class);
            postListRespBody.setState(PublicizeStats.getMessage(postPO.getState()));
            postListRespBody.setOrder(index);
            postListRespBodies.add(postListRespBody);
            index++;
        }
        postBodyPage.setList(postListRespBodies);
        return postBodyPage;
    }

    /**
     * 转换公告类到body
     *
     * @param postPO
     * @return
     */
    private PostRespBody poConvertBody(PostPO postPO) {
        ModelMapper modelMapper = new ModelMapper();
        PostRespBody postRespBody = modelMapper.map(postPO, PostRespBody.class);
        postRespBody.setState(PublicizeStats.getMessage(postPO.getState()));
        postRespBody.setContent(contentService.getContent(postPO.getContentId()));
        return postRespBody;
    }

    /**
     * 转换公告类到Po
     *
     * @param postReq
     * @return
     */
    private PostPO reqConvertPO(PostReq postReq) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(postReq, PostPO.class);
    }
}
