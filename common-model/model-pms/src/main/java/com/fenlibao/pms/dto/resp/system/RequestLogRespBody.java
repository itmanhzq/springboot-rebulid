package com.fenlibao.pms.dto.resp.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangBoRan
 * @date 2018-12-14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestLogRespBody {

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "真实名称")
    private String realName;

    @ApiModelProperty(value = "访问ip")
    private String ip;

    @ApiModelProperty(value = "访问路径")
    private String url;

    @ApiModelProperty(value = "访问时长")
    private Long costTime;
}
