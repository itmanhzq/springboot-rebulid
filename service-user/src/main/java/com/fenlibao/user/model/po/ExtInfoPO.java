package com.fenlibao.user.model.po;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ext_info")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class ExtInfoPO extends BasePO {
    /**
     * 属性名
     */
    @Column(name = "ext_name")
    private String extName;

    /**
     * 属性编码
     */
    @Column(name = "ext_code")
    private String extCode;

    /**
     * 数据类型
     */
    @Column(name = "data_type")
    private String dataType;

    /**
     * 排序号
     */
    private Integer sort;

    /**
     * 是否展示该属性（1展示，0不展示）
     */
    private int display;
}