package com.fenlibao.xinwang.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/12 10:45
 */
@Data
@ApiModel(value = "取消债权实体类")
public class CancelDebentureSale extends BasePO {

    @NotNull(message = "债权出让请求流水号不能为空")
    @ApiModelProperty(required = true,value = "债权出让请求流水号",example = "201709121016498aaf95d1-b")
    private String creditsaleRequestNo;
}
