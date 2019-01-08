package com.fenlibao.pms.model.convert;

import com.fenlibao.pms.model.bo.idmt.RoleBO;
import com.fenlibao.pms.model.bo.idmt.RolePermissionBO;
import com.fenlibao.pms.model.po.idmt.RolePO;
import com.fenlibao.pms.model.po.idmt.RolePermissionPO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 角色转换类
 *
 * @author LeiXinXin
 * @date 2018/12/12
 */
public class RoleConvert {
    private RoleConvert() {
    }

    /**
     * 将角色PO转为BO
     *
     * @param rolePO 角色PO
     * @return RoleBO
     */
    public static RoleBO poConvertBO(RolePO rolePO) {
        ModelMapper mapper = new ModelMapper();
        AbstractConverter<RolePO, RoleBO> converter = new AbstractConverter<RolePO, RoleBO>() {
            @Override
            protected RoleBO convert(RolePO source) {
                RoleBO target = RoleBO.builder().build();
                BeanUtils.copyProperties(source, target);

                List<RolePermissionPO> rolePermissionPOS = source.getRolePermission();
                List<RolePermissionBO> rolePermissionBOS = new ArrayList<>();
                rolePermissionPOS.forEach(rolePermissionPO -> {
                    if (Objects.nonNull(rolePermissionPO)) {
                        rolePermissionBOS.add(RolePermissionConvert.poConvertBO(rolePermissionPO));
                    }
                });
                target.setRolePermission(rolePermissionBOS);
                return target;
            }
        };
        return mapper.createTypeMap(RolePO.class, RoleBO.class)
                .setConverter(converter)
                .map(rolePO);
    }

    /**
     * 将角色PO集合转为BO集合
     *
     * @param rolePOS 角色PO
     * @return List
     */
    public static List<RoleBO> poListConvertBOList(List<RolePO> rolePOS) {
        List<RoleBO> roleBOList = new ArrayList<>();
        rolePOS.forEach(rolePO -> roleBOList.add(poConvertBO(rolePO)));
        return roleBOList;
    }


    /**
     * 将角色BO转为PO
     *
     * @param roleBO 角色BO
     * @return RolePO
     */
    public static RolePO boConvertBO(RoleBO roleBO) {
        ModelMapper mapper = new ModelMapper();
        AbstractConverter<RoleBO, RolePO> converter = new AbstractConverter<RoleBO, RolePO>() {
            @Override
            protected RolePO convert(RoleBO source) {
                RolePO target = RolePO.builder().build();
                BeanUtils.copyProperties(source, target);

                List<RolePermissionBO> rolePermissionBOS = source.getRolePermission();
                List<RolePermissionPO> rolePermissionPOS = new ArrayList<>();
                for (RolePermissionBO rolePermissionBO : rolePermissionBOS) {
                    rolePermissionPOS.add(RolePermissionConvert.boConvertPO(rolePermissionBO));
                }
                target.setRolePermission(rolePermissionPOS);
                return target;
            }
        };
        return mapper.createTypeMap(RoleBO.class, RolePO.class)
                .setConverter(converter)
                .map(roleBO);
    }
}
