package com.fenlibao.pms.service;

import com.fenlibao.pms.model.bo.IdentifyImageBO;
import org.springframework.stereotype.Service;

/**
 * 滑动验证码图片
 *
 * @author chen
 * @date 2018/12/12
 */
@Service
public interface IdentifyImageService {

    /**
     * 获取滑动验证码图片
     *
     * @return IdentifyImageBO
     */
    IdentifyImageBO randomImg();


    /**
     * 校验验证码坐标
     *
     * @param uuId        唯一标识
     * @param coordinateX x坐标
     * @param coordinateY y坐标
     * @return String
     */
    String validateImg(String uuId, String coordinateX, String coordinateY);
}
