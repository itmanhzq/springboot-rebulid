package com.fenlibao.pms.dto.req.system;

import com.fenlibao.base.dto.AbstractPagingReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author chen
 * @date 2018-12-06
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ApiModel(value = "OrganizationReq[组织列表请求实体]")
public class OrganizationReq extends AbstractPagingReq implements Serializable {

    private static final long serialVersionUID = 2734222680433377211L;

    @ApiModelProperty(value = "组织id ", required = true,example = "1")
    @NotNull(message = "角色父级Id不能为空")
    private Integer organizationId;

    @ApiModelProperty(value = "状态 0:禁用 1：启用 ", required = true,example = "1")
    private String status;

}
