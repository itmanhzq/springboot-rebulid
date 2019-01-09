package com.fenlibao.xinwang.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @author Flynn
 * @date 2018/11/13
 */
@Data
@Builder
@AllArgsConstructor
public class Response<T> implements Serializable{

    private static final long serialVersionUID = -8857202760030626969L;
    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 各个接口返回的数据
     */
    private T body;

    /**
     * 默认返回成功的Response
     *
     * @param body
     * @return
     */
    public static Response ok(Object body) {
        return Response.builder()
                .code(HttpServletResponse.SC_OK)
                .msg(HttpStatus.OK.getReasonPhrase())
                .body(body)
                .build();
    }

    public static Response ok() {
        return Response.builder()
                .code(HttpServletResponse.SC_OK)
                .msg(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    public static Response error(String message) {
        return Response.builder()
                .code(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                .body(message)
                .build();
    }

    public static Response error(ResponseStatus responseStatus) {
        return Response.builder()
                .code(responseStatus.getCode())
                .body(responseStatus.getMsg())
                .build();
    }


}
