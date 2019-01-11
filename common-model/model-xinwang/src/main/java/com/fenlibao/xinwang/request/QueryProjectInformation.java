package com.fenlibao.xinwang.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author hubert
 * @Date: 2018/12/12 9:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "标的信息查询实体类")
public class QueryProjectInformation extends BasePO {

    @NotNull(message = "标的号不能为空")
    @ApiModelProperty(required = true,value = "标的号",example = "123")
    private String projectNo;
}
