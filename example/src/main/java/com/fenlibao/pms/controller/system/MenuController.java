package com.fenlibao.pms.controller.system;

import com.fenlibao.pms.dto.base.Response;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.dto.req.system.RolePermissionReq;
import com.fenlibao.pms.dto.resp.SigninRespBody;
import com.fenlibao.pms.model.bo.idmt.PermissionBO;
import com.fenlibao.pms.model.convert.PermissionConvert;
import com.fenlibao.pms.model.po.idmt.PermissionPO;
import com.fenlibao.pms.security.CurrentUser;
import com.fenlibao.pms.security.JwtTokenProvider;
import com.fenlibao.pms.security.UserPrincipal;
import com.fenlibao.pms.service.system.PermissionService;
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
import java.util.List;

/**
 * @author chen
 * @date 2018/11/21
 */
@Slf4j
@RestController
@RequestMapping("/system")
@Api(tags = {"系统菜单接口"})
public class MenuController {
    @Autowired
    PermissionService permissionService;

    @Autowired
    JwtTokenProvider tokenProvider;


    @ApiOperation("获取系统菜单组件接口")
    @ApiResponse(code = 200, message = "请求成功", response = PermissionBO.class)
    @PostMapping("/menu")
    @PreAuthorize("hasPermission('index','view')")
    public Response<PermissionBO> getSystemMenu(@ApiIgnore @CurrentUser UserPrincipal currentUser, @RequestBody @Valid RolePermissionReq rolePermissionReq) {
       try {
           List<PermissionPO> permissionPOList = permissionService.getMenuByType(currentUser.getId());
           return Response.ok(PermissionConvert.boConvertBOList(permissionPOList));
       }catch (Exception e){
           log.error("获取系统菜单组件失败:",e);
       }
        return  Response.error(ResponseStatus.COMMON_GAIN_ERROR);
    }

}
