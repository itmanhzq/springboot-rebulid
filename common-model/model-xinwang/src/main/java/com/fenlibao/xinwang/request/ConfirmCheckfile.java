package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @author hubert
 * @Date: 2018/12/14 10:53
 */
@Data
@ApiModel(value = "对账文件确认实体类")
public class ConfirmCheckfile extends BasePO {

    @NotNull(message = "对账文件日期不能为空")
    @ApiModelProperty(required = true,value = "对账文件日期",example = "www.fenlibao.com")
    private String fileDate;

    @NotNull(message = "对账文件类型不能为空")
    @ApiModelProperty(required = true,value = "对账文件类型")
    private List<Map<String,String>> detail;

    @ApiModelProperty(value = "对账文件类型",example = "COMMISSION")
    private String fileType;

}
