package com.fenlibao.pms.model.po;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author:chen
 * @Date 2018-12-10
 */
@Table(name = "identify_image")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class IdentifyImagePO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 图片地址
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;
}