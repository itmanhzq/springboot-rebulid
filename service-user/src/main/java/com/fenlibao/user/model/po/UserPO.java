package com.fenlibao.user.model.po;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "t_user")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class UserPO extends BasePO {
    /**
     * 用户登录账号
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户登录密码
     */
    private String passwd;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户类型,0: 个人用户; 1:企业用户;
     */
    @Column(name = "user_type")
    private Boolean userType;

    /**
     * 状态,0: 锁定; 1:启用; 2:黑名单;
     */
    private Boolean state;

    /**
     * 用户类型,0: pc官网; 1:app; 2:wap
     */
    @Column(name = "register_origin")
    private Boolean registerOrigin;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

    /**
     * 担保方,1:是;0:否;
     */
    @Column(name = "is_guarantee")
    private Boolean isGuarantee;

    /**
     * 当日交易密码输入错误次数
     */
    @Column(name = "error_num")
    private Byte errorNum;

    /**
     * 是否第一次登陆系统,1:是;0:否;
     */
    @Column(name = "is_first_login")
    private Boolean isFirstLogin;

    /**
     * 企业账户id 关联t_enterprise.id
     */
    @Column(name = "enterprise_id")
    private Integer enterpriseId;
}