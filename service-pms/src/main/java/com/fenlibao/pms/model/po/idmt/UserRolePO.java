package com.fenlibao.pms.model.po.idmt;

import com.fenlibao.pms.model.po.BasePO;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author chen
 * @date 2018/11/14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "idmt_user_role")
public class UserRolePO extends BasePO {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private RolePO role;

}
