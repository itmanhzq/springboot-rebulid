package com.fenlibao.pms.common.http;

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

import java.io.ByteArrayInputStream;

/**
 * @author chen
 * @date 2018/12/11
 */
@Slf4j
@Component
public class QiniuFileUpload {

    private static String ACCESSKEY;
    private static String SECRETKEY;
    private static String BUCKET;
    private static String URL;

    @Autowired
    public void setConfig(Config config) {
        Config.Qiniu qiniu = config.getQiniu();
        ACCESSKEY = qiniu.getQinniuAccessKey();
        SECRETKEY = qiniu.getQinniuSecretKey();
        BUCKET = qiniu.getBucket();
        URL = qiniu.getUrl();
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
            Auth auth = Auth.create(ACCESSKEY, SECRETKEY);
            String upToken = auth.uploadToken(BUCKET);
            Response response = uploadManager.put(byteInputStream, fileName, upToken, null, null);
            //解析上传成功的结果
            new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (Exception e) {
            log.error("[QinniuFileUpload.putBaes64]文件上传失败", e);
        }
        return true;
    }

    public static boolean deleteImage(String fileName) {
        Auth auth = Auth.create(ACCESSKEY, SECRETKEY);
        Configuration config = new Configuration(Zone.autoZone());
        BucketManager bucketMgr = new BucketManager(auth, config);
        try {
            Response delete = bucketMgr.delete(fileName, BUCKET);
            delete.close();
        } catch (Exception e) {
            log.error("[QinniuFileUpload.deleteImage]文件上传成功", e);
        }
        return true;
    }

    public static String getUrl(String fileName) {
        return URL.concat(fileName);
    }

}
