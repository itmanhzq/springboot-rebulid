package com.fenlibao.pms.dto.resp.system;/**
 * @author chen
 * @date 2018/11/20
 */

import com.fenlibao.pms.model.bo.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author chen
 * @date 2018-11-26
 */
@Data
@Builder
public class SystemUserRespBody {
    private List<User> users;
    public static SystemUserRespBody get(List<User> users) {
        return SystemUserRespBody.builder()
                .users(users)
                .build();
    }
}
