package com.fenlibao.xinwang.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author hubert
 * @Date: 2018/12/12 10:37
 */
@Data
@ApiModel(value = "单笔债权转让实体类")
public class DebentureSale extends BasePO {

    @NotNull(message = "标的号不能为空")
    @ApiModelProperty(required = true,value = "标的号",example = "hhher")
    private String projectNo;

    @NotNull(message = "出让份额不能为空")
    @ApiModelProperty(required = true,value = "出让份额",example = "168")
    private BigDecimal saleShare;

    @NotNull(message = "平台用户编号不能为空")
    @ApiModelProperty(required = true,value = "平台用户编号",example = "BORROWERS9234")
    private String platformUserNo;

}
