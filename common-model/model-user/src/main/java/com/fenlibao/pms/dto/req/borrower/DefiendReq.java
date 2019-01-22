package com.fenlibao.pms.dto.req.borrower;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author chen
 * @date 2019/01/11
 */
@Getter
@Setter
@ApiModel(value = "DefiendReq[拉黑或取消拉黑请求实体]")
public class DefiendReq  implements Serializable {

    @ApiModelProperty(value = "用户id",required = true,example = "1")
    private String userId;

    @ApiModelProperty(value = "操作状态",required = true,example = "0:拉黑 1:取消拉黑")
    private String state;
}
