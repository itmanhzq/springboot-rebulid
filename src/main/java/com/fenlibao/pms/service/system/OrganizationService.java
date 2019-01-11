package com.fenlibao.pms.service.system;

import com.fenlibao.pms.model.po.idmt.OrganizationPO;
import com.fenlibao.pms.model.bo.idmt.OrganizationBO;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 组织服务
 *
 * @author chen
 * @date 2018/11/22
 */
@Service
public interface OrganizationService {

    /**
     * 获取用户组织下的子组织
     *
     * @param userName
     * @return
     */
    List<OrganizationPO> getOrganizationIdsByuserName(String userName);

    /**
     * 获取用户账号下的组织
     *
     * @param userName
     * @return
     */
    OrganizationBO getOrganizationList(String userName);


    /**
     * 根据组织id获取成员列表
     *
     * @param pageNum
     * @param pageSize
     * @param organizationId
     * @param status
     * @return
     */
    PageInfo<UserBO> getLeaguerListByOrganizationId(int pageNum, int pageSize, Integer organizationId, Integer status);

    /**
     * 获取所有子组织列表
     *
     * @param pageNum
     * @param pageSize
     * @param organizationId
     * @return
     */
    PageInfo<OrganizationBO> childrenOrganizationList(int pageNum, int pageSize, Integer organizationId);

    /**
     * 删除组织
     *
     * @param organizationId
     */
    void delOrganization(Integer organizationId);


    /**
     * 添加组织
     *
     * @param parentId
     * @param name
     * @param orderId
     * @param marks
     * @param eName
     */
    void addOrganization(Integer parentId, String name, String orderId, String marks, String eName);


    /**
     * 修改组织
     * @param id
     * @param name
     * @param orderId
     * @param marks
     * @param eName
     */
    void updateOrganization(Integer id, String name, String orderId, String marks, String eName);
}
