package com.fenlibao.common.core;

import com.fenlibao.pms.common.http.QiniuFileUpload;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PmsUploadFileTests {


    @Autowired
    private QiniuFileUpload qinniuFileUpload;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testFileLoad() {
        String base64 ="fileName";
        //上传七牛服务器
        try {
            qinniuFileUpload.putBaes64("D:\\300x150\\66.png", "66.png");
        }catch (Exception e){

        }
    }
}
