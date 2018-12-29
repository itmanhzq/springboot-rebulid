package com.fenlibao.pms.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    /**
     * 名字
     */
    private String name;
    private String adress;
    private String staus;
    private Date cTime;
    private Date uTime;
}