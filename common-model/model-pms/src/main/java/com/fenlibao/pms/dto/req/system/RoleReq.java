package com.fenlibao.pms.dto.req.system;

import com.fenlibao.pms.dto.base.NonParmsAbstractPagingReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * RoleReq
 *
 * @author LeiXinXin
 * @date 2018/12/13
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "RoleReq[角色列表请求实体]")
public class RoleReq extends NonParmsAbstractPagingReq implements Serializable {

    private static final long serialVersionUID = 2939366168773925788L;

    @ApiModelProperty(value = "角色id ", required = true,example = "1")
    @NotNull(message = "角色Id不能为空")
    private Integer roleId;
}
