package com.fenlibao.common.core.service.system.impl;

import cn.hutool.core.lang.Assert;
import com.fenlibao.pms.PmsApplication;
import com.fenlibao.pms.model.po.idmt.RolePO;
import com.fenlibao.pms.model.po.idmt.RolePermissionPO;
import com.fenlibao.pms.service.system.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * 角色测试
 *
 * @author LeiXinXin
 * @date 2018/11/28
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PmsApplication.class)
public class RoleServiceImplTest {
    @Autowired
    private RoleService roleService;

    /**
     * 更新角色以及角色权限测试
     */
    @Test
    public void testUpdateRoleAndPermission() {
        RolePO rolePO = RolePO.builder()
                .id(2)
                .parentId(1)
                .name("开发人员")
                .rolePermission(Arrays.asList(
                        RolePermissionPO.builder().roleId(2).permissionId(1).build(),
                        RolePermissionPO.builder().roleId(2).permissionId(2).build()
                ))
                .build();

        boolean result = roleService.updateRoleAndPermission(rolePO);
        Assert.isTrue(result);
        log.info(">>更新角色信息以及角色权限测试通过");
    }

    @Test
    public void saveRole() {
        RolePO rolePO = RolePO.builder()
                .name("测试角色11")
                .parentId(1)
                .sort(5)
                .rolePermission(
                        Arrays.asList(
                                RolePermissionPO.builder().roleId(5).permissionId(9).build(),
                                RolePermissionPO.builder().roleId(5).permissionId(13).build()
                        )
                )
                .build();

        boolean result = roleService.saveRole(rolePO);
        Assert.isTrue(result);
        log.info("保存角色信息成功");
    }
}