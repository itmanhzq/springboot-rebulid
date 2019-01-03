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
@ApiModel(value = "AddPermissionReq[添加权限请求实体]")
public class AddPermissionReq implements Serializable {

    private static final long serialVersionUID = 5392987380927733747L;

    @ApiModelProperty(value = "权限id", required = true,example = "2")
    private String id;

    @ApiModelProperty(value = "父权限id", required = true,example = "1")
    @NotBlank
    private String parentId;

    @ApiModelProperty(value = "权限名称", required = true,example = "系统管理")
    @NotBlank
    private String name;

    @ApiModelProperty(value = "权限代码", required = true,example = "sysuser:view")
    @NotBlank
    private String code;

    @ApiModelProperty(value = "权限类别", required = true,example = "menu")
    @NotBlank
    private String type;


    @ApiModelProperty(value = "权限url", required = true,example = "/sysUser/view")
    private String path;


    @ApiModelProperty(value = "排序号", required = true,example = "1")
    @NotBlank
    private String orderId;


    @ApiModelProperty(value = "组件", required = true,example = "Home")
    @NotBlank
    private String component;

    @ApiModelProperty(value = "描述", required = true,example = "权限用途")
    private String marks;

    @ApiModelProperty(value = "图像", required = true)
    private String icon;



}
