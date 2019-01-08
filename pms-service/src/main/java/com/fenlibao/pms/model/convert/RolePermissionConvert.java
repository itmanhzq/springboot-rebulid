package com.fenlibao.pms.model.convert;

import com.fenlibao.pms.model.bo.idmt.RolePermissionBO;
import com.fenlibao.pms.model.po.idmt.RolePermissionPO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * 角色权限转换类
 *
 * @author LeiXinXin
 * @date 2018/12/13
 */
public class RolePermissionConvert {
    private RolePermissionConvert() {
    }

    /**
     * 将角色权限PO类转为BO类
     *
     * @param rolePermissionPO 角色权限PO
     * @return RolePermissionBO
     */
    public static RolePermissionBO poConvertBO(RolePermissionPO rolePermissionPO) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        AbstractConverter<RolePermissionPO, RolePermissionBO> converter = new AbstractConverter<RolePermissionPO, RolePermissionBO>() {
            @Override
            protected RolePermissionBO convert(RolePermissionPO source) {
                RolePermissionBO rolePermissionBO = RolePermissionBO.builder().build();
                BeanUtils.copyProperties(source, rolePermissionBO);
                if (Objects.nonNull(source.getPermission())) {
                    rolePermissionBO.setPermission(PermissionConvert.poConvertBO(source.getPermission()));
                }
                return rolePermissionBO;
            }
        };
        return mapper.createTypeMap(RolePermissionPO.class, RolePermissionBO.class)
                .setConverter(converter)
                .map(rolePermissionPO);
    }

    /**
     * 将角色权限BO类转为PO类
     *
     * @param rolePermissionBO 角色权限BO
     * @return RolePermissionPO
     */
    public static RolePermissionPO boConvertPO(RolePermissionBO rolePermissionBO) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        AbstractConverter<RolePermissionBO, RolePermissionPO> converter = new AbstractConverter<RolePermissionBO, RolePermissionPO>() {
            @Override
            protected RolePermissionPO convert(RolePermissionBO source) {
                RolePermissionPO rolePermissionPO = RolePermissionPO.builder().build();
                BeanUtils.copyProperties(source, rolePermissionPO);
                rolePermissionPO.setPermission(PermissionConvert.boConvertPO(source.getPermission()));
                return rolePermissionPO;
            }
        };
        return mapper.createTypeMap(RolePermissionBO.class, RolePermissionPO.class)
                .setConverter(converter)
                .map(rolePermissionBO);
    }
}
