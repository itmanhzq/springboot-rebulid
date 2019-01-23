package com.fenlibao.marketing.service.publicize;

import com.fenlibao.marketing.model.po.publicize.ContentPO;


/**
 * @author WangBoRan
 * @date 2019/1/11
 */
public interface ContentService {
    /**
     * 获得信息正文
     *
     * @param id 正文Id
     * @return 文章正文
     */
    String getContent(int id);

    /**
     * 添加正文
     *
     * @param content 正文
     * @return id
     */
    int addContent(String content);

    /**
     * 修改正文
     *
     * @param po
     */
    void updateContent(ContentPO po);
}
