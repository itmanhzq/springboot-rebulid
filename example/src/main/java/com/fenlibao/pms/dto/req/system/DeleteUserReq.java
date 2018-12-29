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
@ApiModel(value = "DeleteUserReq[删除用户请求实体]")
public class DeleteUserReq implements Serializable {


    private static final long serialVersionUID = 5623740302013898835L;

    @ApiModelProperty(value = "用户id", required = true,example = "1")
    @NotBlank
    private Integer userId;
}
