package com.fenlibao.pms.model.po.idmt;

import com.fenlibao.pms.model.po.BasePO;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author chen
 * @date 2018/11/22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "idmt_role")
public class RolePO extends BasePO {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "sort")
    private Integer sort;


    @Transient
    private List<RolePermissionPO> rolePermission;
}
