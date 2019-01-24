package com.fenlibao.bid.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 进件人列表
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@Data
@Builder
@ApiModel("IncomerListRespBody[进件人列表]")
public class IncomerListRespBody {
    @ApiModelProperty(value = "进件人姓名")
    private String name;
}
