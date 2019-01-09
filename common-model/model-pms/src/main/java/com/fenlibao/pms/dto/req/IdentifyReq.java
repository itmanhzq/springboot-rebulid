package com.fenlibao.pms.dto.req;

import com.fenlibao.base.dto.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author chen
 * @date 2018/12/14
 */
@Getter
@Setter
@ApiModel(value = "IdentifyReq[校验验证码请求实体]")
public class IdentifyReq extends BaseReq implements Serializable {


    private static final long serialVersionUID = 4603738167576551599L;

    @ApiModelProperty(value = "验证图x坐标", required = true,example = "1")
    @NotBlank
    private String coordinateX;

    @ApiModelProperty(value = "验证图y坐标", required = true,example = "1")
    @NotBlank
    private String coordinateY;

    @ApiModelProperty(value = "唯一标识", required = true)
    @NotBlank
    private String uuId;
}
