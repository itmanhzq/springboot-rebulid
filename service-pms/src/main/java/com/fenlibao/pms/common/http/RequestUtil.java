package com.fenlibao.pms.common.http;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.exception.BizException;
import com.fenlibao.pms.model.enums.JacksonMapperEnum;
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

/**
 * @author WangBoRan
 * @date 2018-12-11
 */
@Slf4j
public class RequestUtil {
    private static final String BEARER = "Bearer";

    private static final Gson GSON = new GsonBuilder()
            .create();
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
        int startIndex = 7;
        int endIndex = bearerToken.length();
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER)) {
            return bearerToken.substring(startIndex, endIndex);
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
        }
        return pageInfo;
    }

    public static <T> T postReqBody(String url, String request) {
        String responseText = HttpUtil.post(url, request);
        Response<T> response = GSON.fromJson(responseText, Response.class);
        T body;
        if (response.getCode().equals(ResponseStatus.COMMON_OPERATION_SUCCESS.getCode())) {
            body = response.getBody();
        } else {
            throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
        }
        return body;
    }


    public static String toJson(Object src) {
        return GSON.toJson(src);
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
