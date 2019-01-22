package com.fenlibao.pms.model.bo.borrower;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author chen
 * @date 2018/11/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "借款人信息")
public class BorrowerInfoBO extends BorrowerBaseBO implements Serializable {

    private static final long serialVersionUID = 6894528768862282059L;

    @ApiModelProperty(value = "用户类型" ,example = "0:个人 1:企业")
    private Integer type;

    @ApiModelProperty(value = "账号状态" ,example = "0:拉黑 1:正常 2:已注销")
    private Integer state;
}
