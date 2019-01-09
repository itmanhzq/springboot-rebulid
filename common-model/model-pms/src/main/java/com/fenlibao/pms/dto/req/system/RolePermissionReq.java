package com.fenlibao.pms.dto.req.system;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author chen
 * @date 2018/11/20
 */
@Getter
@Setter
@ApiModel(value = "RolePermissionReq[角色权限请求实体]")
public class RolePermissionReq extends BaseReq implements Serializable {


    private static final long serialVersionUID = -7575134147364942010L;

    @NotBlank
    @ApiModelProperty(value = "用户token", required = true)
    private String accessToken;

    @NotBlank
    @ApiModelProperty(value = "菜单类型", required = true, example = "menu")
    private String type;


}
