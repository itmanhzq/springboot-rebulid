package com.fenlibao.xinwang.service.impl;

import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fenlibao.base.dto.Response;
import com.fenlibao.xinwang.config.Config;
import com.fenlibao.xinwang.request.BasePO;
import com.fenlibao.xinwang.request.DownloadCheckFile;
import com.fenlibao.xinwang.request.XinwangInterfaceName;
import com.fenlibao.xinwang.service.XinwangService;
import com.fenlibao.xinwang.util.SignatureAlgorithm;
import com.fenlibao.xinwang.util.SignatureUtil;
import com.fenlibao.xinwang.util.XinwangDownloadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Flynn
 */
@Service
@Slf4j
@EnableRetry
public class XinwangServiceImpl implements XinwangService {

    @Autowired
    private Config config;

    private static final String GATEWAY = "/gateway";
    private static final String SERVICE = "/service";
    private static final String DOWNLOAD = "/download";

    private static final String PLATFORM_NO = "platformNo";
    private static final String KEY_SERIAL = "keySerial";
    private static final String SERVICE_NAME = "serviceName";
    private static final String REQ_DATA = "reqData";
    private static final String SIGN = "sign";

    private static final String KEY = "key";
    private static final String VALUE = "value";

    private static final String SUCCESS_CODE = "0";

    /**
     * 超时时间
     */
    private static final int OUT_TIMES = 12000;



    @Retryable(value = {HttpException.class}, maxAttempts = 3)
    @Override
    public Response serviceRequest(BasePO basePO) throws GeneralSecurityException, IOException {
        String url = config.getUrl() + SERVICE;
        String reqData = basePO.toJsonFilterFlb();
        HashMap<String, Object> map = new HashMap<>(5);
        map.put(PLATFORM_NO, config.getPlatformNo());
        map.put(KEY_SERIAL, config.getKeySerial());
        map.put(SERVICE_NAME, XinwangInterfaceName.getServiceName(basePO.getClass()));
        map.put(REQ_DATA, reqData);
        map.put(SIGN, sign(reqData));
        String result = HttpRequest.post(url)
                .form(map)
                .timeout(OUT_TIMES)
                .execute()
                .body();

        JSONObject obj;
        try {
            obj = JSONUtil.parseObj(result);
        } catch (JSONException e) {
            return Response.error(result);
        }
        return SUCCESS_CODE.equals(obj.get("code")) ? Response.ok(obj) : Response.error(result);
    }


    @Override
    public Response gatewayRequest(BasePO basePO) throws GeneralSecurityException, IOException {
        String url = config.getUrl() + GATEWAY;
        Map<String, Object> map = new HashMap<>();
        List<Map<String, String>> postParams = new ArrayList<>();

        Map<String, String> param1 = new HashMap<>(2);
        param1.put(KEY, PLATFORM_NO);
        param1.put(VALUE, config.getPlatformNo());

        Map<String, String> param2 = new HashMap<>(2);
        param2.put(KEY, KEY_SERIAL);
        param2.put(VALUE, config.getKeySerial());

        Map<String, String> param3 = new HashMap<>(2);
        param3.put(KEY, SERVICE_NAME);
        param3.put(VALUE, XinwangInterfaceName.getServiceName(basePO.getClass()));

        String reqData = basePO.toJsonFilterFlb();
        Map<String, String> param4 = new HashMap<>(2);
        param4.put(KEY, REQ_DATA);
        param4.put(VALUE, reqData);

        Map<String, String> param5 = new HashMap<>(2);
        param5.put(KEY, SIGN);
        param5.put(VALUE, this.sign(reqData));

        Map<String, String> param6 = new HashMap<>(2);
        param6.put(KEY, "userDevice");
        param6.put(VALUE, "");

        postParams.add(param1);
        postParams.add(param2);
        postParams.add(param3);
        postParams.add(param4);
        postParams.add(param5);
        postParams.add(param6);

        map.put("postParams", postParams);
        map.put("postUrl", url);

        return Response.ok(map);
    }


    @Override
    public Response download(DownloadCheckFile downloadCheckFile) throws GeneralSecurityException, IOException {
        String url = config.getUrl() + DOWNLOAD;
        String reqData = downloadCheckFile.toJsonFilterFlb();


        BasicNameValuePair bn1 = new BasicNameValuePair(SERVICE_NAME, XinwangInterfaceName.getServiceName(downloadCheckFile.getClass()));
        BasicNameValuePair bn2 = new BasicNameValuePair(PLATFORM_NO, config.getPlatformNo());
        BasicNameValuePair bn3 = new BasicNameValuePair(REQ_DATA, reqData);
        BasicNameValuePair bn4 = new BasicNameValuePair(KEY_SERIAL, config.getKeySerial());
        BasicNameValuePair bn5 = new BasicNameValuePair(SIGN, this.sign(reqData));

        List<BasicNameValuePair> form = new ArrayList<>();
        form.add(bn1);
        form.add(bn2);
        form.add(bn3);
        form.add(bn4);
        form.add(bn5);

        CloseableHttpResponse response = XinwangDownloadUtil.post(url, form);
        InputStream in = response.getEntity().getContent();
        return Response.ok(in);
    }

    /**
     * 签名
     *
     * @param reqData
     * @return
     * @throws GeneralSecurityException
     */
    private String sign(String reqData) throws GeneralSecurityException, IOException {
        PrivateKey privateKey = SignatureUtil.getRsaPkcs8PrivateKey(Base64.decodeBase64(config.getPrivateKey()));
        byte[] sign = SignatureUtil.sign(SignatureAlgorithm.SHA_1_WITH_RSA, privateKey, reqData);
        return Base64.encodeBase64String(sign);
    }

}
