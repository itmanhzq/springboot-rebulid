package com.fenlibao.pms.common.http;

import com.fenlibao.pms.config.Config;
import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

/**
 * @author chen
 * @date 2018/12/11
 */
@Slf4j
@Component
public class QiniuFileUpload {

    private static Config config;

    @Autowired
    public void setConfig(Config config) {
        QiniuFileUpload.config = config;
    }
    /**
     * 七牛文件上传
     *
     * @param file     base64字符串
     * @param fileName 文件名
     * @return
     */
    public static boolean putBaes64(String file, String fileName) {
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        //生成上传凭证，然后准备上传
        String accessKey = config.getQiniu().getQinniuAccessKey();
        String secretKey = config.getQiniu().getQinniuSecretKey();
        String bucket = config.getQiniu().getBucket();
        try {
            byte[] uploadBytes = Base64.decodeBase64(file);
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            Response response = uploadManager.put(byteInputStream, fileName, upToken, null, null);
            //解析上传成功的结果
            new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (Exception ex) {
            log.error("[QinniuFileUpload.putBaes64]", ex);
        }
        return true;
    }

}
