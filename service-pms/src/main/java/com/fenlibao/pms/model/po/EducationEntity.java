package com.fenlibao.pms.model.po;

import lombok.Data;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Data
public class EducationEntity {

    private Integer id;
    /**
     * 高中学校名称
     */
    private String highSchoolName;
    /**
     * 中学名称
     */
    private String middleSchoolName;
    /**
     * 大学名称
     */
    private String universityName;
}