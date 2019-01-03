package com.fenlibao.pms.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenlibao.base.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String MSG = "Sorry, You're not authorized to access this resource.";

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        log.error("path - {}, Responding with unauthorized error. Message - {}",httpServletRequest.getRequestURI(), e.getMessage());
        Response response = Response.builder()
                .code(String.valueOf(HttpServletResponse.SC_UNAUTHORIZED))
                .msg(MSG)
                .body(httpServletRequest.getRequestURI())
                .build();
        byte[] dataByteArr = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(response).getBytes(StandardCharsets.UTF_8.name());
        httpServletResponse.setHeader("content-type", "application/json;charset=UTF-8");
        httpServletResponse.getOutputStream().write(dataByteArr);
    }
}
