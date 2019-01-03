package com.fenlibao.pms.dto.req.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author chen
 * @date 2018-12-06
 */
@Getter
@Setter
@ApiModel(value = "AddOrganizationReq[添加组织请求实体]")
public class AddOrganizationReq implements Serializable {

    private static final long serialVersionUID = 2734222680433377211L;

    @ApiModelProperty(value = "父id", required = true,example = "1")
    @NotBlank
    private String parentId;

    @ApiModelProperty(value = "组织名称", required = true,example = "技术部")
    @NotBlank
    private String name;

    @ApiModelProperty(value = "排序号", required = true,example = "1")
    @NotBlank
    private String orderId;

    @ApiModelProperty(value = "英文名字", required = true,example = "tony")
    private String eName;

    @ApiModelProperty(value = "备注", required = true,example = "")
    private String marks;

}
