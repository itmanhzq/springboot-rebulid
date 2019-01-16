package com.fenlibao.pms.controller.system;


import com.fenlibao.base.dto.Response;
import com.fenlibao.pms.model.convert.RoleConvert;
import com.fenlibao.pms.model.po.idmt.OrganizationPO;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.JwtTokenProvider;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.service.system.OrganizationService;
import com.fenlibao.pms.service.system.RoleService;
import com.fenlibao.pms.service.system.UserRoleService;
import com.fenlibao.pms.service.system.UserService;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.dto.req.system.*;
import com.fenlibao.pms.exception.SystemException;
import com.fenlibao.pms.model.bo.idmt.RoleBO;
import com.fenlibao.pms.model.bo.idmt.UserRoleBO;
import com.fenlibao.pms.model.convert.UserRoleConvert;
import com.fenlibao.pms.model.po.idmt.UserPO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author chen
 * @date 2018/11/21
 */
@Slf4j
@RestController
@RequestMapping("/system/user")
@Api(tags = {"系统用户接口"})
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    /**
     * 查询用户(默认显示全部)
     *
     * @param request
     * @return
     */
    @ApiOperation("查询用户")
    @PostMapping("/searchUser")
    @ApiResponse(code = 200, message = "请求成功", response = PageInfo.class)
    @PreAuthorize("hasPermission('sysuser','view')")
    public Response<PageInfo<UserPO>> searchUser(@ApiIgnore @CurrentUser UserPrincipal currentUser, @RequestBody @Valid UserReq request) {
        List<OrganizationPO> organizationPOS = organizationService.getOrganizationIdsByuserName(currentUser.getUsername());
        String name = request.getName();
        PageInfo<UserPO> userPoList = userService.getSearchUser(request.getPageNum(), request.getPageSize(), organizationPOS, name);
        return Response.ok(userPoList);
    }

    @ApiOperation("删除用户")
    @PostMapping("/deleteUser")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PreAuthorize("hasPermission('sysuser','delete')")
    public Response<Boolean> deleteUser(@ApiIgnore @CurrentUser UserPrincipal currentUser, @RequestBody @Valid DeleteUserReq deleteUserReq) {
        int count = 0;
        try {
            count = userService.delUser(deleteUserReq.getUserId());
        } catch (Exception e) {
            return Response.error(ResponseStatus.COMMON_DELETE_ERROR);
        }

        if (count <= 0) {
            return Response.error(ResponseStatus.COMMON_DELETE_ERROR);
        } else {
            return Response.ok(true);
        }

    }

    @ApiOperation("新增或编辑用户")
    @PostMapping("/saveOrUpdate")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PreAuthorize("hasPermission('sysuser','update')")
    public Response<Boolean> saveOrUpdate(@ApiIgnore @CurrentUser UserPrincipal currentUser, @RequestBody @Valid SaveUserReq saveUserReq) {

        if (!StringUtils.isEmpty(saveUserReq.getUserId()) && saveUserReq.getUserId() > 0) {
            try {
                userService.updateUser(saveUserReq);
            } catch (Exception e) {
                return Response.error(ResponseStatus.COMMON_UPDATE_ERROR);
            }

        } else {
            try {
                userService.createUser(saveUserReq);
            } catch (SystemException ex) {
                log.error("新建用户失败", ex);
                return Response.error(ex);
            } catch (Exception e) {
                log.error("新建用户失败", e);
                return Response.error(ResponseStatus.COMMON_UPDATE_ERROR);
            }
        }
        return Response.ok(true);
    }

    @ApiOperation("获取用户的角色")
    @PostMapping("/getUserRole")
    @ApiResponse(code = 200, message = "请求成功", response = RoleBO.class)
    @PreAuthorize("hasPermission('sysuser', 'getUserRole')")
    public Response<RoleBO> getUserRole(@Valid @RequestBody UserRoleReq userRoleReq, @ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        try {
            // 获取目标用户的角色
            List<UserRoleBO> targetUserRolePOS = UserRoleConvert.poListConvertBOList(userRoleService.listUserRoleByUserId(userRoleReq.getTargetUserId()));
            // 获取当前登录的用户的角色
            List<UserRoleBO> currentUserRolePOS = UserRoleConvert.poListConvertBOList(userRoleService.listUserRoleByUserId(userPrincipal.getId()));
            RoleBO root = RoleBO.builder().build();
            List<Integer> roleIds = new ArrayList<>();
            if (Objects.nonNull(currentUserRolePOS) && !currentUserRolePOS.isEmpty()) {
                root = currentUserRolePOS.get(0).getRole();
                root.setRolePermission(null);
                if (Objects.nonNull(targetUserRolePOS) && !targetUserRolePOS.isEmpty()) {
                    targetUserRolePOS.forEach(userRolePO -> roleIds.add(userRolePO.getRoleId()));
                }
                // 获取所有角色
                List<RoleBO> roleBOS = RoleConvert.poListConvertBOList(roleService.listRoles());
                if (Objects.nonNull(roleBOS) && !roleBOS.isEmpty()) {
                    setRoleChecked(roleIds, roleBOS);
                }
                userRoleService.buildRoleAndChild(root, roleBOS);
            }
            return Response.ok(root.getChildren());
        } catch (Exception e) {
            log.error("获取用户角色异常：", e);
        }
        return Response.error(ResponseStatus.COMMON_GAIN_ERROR);
    }

    private void setRoleChecked(List<Integer> roleIds, List<RoleBO> roleBOS) {
        roleBOS.forEach(roleBO -> {
            roleBO.setRolePermission(null);
            boolean contains = roleIds.contains(roleBO.getId());
            roleBO.setChecked(false);
            if (contains) {
                roleBO.setChecked(true);
            }
        });
    }

    @ApiOperation("设置用户的角色")
    @PreAuthorize("hasPermission('sysuser', 'settingUserRole')")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PostMapping("/settingUserRole")
    public Response<Boolean> settingUserRole(@Valid @RequestBody UserRoleReq userRoleReq) {
        try {
            boolean result = userRoleService.updateUserRoleByUserId(userRoleReq);
            return Response.okOrError(ResponseStatus.COMMON_OPERATION_SUCCESS, ResponseStatus.COMMON_UPDATE_ERROR, result);
        } catch (Exception e) {
            log.error("设置用户角色异常：", e);
        }
        return Response.error(ResponseStatus.COMMON_UPDATE_ERROR.getMsg());
    }

    @ApiOperation("修改登录密码")
    @PostMapping("/updatePassword")
    @ApiResponse(code = 200, message = "请求成功")
    @PreAuthorize("hasPermission('sysuser','update')")
    public Response<String> updatePassword(@ApiIgnore @CurrentUser UserPrincipal currentUser, @RequestBody @Valid UpdatePwdReq req) {
        try {
            userService.updatePassword(currentUser.getId(), req.getOldPassword(), req.getNewPassword());
        } catch (SystemException ex) {
            return Response.error(ex);
        } catch (Exception e) {
            log.error("更新密码失败", e);
            return Response.error("系统错误");
        }
        return Response.ok();
    }
}
