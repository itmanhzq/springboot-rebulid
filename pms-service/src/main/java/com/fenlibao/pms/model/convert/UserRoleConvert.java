package com.fenlibao.pms.model.convert;

import com.fenlibao.pms.model.po.idmt.UserRolePO;
import com.fenlibao.pms.model.bo.idmt.UserRoleBO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色转换类
 *
 * @author LeiXinXin
 * @date 2018/12/14
 */
public class UserRoleConvert {
    private UserRoleConvert() {
    }

    /**
     * 将用户角色PO转为BO
     *
     * @param userRolePO 用户角色PO
     * @return UserRoleBO
     */
    public static UserRoleBO poConvertBO(UserRolePO userRolePO) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        AbstractConverter<UserRolePO, UserRoleBO> converter = new AbstractConverter<UserRolePO, UserRoleBO>() {
            @Override
            protected UserRoleBO convert(UserRolePO source) {
                UserRoleBO userRoleBO = UserRoleBO.builder().build();
                BeanUtils.copyProperties(source, userRoleBO);
                userRoleBO.setRole(RoleConvert.poConvertBO(source.getRole()));
                return userRoleBO;
            }
        };

        return mapper.createTypeMap(UserRolePO.class, UserRoleBO.class)
                .setConverter(converter)
                .map(userRolePO);
    }


    /**
     * 将用户角色PO集合转为BO集合
     *
     * @param userRolePOS 用户角色PO集合
     * @return UserRoleBO
     */
    public static List<UserRoleBO> poListConvertBOList(List<UserRolePO> userRolePOS) {
        List<UserRoleBO> userRoleBOS = new ArrayList<>();
        userRolePOS.forEach(userRolePO -> userRoleBOS.add(poConvertBO(userRolePO)));
        return userRoleBOS;
    }
}
