package com.fenlibao.pms.dto.req.borrower;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author chen
 * @date 2019/01/11
 */
@Getter
@Setter
@ApiModel(value = "DefiendReq[借款人信息请求尸体]")
public class BorrowerDetailReq implements Serializable {

    @ApiModelProperty(value = "用户id",required = true,example = "1")
    @NonNull
    private String userId;

}
