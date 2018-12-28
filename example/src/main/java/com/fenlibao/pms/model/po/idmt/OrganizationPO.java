package com.fenlibao.pms.model.po.idmt;

import com.fenlibao.pms.model.po.BasePO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author chen
 * @date 2018/11/22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "idmt_organization")
public class OrganizationPO extends BasePO {

    /**
     * 组记录id
     */
    @Id
    private Integer id;

    /**
     * 组名称
     */
    private String name;

    /**
     * 英文名称
     */
    @Column(name = "english_name")
    private String englishName;

    /**
     * 组类别
     */
    private String grouptype;

    /**
     * 状态 0:停用; 1:启用
     */
    @Column(name = "STATUS")
    private Boolean status;

    /**
     * 排序
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 父级
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 所有父级
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 子组织集合
     */
    private List<OrganizationPO> children;
}
