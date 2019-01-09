package com.fenlibao.xinwang.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "interface_privilege")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class InterfacePrivilege {
    /**
     * 接入key
     */
    @Id
    @Column(name = "access_key")
    private String accessKey;

    /**
     * 接口调用方:1pms微服务 2网关微服务 3新网回调微服务 4定时器
     */
    @Column(name = "interface_user")
    private Integer interfaceUser;
}