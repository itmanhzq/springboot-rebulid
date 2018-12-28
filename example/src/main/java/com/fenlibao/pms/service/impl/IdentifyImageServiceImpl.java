package com.fenlibao.pms.service.impl;

import com.fenlibao.pms.common.redies.RedisPrefix;
import com.fenlibao.pms.mapper.IdentifyImageDao;
import com.fenlibao.pms.model.bo.IdentifyImageBO;
import com.fenlibao.pms.model.po.IdentifyImagePO;
import com.fenlibao.pms.service.IdentifyImageService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 验证码服务调用
 *
 * @author:chen
 * @Date 2018-12-10
 */
@Service("IdentifyImageService")
public class IdentifyImageServiceImpl implements IdentifyImageService {

    private static final int RANDOMNUM = 8;

    @Autowired
    IdentifyImageDao identifyImageDao;
    private Random random = new Random();
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public IdentifyImageBO randomImg() {
        List<IdentifyImagePO> identifyImagePOs = identifyImageDao.selectAll();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String reidsKey = RedisPrefix.IDENTIFY_UUID.getPrefix().concat(uuid);
        IdentifyImagePO identifyImagePO = identifyImagePOs.get(random.nextInt(identifyImagePOs.size() - 1));
        IdentifyImageBO identifyImageBO = new IdentifyImageBO();
        BeanUtils.copyProperties(identifyImagePO, identifyImageBO);
        int randomX = random.nextInt(RANDOMNUM) + 1;
        int randomY = random.nextInt(RANDOMNUM) + 1;
        identifyImageBO.setRandomX(randomX);
        identifyImageBO.setRandomY(randomY);
        identifyImageBO.setUuId(uuid);
        String indentifyCount = String.valueOf(coordinateCount(randomX, randomY));
        redisTemplate.opsForValue().set(reidsKey, indentifyCount, 2, TimeUnit.MINUTES);
        return identifyImageBO;
    }


    @Override
    public String validateImg(String uuId, String coordinateX, String coordinateY) {
        String reidsKey = RedisPrefix.IDENTIFY_UUID.getPrefix().concat(uuId);
        String identifyCount = String.valueOf(redisTemplate.boundValueOps(reidsKey).get());
        //验证码过期
        if (StringUtil.isEmpty(identifyCount)) {
            return null;
        }
        int coordinateCount = Integer.valueOf(coordinateX) + Integer.valueOf(coordinateY);
        if (coordinateCount == Integer.valueOf(identifyCount)) {
            uuId = UUID.randomUUID().toString().replaceAll("-", "");
            reidsKey = RedisPrefix.IDENTIFY_UUID.getPrefix().concat(uuId);
            //校验成功，生成新的uuid，登录时候校验用到
            redisTemplate.opsForValue().set(reidsKey, uuId, 5, TimeUnit.MINUTES);
            return uuId;
        }
        return null;
    }

    /**
     * 生成与统一统一算法的随机数之和
     *
     * @param randomX 随机的x坐标
     * @param randomY 随机的y坐标
     * @return
     */
    private int coordinateCount(int randomX, int randomY) {
        double coordinateX = (double) randomX * 150 / 15 + 150 * 0.1;
        double coordinateY = (double) randomY * 300 / 15 + 300 * 0.1;
        return (int) coordinateX + (int) coordinateY;
    }

}
