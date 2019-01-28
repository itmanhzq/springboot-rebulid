package com.fenlibao.pms.model.po.idmt;

import com.fenlibao.base.po.BasePO;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author chen
 * @date 2018/11/22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "idmt_permission")
public class PermissionPO extends BasePO {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "parent_id")
    private Integer pid;

    @Column(name = "name")
    private String name;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "type")
    private String type;

    @Column(name = "permit_url")
    private String path;


    @Column(name = "component")
    private String component;

    @Column(name = "icon")
    private String icon;

    @Column(name = "is_login")
    private Boolean isLogin;

    @Column(name = "code")
    private String code;


    @Column(name = "description")
    private String description;


    private Collection<PermissionPO> children;
}
