package com.fenlibao.user.model.po;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ext_data")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class ExtDataPO extends BasePO {
    /**
     * 平台用户id,t_user.id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 属性定义的ID（关联t_bid_ext_info）
     */
    @Column(name = "ext_id")
    private Integer extId;

    /**
     * 属性的值
     */
    @Column(name = "ext_data")
    private String extData;

    /**
     * 说明
     */
    private String remark;
}