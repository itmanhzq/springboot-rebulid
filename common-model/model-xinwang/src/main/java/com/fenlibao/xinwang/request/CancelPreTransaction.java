package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author hubert
 * @Date: 2018/12/12 16:29
 */
@Data
@ApiModel(value = "取消已冻结的预处理金额实体类")
public class CancelPreTransaction extends BasePO {

    @NotNull(message = "预处理业务流水号不能为空")
    @ApiModelProperty(required = true,value = "预处理业务流水号",example = "26443561")
    private String preTransactionNo;

    @NotNull(message = "取消金额不能为空")
    @ApiModelProperty(required = true,value = "取消金额",example = "250")
    private BigDecimal amount;
}
