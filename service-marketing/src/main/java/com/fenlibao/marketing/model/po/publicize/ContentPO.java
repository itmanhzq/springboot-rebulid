package com.fenlibao.marketing.model.po.publicize;

import com.fenlibao.base.po.BasePO;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */

@Table(name = "publicize_content")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class ContentPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 正文文本
     */
    private String content;
}