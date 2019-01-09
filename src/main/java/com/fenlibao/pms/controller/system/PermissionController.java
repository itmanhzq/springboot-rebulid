package com.fenlibao.pms.controller.system;

import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.service.system.PermissionService;
import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.dto.req.system.AddPermissionReq;
import com.fenlibao.pms.model.bo.idmt.PermissionBO;
import com.fenlibao.pms.model.bo.idmt.UserRoleBO;
import com.fenlibao.pms.dto.req.system.DeletePermissionReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author chen
 * @date 2018/12/05
 */
@Slf4j
@RestController
@RequestMapping("/system/permission")
@Api(tags = {"系统权限接口"})
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    /**
     * 默认权限列表
     *
     * @return
     */
    @ApiOperation("默认权限列表")
    @PostMapping("/list")
    @ApiResponse(code = 200, message = "请求成功", response = PermissionBO.class)
    @PreAuthorize("hasPermission('permission','view')")
    public Response<PermissionBO> permissionTree() {
        PermissionBO permissionBO = permissionService.getPermissionList();
        return Response.ok(permissionBO);
    }

    /**
     * 权限树
     *
     * @param userRoleBO 角色信息
     * @return Response
     */
    @ApiOperation("权限树")
    @PostMapping("/permissionTree")
    @ApiResponse(code = 200, message = "请求成功", response = PermissionBO.class)
    @PreAuthorize("hasPermission('permission','view')")
    public Response<PermissionBO> permissionTree(@RequestBody UserRoleBO userRoleBO, @ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        try {
            if (Objects.isNull(userRoleBO.getUserId())) {
                userRoleBO.setUserId(userPrincipal.getId());
            }
            PermissionBO permissionBO = permissionService.getPermissionListByRoleId(userRoleBO);
            return Response.ok(permissionBO);
        } catch (Exception e) {
            log.error("获取权限树异常：", e);
        }
        return Response.error(ResponseStatus.COMMON_GAIN_ERROR);
    }

    /**
     * 新增或修改权限
     *
     * @param req
     * @return
     */
    @ApiOperation("新增或修改权限")
    @PostMapping("/addOrUpdatePermit")
    @ApiResponse(code = 200, message = "请求成功", response = String.class)
    @PreAuthorize("hasPermission('permission','update')")
    public Response<String> addOrUpdatePermission(@RequestBody @Valid AddPermissionReq req) {
        try {
            permissionService.addOrUpdatePermission(req);
        } catch (Exception e) {
            log.error("编辑权限树失败", e);
            return Response.error("编辑权限树失败");
        }
        return Response.ok();
    }


    /**
     * 删除权限
     *
     * @param req
     * @return
     */
    @ApiOperation("删除权限")
    @PostMapping("/deletePermit")
    @ApiResponse(code = 200, message = "请求成功", response = String.class)
    @PreAuthorize("hasPermission('permission','delete')")
    public Response<String> deletePermission(@RequestBody @Valid DeletePermissionReq req) {
        try {
            permissionService.deletePermission(Integer.valueOf(req.getId()));
        } catch (Exception e) {
            log.error("删除权限失败", e);
            return Response.error("删除权限失败");
        }
        return Response.ok();
    }
}
