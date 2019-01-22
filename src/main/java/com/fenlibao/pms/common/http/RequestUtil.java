package com.fenlibao.pms.common.http;

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

    private static final Gson GSON = new GsonBuilder()
            .setDateFormat(DatePattern.NORM_DATETIME_PATTERN)
            .create();


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
        Response response = GSON.fromJson(responseText, Response.class);
        PageInfo<T> pageInfo;
        if (response.getCode().equals(ResponseStatus.COMMON_OPERATION_SUCCESS.getCode())) {
            String body = GSON.toJson(response.getBody());
            pageInfo = GSON.fromJson(body, PageInfo.class);
            String listStr = GSON.toJson(pageInfo.getList());
            List<T> list = toList(listStr, typeClass);
            pageInfo.setList(list);
        } else {
            throw new BizException(ResponseStatus.COMMON_GAIN_ERROR);
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

    public static <T> List<T> toList(String jsonString, Class typeClass) {
        Type type = new ParameterizedTypeImpl(typeClass);
        return GSON.fromJson(jsonString, type);
    }

    private static class ParameterizedTypeImpl implements ParameterizedType {
        Class clazz;

        public ParameterizedTypeImpl(Class clz) {
            clazz = clz;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{clazz};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }
}
