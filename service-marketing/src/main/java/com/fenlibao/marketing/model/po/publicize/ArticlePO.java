package com.fenlibao.marketing.model.po.publicize;

import com.fenlibao.base.po.BasePO;

import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */

@Table(name = "publicize_article")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class ArticlePO extends BasePO {
    /**
     * 创建用户id 关联 idmt_user.id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章类型 [1.行业新闻，2.媒体报道，3.公司动态]
     */
    private Integer type;

    /**
     * 文章来源
     */
    private String source;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 原文链接
     */
    @Column(name = "original_url")
    private String originalUrl;

    /**
     * 展示时间
     */
    @Column(name = "show_time")
    private Date showTime;

    /**
     * 列表页图片地址
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 排序时间
     */
    @Column(name = "sort_time")
    private Date sortTime;

    /**
     * 是否置顶 0:否; 1:是
     */
    @Column(name = "is_stick_top")
    private Boolean isStickTop;

    /**
     * 文章状态 [1.未发布，2.已发布，3.预发布]
     */
    private Integer state;

    /**
     * 文章关键字
     */
    private String keyword;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 预发布时间
     */
    @Column(name = "pre_online_time")
    private Date preOnlineTime;

    /**
     * 正文id publicize_content.id
     */
    @Column(name = "content_id")
    private Integer contentId;
}