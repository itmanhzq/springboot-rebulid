package com.fenlibao.pms.dto.req.system;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * UserRoleReq
 *
 * @author LeiXinXin
 * @date 2018/12/14
 */
@Data
@ApiModel(value = "UserRoleReq[用户角色请求实体]")
public class UserRoleReq implements Serializable {
    private static final long serialVersionUID = -4418778257086525696L;
    @NotNull(message = "用户Id不能为空")
    private Integer targetUserId;

    @NotNull(message = "角色Id集合不能为NULL")
    private List<Integer> roleIds;
}
