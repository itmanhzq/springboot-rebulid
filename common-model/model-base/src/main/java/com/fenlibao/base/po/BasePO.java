package com.fenlibao.base.po;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_time", nullable = false)
    private Date createTime = new Date();

    @Column(name = "updated_time", nullable = false)
    private Date updatedTime = new Date();
}