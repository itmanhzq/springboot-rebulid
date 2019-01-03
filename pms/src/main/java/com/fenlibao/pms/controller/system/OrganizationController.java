package com.fenlibao.pms.controller.system;

import com.fenlibao.pms.dto.base.Response;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.service.system.OrganizationService;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.dto.req.system.AddOrganizationReq;
import com.fenlibao.pms.model.bo.idmt.OrganizationBO;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.dto.req.system.OrganizationReq;
import com.fenlibao.pms.dto.req.system.UpdateOrganizationReq;
import com.github.pagehelper.PageInfo;
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

/**
 * @author chen
 * @date 2018/12/05
 */
@Slf4j
@RestController
@RequestMapping("/system/organization")
@Api(tags = {"系统组织接口"})
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    /**
     * 组织列表
     *
     * @return
     */
    @ApiOperation("组织列表")
    @PostMapping("/list")
    @ApiResponse(code = 200, message = "请求成功", response = OrganizationBO.class)
    @PreAuthorize("hasPermission('organization','view')")
    public Response<OrganizationBO> organizationList(@ApiIgnore @CurrentUser UserPrincipal currentUser) {
        OrganizationBO organization = organizationService.getOrganizationList(currentUser.getUsername());
        return Response.ok(organization);
    }

    /**
     * 获取所有子组织列表
     *
     * @return
     */
    @ApiOperation("获取所有子组织列表")
    @PostMapping("/clirentOrganizationList")
    @ApiResponse(code = 200, message = "请求成功", response = OrganizationBO.class)
    @PreAuthorize("hasPermission('organization','view')")
    public Response<OrganizationBO> childrenOrganizationList(@RequestBody @Valid OrganizationReq req) {
        Integer id = req.getOrganizationId();
        PageInfo<OrganizationBO> userPoList = organizationService.childrenOrganizationList(req.getPageNum(), req.getPageSize(), id);
        return Response.ok(userPoList);
    }

    /**
     * 组织成员查询
     *
     * @return
     */
    @ApiOperation("组织成员查询")
    @PostMapping("/searchLeaguer")
    @ApiResponse(code = 200, message = "请求成功", response = UserBO.class)
    @PreAuthorize("hasPermission('organization','view')")
    public Response<UserBO> searchLeaguer(@RequestBody @Valid OrganizationReq req) {
        Integer id = req.getOrganizationId();
        Integer status = Integer.valueOf(req.getStatus());
        PageInfo<UserBO> userPoList = organizationService.getLeaguerListByOrganizationId(req.getPageNum(), req.getPageSize(), id, status);
        return Response.ok(userPoList);
    }

    /**
     * 删除组织
     *
     * @param deleteUserReq
     * @return
     */
    @ApiOperation("删除组织")
    @PostMapping("/deleteOrganization")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PreAuthorize("hasPermission('organization','delete')")
    public Response<Boolean> deleteOrganization(@RequestBody @Valid OrganizationReq deleteUserReq) {
        try {
            organizationService.delOrganization(deleteUserReq.getOrganizationId());
        } catch (Exception e) {
            log.error("操作失败", e);
            return Response.error(ResponseStatus.COMMON_DELETE_ERROR);
        }
        return Response.ok(true);
    }

    @ApiOperation("添加组织")
    @PostMapping("/addOrganization")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PreAuthorize("hasPermission('organization','update')")
    public Response<Boolean> addOrganization(@RequestBody @Valid AddOrganizationReq req) {
        Integer parentId = Integer.valueOf(req.getParentId());
        String name = req.getName();
        String orderId = req.getOrderId();
        try {
            organizationService.addOrganization(parentId, name, orderId, req.getMarks(), req.getEName());
        } catch (Exception e) {
            log.error("添加组织失败", e);
            return Response.error(ResponseStatus.COMMON_UPDATE_ERROR);
        }
        return Response.ok(true);
    }

    @ApiOperation("修改组织")
    @PostMapping("/updateOrganization")
    @ApiResponse(code = 200, message = "请求成功", response = Boolean.class)
    @PreAuthorize("hasPermission('organization','update')")
    public Response<Boolean> updateOrganization(@RequestBody @Valid UpdateOrganizationReq req) {
        String name = req.getName();
        String orderId = req.getOrderId();
        try {
            organizationService.updateOrganization(req.getId(), name, orderId, req.getMarks(), req.getEName());
        } catch (Exception e) {
            log.error("更新组织失败", e);
            return Response.error(ResponseStatus.COMMON_UPDATE_ERROR);
        }
        return Response.ok(true);
    }
}
