package com.fenlibao.marketing.model.po;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author WangBoRan
 * @date 2018-12-11
 * 基础持久对象类
 */
@Data
public class BasePO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(nullable = false)
    private Date createTime = new Date();

    @Column(nullable = false)
    private Date updatedTime = new Date();
}
