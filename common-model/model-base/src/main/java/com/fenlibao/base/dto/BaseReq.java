package com.fenlibao.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Toby
 * @date 2018/10/31
 */
@Getter
@Setter
public class BaseReq implements Serializable {
    private static final long serialVersionUID = 307891809330512278L;

    @ApiModelProperty(value = "属性字段", required = true,example = "{ \"name\": \"cxh\", \"sex\": \"man\" }")
    private String extData;

}
