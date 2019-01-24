package com.fenlibao.bid.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 区域位置信息
 *
 * @author LeiXinXin
 * @date 2019/1/23
 */
@Data
@Builder
@ApiModel("RegionalLocationRespBody[区域位置信息]")
public class RegionalLocationRespBody {
    @ApiModelProperty(value = "区域位置ID")
    private Integer id;
    @ApiModelProperty(value = "省级ID")
    private Integer provinceId;
    @ApiModelProperty(value = "市级ID")
    private Integer cityId;
    @ApiModelProperty(value = "县级ID")
    private Integer countyId;
    @ApiModelProperty(value = "名称")
    private String nickName;
    @ApiModelProperty(value = "省级名称")
    private String provinceName;
    @ApiModelProperty(value = "市级名称")
    private String cityName;
    @ApiModelProperty(value = "县级名称")
    private String countyName;
    @ApiModelProperty(value = "级别,SHENG:省级;SHI:市级;XIAN:县级")
    private String level;
    @ApiModelProperty(value = "简拼")
    private String janeSpell;
    @ApiModelProperty(value = "启用状态,QY:启用;TY:停用")
    private String status;
}
