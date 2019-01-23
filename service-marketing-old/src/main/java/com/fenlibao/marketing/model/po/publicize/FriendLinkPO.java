package com.fenlibao.marketing.model.po.publicize;

import com.fenlibao.base.po.BasePO;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */

@Table(name = "publicize_friend_link")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class FriendLinkPO extends BasePO {
    /**
     * 创建用户id 关联 idmt_user.id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 网站名称
     */
    @Column(name = "website_name")
    private String websiteName;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 位置排序
     */
    private Integer sort;

    /**
     * 浏览次数
     */
    private Integer views;

}