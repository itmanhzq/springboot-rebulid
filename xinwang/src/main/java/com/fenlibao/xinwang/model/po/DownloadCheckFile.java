package com.fenlibao.xinwang.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/14 10:53
 */
@Data
@ApiModel(value = "对账文件确认实体类")
public class DownloadCheckFile extends BasePO {

    @NotNull(message = "对账文件日期不能为空")
    @ApiModelProperty(required = true,value = "对账文件日期",example = "20181221")
    private String fileDate;

}
