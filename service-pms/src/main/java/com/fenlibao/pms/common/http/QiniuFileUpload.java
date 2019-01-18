package com.fenlibao.pms.common.http;

import cn.hutool.core.util.ImageUtil;
import com.fenlibao.pms.config.Config;
import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

/**
 * @author chen
 * @date 2018/12/11
 */
@Slf4j
@Component
public class QiniuFileUpload {

    /**
     * 访问密钥
     */
    private static String ACCESS_KEY;
    /**
     * 密钥
     */
    private static String SECRET_KEY;
    /**
     * 文件空间
     */
    private static String BUCKET;

    @Autowired
    public void setDocImageFileDao(Config config) {
        ACCESS_KEY = config.getQiniu().getQinniuAccessKey();
        SECRET_KEY = config.getQiniu().getQinniuSecretKey();
        BUCKET = config.getQiniu().getBucket();
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
        try {
            byte[] uploadBytes = Base64.decodeBase64(file);
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(BUCKET);
            Response response = uploadManager.put(byteInputStream, fileName, upToken, null, null);
            //解析上传成功的结果
            new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (Exception ex) {
            log.error("[QinniuFileUpload.putBaes64]", ex);
        }
        return true;
    }

}
