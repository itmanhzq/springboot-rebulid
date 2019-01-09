package com.fenlibao.pms.model.bo.idmt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author chen
 * @date 2018/11/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "权限实体")
public class PermissionBO implements Serializable {

    private static final long serialVersionUID = -9184955710620743114L;
    private Integer id;

    @ApiModelProperty(value = "父级Id")
    private Integer pid;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "排序", example = "1")
    private Integer sort;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "详细信息")
    private String description;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "是否是父级")
    private String isParent;

    @ApiModelProperty(value = "路径")
    private String path;

    /**
     * for front engineer
     */
    @ApiModelProperty(value = "索引")
    private String index;
    /**
     * for front engineer
     */
    @ApiModelProperty(value = "部门")
    private String component;
    /**
     * for front engineer
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "权限子集")
    private Collection<PermissionBO> children;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "是否登录")
    private Integer isLogin;

    @ApiModelProperty(value = "是否选中")
    private Boolean checked;
}
