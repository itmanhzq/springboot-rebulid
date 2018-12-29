package com.fenlibao.pms.controller.system;

import cn.hutool.core.date.DateUtil;
import com.fenlibao.pms.dto.base.Response;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.dto.req.system.RoleMoveReq;
import com.fenlibao.pms.dto.req.system.RoleReq;
import com.fenlibao.pms.dto.req.system.RoleUpdateReq;
import com.fenlibao.pms.model.bo.idmt.RoleBO;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.model.convert.UserConvert;
import com.fenlibao.pms.model.po.idmt.RolePO;
import com.fenlibao.pms.model.po.idmt.RolePermissionPO;
import com.fenlibao.pms.model.po.idmt.UserPO;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.service.system.RoleService;
import com.fenlibao.pms.service.system.UserRoleService;
import com.fenlibao.pms.service.system.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.fenlibao.pms.dto.base.ResponseStatus.*;

/**
 * 系统角色接口
 *
 * @author LeiXinXin
 * @date 2018/12/22
 */
@Slf4j
@RestController
@RequestMapping("/system/role")
@Api(tags = {"系统角色接口"})
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;

    @ApiOperation("获取用户的角色信息")
    @PreAuthorize("hasPermission('systemRole', 'list')")
    @ApiResponse(code = 200, message = "请求成功", response = RoleBO.class)
    @PostMapping("/listRole")
    public Response<RoleBO> listRole(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        try {
            RoleBO root = userRoleService.findUserRoleInfo(userPrincipal.getId());
            root.setRolePermission(null);
            return Response.ok(root);
        } catch (Exception e) {
            log.error("获取角色列表异常：", e);
        }
        return Response.error(ResponseStatus.COMMON_GAIN_ERROR);
    }

    @ApiOperation("删除角色")
    @PreAuthorize("hasPermission('systemRole', 'delete')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PostMapping("/deleteRole")
    public Response<Boolean> deleteRole(@RequestBody @ApiParam(value = "角色信息，角色Id必传") RoleBO roleBO) {
        try {
            boolean result = roleService.removeRoleById(roleBO.getId());
            return Response.okOrError(COMMON_DELETE_ERROR, COMMON_OPERATION_SUCCESS, result);
        } catch (Exception e) {
            log.error("删除角色异常：", e);
        }
        return Response.error(ResponseStatus.COMMON_DELETE_ERROR);
    }

    @ApiOperation("保存角色信息")
    @PreAuthorize("hasPermission('systemRole', 'save')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PostMapping("/saveRole")
    public Response<Boolean> saveRole(@Valid @RequestBody @ApiParam(value = "角色信息，必须参数[parentId、name]") RoleBO roleBO) {
        try {
            RolePO rolePO = RolePO.builder().build();
            BeanUtils.copyProperties(roleBO, rolePO);
            boolean result = roleService.saveRole(rolePO);
            return Response.okOrError(COMMON_UPDATE_ERROR, COMMON_OPERATION_SUCCESS, result);
        } catch (Exception e) {
            log.error("保存角色信息异常：", e);
        }
        return Response.error(ResponseStatus.COMMON_UPDATE_ERROR);
    }

    @ApiOperation("更新角色信息")
    @PreAuthorize("hasPermission('systemRole', 'update')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PostMapping("/updateRole")
    public Response<Boolean> updateRole(@Valid @RequestBody @ApiParam(value = "角色信息，必须参数[id(roleId)、parentId、name、sort、permissionIds]") RoleUpdateReq roleUpdateReq) {
        try {
            List<RolePermissionPO> permissionPOS = new ArrayList<>();
            for (Integer permissionId : roleUpdateReq.getPermissionIds()) {
                permissionPOS.add(RolePermissionPO.builder().permissionId(permissionId).build());
            }

            RolePO rolePO = RolePO.builder()
                    .id(roleUpdateReq.getId())
                    .parentId(roleUpdateReq.getParentId())
                    .name(roleUpdateReq.getName())
                    .sort(roleUpdateReq.getSort())
                    .rolePermission(permissionPOS)
                    .build();

            boolean result = roleService.updateRoleAndPermission(rolePO);
            return Response.okOrError(COMMON_UPDATE_ERROR, COMMON_OPERATION_SUCCESS, result);
        } catch (Exception e) {
            log.error("更新角色信息异常：", e);
        }
        return Response.error(ResponseStatus.COMMON_UPDATE_ERROR);
    }

    @ApiOperation("获取成员")
    @PreAuthorize("hasPermission('systemRole', 'member')")
    @ApiResponse(code = 200, message = "请求成功", response = UserBO.class)
    @PostMapping("/memberView")
    public Response<PageInfo<UserBO>> memberView(@Valid @RequestBody @ApiParam(value = "获取成员，必须参数[roleId]") RoleReq roleReq) {
        try {
            List<UserPO> userPOS = userService.listUserByRoleId(roleReq.getPageNum(), roleReq.getPageSize(), roleReq.getRoleId());
            List<UserBO> userBOS = UserConvert.poListConvertBOList(userPOS);
            PageInfo<UserBO> pageInfo = new PageInfo<>(userBOS);
            return Response.ok(pageInfo);
        } catch (Exception e) {
            log.error("获取成员异常：", e);
        }
        return Response.error(ResponseStatus.COMMON_GAIN_ERROR);
    }

    @ApiOperation("移动角色")
    @PreAuthorize("hasPermission('systemRole', 'move')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PostMapping("/moveRole")
    public Response<Boolean> moveRole(@Valid @RequestBody RoleMoveReq moveReq) {
        try {
            boolean result = roleService.moveRoleByRoleId(moveReq);
            return Response.okOrError(COMMON_UPDATE_ERROR, COMMON_OPERATION_SUCCESS, result);
        } catch (Exception e) {
            log.error("角色移动异常：", e);
        }
        return Response.error(ResponseStatus.COMMON_UPDATE_ERROR);
    }
}
