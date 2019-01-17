package com.fenlibao.pms.common.http;

import cn.hutool.http.HttpUtil;
import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.dto.resp.marketing.publicize.ArticleListRespBody;
import com.fenlibao.pms.exception.BizException;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WangBoRan
 * @date 2018-12-11
 */
@Slf4j
public class RequestUtil {
    private static final String BEARER = "Bearer";

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


    public static <T> PageInfo<T> postReqPage(String url, String request) {
        Gson gson = new Gson();
        String responseText = HttpUtil.post(url, request);
        Response response = gson.fromJson(responseText, Response.class);
        PageInfo<T> pageInfo;
        if (response.getCode().equals(ResponseStatus.COMMON_OPERATION_SUCCESS.getCode())) {
            String body = gson.toJson(response.getBody());
            pageInfo = gson.fromJson(body, PageInfo.class);
        } else {
            throw new BizException(ResponseStatus.COMMON_DELETE_ERROR);
        }
        return pageInfo;
    }
}
