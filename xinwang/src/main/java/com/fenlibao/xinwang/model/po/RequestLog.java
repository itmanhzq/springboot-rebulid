package com.fenlibao.xinwang.model.po;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Integer orderId;

    private Integer userId;

    private Integer interfaceUser;
    /**
     * 请求状态
     */
    private int status;

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