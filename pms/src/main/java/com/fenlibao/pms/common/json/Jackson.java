package com.fenlibao.pms.common.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenlibao.pms.model.enums.JacksonMapperEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.StringWriter;
import java.util.Optional;

/**
 * @author chen
 * @date 2018/12/11
 */
@Slf4j
public class Jackson {
    private Jackson() {
    }

    public static String getBaseJsonData(Object obj) {
        StringWriter writer = new StringWriter();
        Optional<Object> optional = Optional.ofNullable(obj);
        if (optional.isPresent()) {
            ObjectMapper mapper = JacksonMapperEnum.INSTANCE.getInstance();
            try {
                mapper.writeValue(writer, obj);
            } catch (Exception e) {
                log.error("[Jackson.getBaseJsonData]", e);
            }
        }
        return writer.toString();
    }

}
