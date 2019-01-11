package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author hubert
 * @Date: 2018/12/12 10:20
 */
@Data
@ApiModel(value = "单笔交易实体类")
public class SyncTransaction extends BasePO {

    @NotNull(message = "交易类型不能为空")
    @ApiModelProperty(required = true,value = "交易类型",example = "MARKETING")
    private String tradeType;

    @ApiModelProperty(value = "标的号",example = "2159031")
    private String projectNo;

    @NotNull(message = "债权出让请求流水号不能为空")
    @ApiModelProperty(required = true,value = "债权出让请求流水号",example = "20181225101433uu093ce13c")
    private String saleRequestNo;

    @ApiModelProperty(value = "业务明细")
    private List<Details> details;
}
