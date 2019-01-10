package com.fenlibao.xinwang.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.List;

/**
 *
 */
@Slf4j
public class XinwangDownloadUtil {
    private XinwangDownloadUtil() {
    }

    /**
     * 建议尽量用hutool的http工具，此方法仅限于新网下载对账文件接口，hutool貌似传输文件流有问题
     */
    public static CloseableHttpResponse post(String url, List<BasicNameValuePair> params) throws IOException {
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig
                    .custom()
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .setSocketTimeout(120000).build();
            httppost.setConfig(requestConfig);
            if (null != params) {
                UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params, "UTF-8");
                httppost.setEntity(uefEntity);
            }
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            log.error(e.getMessage());
            log.error(e.toString());
        } finally {
            httpclient.close();
        }

        return response;
    }


}
