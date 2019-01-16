package com.fenlibao.common.core.service.impl;
import cn.hutool.json.JSONObject;
import com.fenlibao.user.UserApplication;
import com.fenlibao.user.common.json.ExtDataJson;
import com.fenlibao.user.model.po.ExtInfoPO;
import com.google.gson.JsonArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chen
 * @date 2018/11/28
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class UserServiceImplTest {

    /**
     *测试扩展字段解析方法
     */
    @Test
    public void testUpdateRoleAndPermission() {
        List<ExtInfoPO> extInfoPOList = new ArrayList<>();
        ExtInfoPO extInfoPO = new ExtInfoPO();
        extInfoPO.setExtName("姓名");
        extInfoPO.setExtCode("name");
        extInfoPO.setSort(1);
        extInfoPO.setDataType("String");
        extInfoPO.setDisplay(1);
        ExtInfoPO extInfoPO2 = new ExtInfoPO();
        extInfoPO2.setExtName("性别");
        extInfoPO2.setExtCode("sex");
        extInfoPO2.setSort(2);
        extInfoPO2.setDataType("String");
        extInfoPO2.setDisplay(1);
        extInfoPOList.add(extInfoPO);
        extInfoPOList.add(extInfoPO2);
        String json = listToString(extInfoPOList);
        List<ExtInfoPO> list = ExtDataJson.getBaseJsonData(json);
        log.info(">>测试数据解析通过");
    }

    public static String listToString(List<ExtInfoPO> mList) {
        String convertedListStr = "";
        if (null != mList && mList.size() > 0) {
            ExtInfoPO[] mListArray = mList.toArray(new ExtInfoPO[mList.size()]);
            for (int i = 0; i < mListArray.length; i++) {
                JSONObject jsonObject = new JSONObject(mListArray[i]);
                if (i < mListArray.length - 1) {
                    convertedListStr += jsonObject + ";";
                } else {
                    convertedListStr += jsonObject;
                }
            }
            return convertedListStr;
        }
        return null;
    }

}