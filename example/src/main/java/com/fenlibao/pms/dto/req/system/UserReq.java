package com.fenlibao.pms.dto.req.system;/**
 * @author chen
 * @date 2018/11/20
 */

import com.fenlibao.pms.dto.base.AbstractPagingReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author chen
 * @date 2018-11-26
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ApiModel(value = "UserReq[用户请求实体]")
public class UserReq extends AbstractPagingReq implements Serializable {

    private static final long serialVersionUID = 2734222680433377211L;

    @ApiModelProperty(value = "用户名", required = true,example = "admin")
    private String name;

}
