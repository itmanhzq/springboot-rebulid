package com.fenlibao.pms.model.po.idmt;

import com.fenlibao.pms.model.po.BasePO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;


/**
 * @author chen
 * @date 2018/12/06
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "idmt_user_organization")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class IdmtUserOrganizationPO  extends BasePO {
    /**
     * 记录Id
     */
    private Integer id;
    /**
     * 用户id 关联idmt_user.id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 组id 关联idmt_organization.id
     */
    @Column(name = "organization_id")
    private Integer organizationId;
}