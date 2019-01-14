package com.fenlibao.marketing.service.impl;

import com.fenlibao.marketing.mapper.publicize.ContentMapper;
import com.fenlibao.marketing.model.po.publicize.ContentPO;
import com.fenlibao.marketing.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WangBoRan
 * @date 2019/1/11
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;


    @Override
    public String getContent(int id) {
        ContentPO contentPO = contentMapper.selectByPrimaryKey(id);
        return contentPO.getContent();
    }

    @Override
    public int addContent(String content) {
        ContentPO po = new ContentPO();
        po.setContent(content);
        contentMapper.insert(po);
        return po.getId();
    }

    @Override
    public void updateContent(ContentPO po) {
        contentMapper.updateByPrimaryKey(po);
    }
}
