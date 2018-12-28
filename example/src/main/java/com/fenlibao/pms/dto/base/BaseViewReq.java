package com.fenlibao.pms.dto.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author WangBoRan
 * @date 2018-12-20
 */
@Getter
@Setter
public class BaseViewReq extends BaseReq {

    @ApiModelProperty("搜索值")
    private String searchValue;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;
}
