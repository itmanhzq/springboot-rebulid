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
 * @date 2019/01/11
 */
@Getter
@Setter
@ApiModel(value = "RegisterReq[用户注册请求实体]")
public class RegisterReq  extends BaseReq implements Serializable {


    @ApiModelProperty(value = "注册手机号", required = true,example = "136********")
    @NotBlank
    private String phone;

    @ApiModelProperty(value = "登陆密码", required = true)
    @NotBlank
    private String password;

    @ApiModelProperty(value = "推荐人手机号", required = true)
    private String spreadPhoneNum;

    @ApiModelProperty(value = "渠道编码", required = true)
    private String channelCode;

    @ApiModelProperty(value = "分享渠道", required = true)
    private String channel;

    @ApiModelProperty(value = "设备类型", required = true)
    @NotBlank
    private String deviceType;

}
