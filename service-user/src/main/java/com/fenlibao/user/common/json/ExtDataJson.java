package com.fenlibao.user.common.json;

import cn.hutool.json.JSONObject;
import com.fenlibao.user.model.po.ExtInfoPO;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 属性字段解析
 * @author chen
 * @date 2019/01/11
 */
@Slf4j
public class ExtDataJson {

    public static List<ExtInfoPO> getBaseJsonData(String obj) {
        //将list<json>数据解析到实体类配合ext_data, ext_info
        Optional<Object> optional = Optional.ofNullable(obj);
        List<ExtInfoPO> extInfoPOS = new ArrayList<>();
        if (optional.isPresent()) {
            List<String> lis = Arrays.asList(obj.split(";"));
            lis.forEach(
                    json -> {
                        JSONObject jsonObject = new JSONObject(json);
                        ExtInfoPO extInfoPO = new ExtInfoPO();
                        extInfoPO.setDataType((String) jsonObject.get("DataType"));
                        extInfoPO.setDisplay((int) jsonObject.get("display"));
                        extInfoPO.setExtCode((String) jsonObject.get("extCode"));
                        extInfoPO.setSort((int) jsonObject.get("sort"));
                        extInfoPO.setExtName((String) jsonObject.get("extName"));
                        extInfoPOS.add(extInfoPO);
                    }
            );
        }

       return extInfoPOS;
    }
}
