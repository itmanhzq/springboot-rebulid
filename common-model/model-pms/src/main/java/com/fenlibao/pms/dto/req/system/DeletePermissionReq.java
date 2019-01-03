package com.fenlibao.pms.dto.req.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author chen
 * @date 2018-11-26
 */
@Getter
@Setter
@ApiModel(value = "DeletePermissionReq[删除权限请求实体]")
public class DeletePermissionReq implements Serializable {

    private static final long serialVersionUID = 307891809330512278L;

    @ApiModelProperty(value = "权限id", required = true,example = "1")
    @NotBlank
    private String id;
}
