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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cn.hutool.core.date.DatePattern;
import cn.hutool.http.HttpUtil;
import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.exception.BizException;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author WangBoRan
 * @date 2018-12-11
 */
@Slf4j
public class RequestUtil {
    private static final String BEARER = "Bearer";
    private static final ObjectMapper mapper = JacksonMapperEnum.INSTANCE.getInstance();

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
        String responseText = HttpUtil.post(url, request);
        JavaType javaType = mapper.getTypeFactory().constructParametricType(PageInfo.class, typeClass);
        PageInfo<T> pageInfo = new PageInfo<>();
        try {
            Response response = mapper.readValue(responseText, Response.class);
            if (response.getCode().equals(ResponseStatus.COMMON_OPERATION_SUCCESS.getCode())) {
                String body = mapper.writeValueAsString(response.getBody());
                pageInfo = mapper.readValue(body, javaType);
            } else {
                throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
        }
        return pageInfo;
    }

    public static <T> T postReqBody(String url, String request) {
        String responseText = HttpUtil.post(url, request);
        Response<T> response = null;
        try {
            response = mapper.readValue(responseText, Response.class);
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
            return mapper.writeValueAsString(src);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
        }
    }

    public static class ParameterizedTypeImpl implements ParameterizedType {
        private final Class raw;
        private final Class args;

        public ParameterizedTypeImpl(Class raw, Class args) {
            this.raw = raw;
            this.args = args;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{args};
        }

        @Override
        public Type getRawType() {
            return raw;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }
}
