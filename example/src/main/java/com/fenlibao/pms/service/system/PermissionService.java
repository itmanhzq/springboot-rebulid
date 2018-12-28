package com.fenlibao.pms.service.system;
import com.fenlibao.pms.dto.req.system.AddPermissionReq;
import com.fenlibao.pms.model.bo.idmt.PermissionBO;
import com.fenlibao.pms.model.bo.idmt.UserRoleBO;
import com.fenlibao.pms.model.po.idmt.PermissionPO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @date 2018/11/22
 */
@Service
public interface PermissionService {

    /**
     * 获取系统权限菜单
     * @param userId
     * @return
     */
    List<PermissionPO> getMenuByType(Integer userId);

    /**
     * 获取用户角色权限树
     * @return
     */
    PermissionBO getPermissionList();

    /**
     * 获取用户角色权限树
     *
     * @param userRoleBO 用户角色信息
     * @return PermissionBO
     */
    PermissionBO getPermissionListByRoleId(UserRoleBO userRoleBO);


    /**
     * 新增或修改权限
     * @param req
     */
    void addOrUpdatePermission(AddPermissionReq req);

    /**
     * 删除权限
     * @param id
     */
    void deletePermission(Integer id);
}
