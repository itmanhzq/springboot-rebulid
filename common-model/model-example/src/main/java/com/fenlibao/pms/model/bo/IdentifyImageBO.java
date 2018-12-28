package com.fenlibao.pms.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chen
 * @date 2018/12/13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdentifyImageBO {

    private Integer id;

    @ApiModelProperty(value = "图片地址", required = true, example = "http://testoss.fenlibao.com/11.png")
    private String imgUrl;

    @ApiModelProperty(value = "1-1.99随机X坐标", required = true, example = "2")
    private Integer  randomX;

    @ApiModelProperty(value = "1-1.99随机Y坐标", required = true, example = "1")
    private Integer  randomY;

    @ApiModelProperty(value = "唯一标识", required = true, example = "11232144")
    private String uuId;
}
