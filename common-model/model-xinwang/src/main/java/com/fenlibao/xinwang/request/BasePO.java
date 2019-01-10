package com.fenlibao.xinwang.request;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author hubert
 * @Date: 2018/12/12 9:40
 */
@Data
@Slf4j
@ApiModel(value = "基础数据类")
public class BasePO implements Serializable{

    @NotNull(message = "请求流水号不能为空")
    @ApiModelProperty(required = true,value = "请求流水号",example = "20181211145233eb3daafa-c")
    private String requestNo;

    @NotNull(message = "请求时间不能为空")
    @ApiModelProperty(required = true,value = "请求时间",example = "20181220093925")
    private String timestamp;

    @ApiModelProperty(value = "订单id")
    private Integer flbOrderId;

    @ApiModelProperty(value = "用户id")
    private Integer flbUserId;

    /**
     * 转为json串,过滤平台订单和平台用户id
     * @return
     */
    public String toJsonFilterFlb(){
        String json = null;
        try {
            json = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return "flbOrderId".equals(fieldAttributes.getName())
                        ||"flbUserId".equals(fieldAttributes.getName());
            }
            @Override
            public boolean shouldSkipClass(Class<?> arg0) {
                return false;
            }
        })
                    .create()
                    .toJson(this);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("转换json失败：{}",this);
        }
        return json;
    }

    /**
     * 转为json串
     * @return
     */
    public String toJson(){
        String json = null;
        try {
            json = new GsonBuilder()
                    .create()
                    .toJson(this);
        } catch (Exception e) {
            log.error("转换json失败：{}",this);
            log.error(e.getMessage());

        }
        return json;
    }



}
