package com.fenlibao.pms.dto.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Data
@Builder
public class SigninRespBody {
    @ApiModelProperty(value = "登录token", required = true)
    private String accessToken;

    @ApiModelProperty(value = "token类别", required = true, example = "Bearer")
    private String tokenType;

    public static SigninRespBody get(String accessToken) {
        return SigninRespBody.builder()
                .accessToken(accessToken)
                .tokenType("Bearer")
                .build();
    }
}
