package com.fenlibao.pms.model.po.idmt;

import com.fenlibao.base.po.BasePO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;


/**
 * @author chen
 * @date 2018-12-10
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "idmt_request_log")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class RequestLogPO extends BasePO {
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户 ip 地址
     */
    private String ip;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 访问时间
     */
    @Column(name = "cost_time")
    private Long costTime;

    /**
     * 请求参数
     */
    @Column(name = "req_content")
    private String reqContent;
}