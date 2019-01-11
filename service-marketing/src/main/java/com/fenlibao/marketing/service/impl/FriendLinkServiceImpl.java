package com.fenlibao.marketing.service.impl;

import cn.hutool.core.util.PageUtil;
import com.fenlibao.marketing.mapper.publicize.FriendLinkMapper;
import com.fenlibao.marketing.model.po.publicize.FriendLinkPO;
import com.fenlibao.marketing.service.FriendLinkService;
import com.fenlibao.pms.dto.req.marketing.publicize.frinedlink.*;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkListRespBody;
import com.fenlibao.pms.dto.resp.marketing.publicize.FriendLinkRespBody;
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
 * @date 2019/1/10
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {
    @Autowired
    private FriendLinkMapper friendLinkMapper;

    @Override
    public List<FriendLinkListRespBody> getFriendLink(FriendLinkGetListReq friendLinkGetListReq) {
        Weekend<FriendLinkPO> weekend = new Weekend<>(FriendLinkPO.class);
        Example example = new Example(FriendLinkPO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("websiteName", friendLinkGetListReq.getWebsiteName());
        criteria.andEqualTo("userId", friendLinkGetListReq.getUserId());
        criteria.andLessThanOrEqualTo("updatedTime", friendLinkGetListReq.getUpdatedEndTime());
        criteria.andGreaterThanOrEqualTo("updatedTime", friendLinkGetListReq.getUpdatedStartTime());
        weekend.and(criteria);
        String orderBySort = "sort DESC";
        PageHelper.startPage(friendLinkGetListReq.getPageNum(), friendLinkGetListReq.getPageSize(), orderBySort);
        List<FriendLinkPO> pos = friendLinkMapper.selectByExample(weekend);
        return this.posConvertRespBody(pos, friendLinkGetListReq.getPageNum(), friendLinkGetListReq.getPageSize());
    }

    @Override
    public FriendLinkRespBody getFriendLink(FriendLinkGetReq friendLinkGetReq) {
        FriendLinkPO friendLinkPO = friendLinkMapper.selectByPrimaryKey(friendLinkGetReq.getId());
        return this.psConvertRespBody(friendLinkPO);
    }

    @Override
    public void addFriendLink(FriendLinkAddReq friendLinkAddReq) {
        friendLinkMapper.insert(this.reqConvertPO(friendLinkAddReq));
    }

    @Override
    public void updateFriendLink(FriendLinkUpdateReq friendLinkUpdateReq) {
        friendLinkMapper.updateByPrimaryKey(this.reqConvertPO(friendLinkUpdateReq));
    }

    @Override
    public void deleteFriendLink(FriendLinkDeleteReq friendLinkDeleteReq) {
        List<Integer> ids = friendLinkDeleteReq.getIds();
        ids.forEach(id -> friendLinkMapper.deleteByPrimaryKey(id));
    }

    /**
     * 转换友链集合
     *
     * @param list
     * @param pageNum
     * @param pageSize
     * @return
     */
    private List<FriendLinkListRespBody> posConvertRespBody(List<FriendLinkPO> list, int pageNum, int pageSize) {
        ModelMapper modelMapper = new ModelMapper();
        List<FriendLinkListRespBody> friendLinkRespBodyList = new ArrayList<>();
        int index = pageNum * pageSize;
        for (FriendLinkPO friendLinkPO : list) {
            FriendLinkListRespBody friendLink = modelMapper.map(friendLinkPO, FriendLinkListRespBody.class);
            friendLink.setOrder(index);
            index++;
            friendLinkRespBodyList.add(friendLink);
        }
        return friendLinkRespBodyList;
    }

    /**
     * 转换友链到Body
     *
     * @param friendLinkPO
     * @return
     */
    private FriendLinkRespBody psConvertRespBody(FriendLinkPO friendLinkPO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(friendLinkPO, FriendLinkRespBody.class);
    }

    /**
     * 转换友链到po
     *
     * @param friendLinkReq
     * @return
     */
    private FriendLinkPO reqConvertPO(FriendLinkReq friendLinkReq) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(friendLinkReq, FriendLinkPO.class);
    }
}
