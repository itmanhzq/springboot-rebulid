package com.fenlibao.pms.model.bo.idmt;

import lombok.Data;

import java.io.Serializable;

/**
 * @author WangBoRan
 * @date 2018-12-11
 */
@Data
public class RequestLogBO implements Serializable {
    private static final long serialVersionUID = 4830069807037521281L;
    /**
     * 用户 ip 地址
     */
    private String ip;
    /**
     * 访问uri
     */
    private String url;
    /**
     * 请求参数
     */
    private String reqContent;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;
}
