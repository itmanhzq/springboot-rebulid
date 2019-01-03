package com.fenlibao.xinwang.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/12 10:53
 */
@Data
@ApiModel(value = "变更标的实体类")
public class ModifyProject extends BasePO {

    @NotNull(message = "标的号不能为空")
    @ApiModelProperty(required = true,value = "标的号",example = "2159944")
    private String projectNo;

    @NotNull(message = "标的状态不能为空")
    @ApiModelProperty(required = true,value = "标的状态",example = "FINISH")
    private String status;

}
