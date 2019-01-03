package com.fenlibao.pms.model.bo.idmt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author chen
 * @date 2018/11/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "组织信息")
public class OrganizationBO implements Serializable {

    private static final long serialVersionUID = 6894528768862282039L;
    private Integer id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 英文名
     */
    @ApiModelProperty(value = "英文名")
    private String englishName;


    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "排序ID")
    private String orderId;

    @ApiModelProperty(value = "父级ID")
    private Integer parentId;

    @ApiModelProperty(value = "多个父级ID")
    private String parentIds;

    @ApiModelProperty(value = "备注")
    private String marks;

    /**
     * 子组织集合
     */
    @ApiModelProperty(value = "子组织集合")
    private List<OrganizationBO> children;
}
