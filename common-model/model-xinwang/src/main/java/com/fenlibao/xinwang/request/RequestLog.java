package com.fenlibao.xinwang.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "request_log")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class RequestLog {
    private Integer id;

    /**
     * 接口名称
     */
    @Column(name = "interface_name")
    private String interfaceName;

    /**
     * 请求流水号
     */
    @Column(name = "request_no")
    private String requestNo;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "interface_user")
    private Integer interfaceUser;
    /**
     * 请求状态
     */
    @Column(name = "status")
    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 请求参数
     */
    @Column(name = "request_params")
    private String requestParams;

    /**
     * 返回报文
     */
    @Column(name = "response_msg")
    private String responseMsg;



}