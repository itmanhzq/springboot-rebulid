package com.fenlibao.pms.common.http;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.exception.BizException;
import com.fenlibao.pms.model.enums.JacksonMapperEnum;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author WangBoRan
 * @date 2018-12-11
 */
@Slf4j
public class RequestUtil {
    private static final String BEARER = "Bearer";
    private static final ObjectMapper MAPPER = JacksonMapperEnum.INSTANCE.getInstance();

    private RequestUtil() {
    }

    /**
     * 获取用户token
     * @param request
     * @return
     */
    public static String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER)) {
            int begin = 7;
            int end = bearerToken.length();
            return bearerToken.substring(begin, end);
        }
        return Strings.EMPTY;
    }


    public static <T> PageInfo<T> postReqPage(String url, String request, Class typeClass) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(PageInfo.class, typeClass);
        PageInfo<T> pageInfo;
        try {
            String responseText = HttpUtil.post(url, request);
            Response response = MAPPER.readValue(responseText, Response.class);
            if (response.getCode().equals(ResponseStatus.COMMON_OPERATION_SUCCESS.getCode())) {
                String body = MAPPER.writeValueAsString(response.getBody());
                pageInfo = MAPPER.readValue(body, javaType);
            } else {
                throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
        }
        return pageInfo;
    }

    public static <T> T postReqBody(String url, String request, Class typeClass) {
        Response<T> response;
        try {
            String responseText = HttpUtil.post(url, request);
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(Response.class, typeClass);
            response = MAPPER.readValue(responseText, javaType);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
        }
        T body;
        if (response.getCode().equals(ResponseStatus.COMMON_OPERATION_SUCCESS.getCode())) {
            body = response.getBody();
        } else {
            throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
        }
        return body;
    }


    public static String toJson(Object src) {
        try {
            return MAPPER.writeValueAsString(src);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
        }
    }
}
