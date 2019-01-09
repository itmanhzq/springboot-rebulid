package com.fenlibao.pms.model.po.idmt;

import com.fenlibao.pms.model.po.BasePO;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
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
@Table(name = "idmt_user")
public class UserPO extends BasePO {

    List<RolePO> roles;
    OrganizationPO organization;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "real_name")
    private String realName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "status")
    private Integer status;
    @Column(name = "create_id")
    private Integer createId;
    @Column(name = "last_changepwd_time")
    private Date lastChangepwdTime;
    @Column(name = "dimission")
    private Boolean dimission;
    @Column(name = "error_number")
    private Integer errorNumber;
}