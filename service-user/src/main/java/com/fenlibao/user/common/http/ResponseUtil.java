package com.fenlibao.user.common.http;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author chen
 * @date 2018/12/11
 */
@Component
@Slf4j
public class ResponseUtil {

    private ResponseUtil() {
    }

    private static final String RESPONSE_APPLICATION_JSON = "application/json; charset=utf-8";

    private static final String RESPONSE_TEXT_PLAIN = "text/plain; charset=utf-8";

    public static void response(Object data, HttpServletResponse response) {
        response.setContentType(RESPONSE_APPLICATION_JSON);
        try (PrintWriter writer = response.getWriter()) {
            writer.print(data);
        } catch (IOException e) {
            log.error("[ResponseUtil.response]",e);
        }
    }

    public static void responseText(Object data, HttpServletResponse response) {
        response.setContentType(RESPONSE_TEXT_PLAIN);
        try (PrintWriter writer = response.getWriter()) {
            writer.print(data);
        } catch (IOException e) {
            log.error("[ResponseUtil.responseText]",e);
        }
    }

}