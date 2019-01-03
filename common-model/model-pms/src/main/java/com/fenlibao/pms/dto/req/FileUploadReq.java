package com.fenlibao.pms.dto.req;

import com.fenlibao.pms.dto.base.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author chen
 * @date 2018/11/7
 */
@Getter
@Setter
@ApiModel(value = "FileUploadReq[上传文件请求实体]")
public class FileUploadReq extends BaseReq implements Serializable {

    private static final long serialVersionUID = 8405835552578998882L;

    @ApiModelProperty(value = "base64位字符串", required = true)
    @NotBlank
    private String file;
}
