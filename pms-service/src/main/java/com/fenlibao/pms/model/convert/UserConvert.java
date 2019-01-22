package com.fenlibao.pms.model.convert;

import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.model.po.idmt.UserPO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PMS用户转换类
 *
 * @author Toby
 * @date 2018/11/7
 */
public class UserConvert {

    private UserConvert() {
    }

    /**
     * 将用户PO转为BO
     *
     * @param userPO 用户PO
     * @return UserBO
     */
    public static UserBO poConvertBO(UserPO userPO) {
        ModelMapper mapper = new ModelMapper();
        AbstractConverter<UserPO, UserBO> converter = new AbstractConverter<UserPO, UserBO>() {
            @Override
            protected UserBO convert(UserPO source) {
                UserBO userBO = UserBO.builder().build();
                BeanUtils.copyProperties(source, userBO);
                if (Objects.nonNull(source.getOrganization())) {
                    userBO.setOrganization(OrganizationConvert.poConvertBO(source.getOrganization()));
                }
                return userBO;
            }
        };

        return mapper
                .createTypeMap(UserPO.class, UserBO.class)
                .setConverter(converter)
                .map(userPO);
    }

    /**
     * 将用户PO集合转为BO集合
     *
     * @param userPOList 用户PO
     * @return UserBO
     */
    public static List<UserBO> poListConvertBOList(List<UserPO> userPOList) {
        List<UserBO> userBOList = new ArrayList<>();
        userPOList.forEach(userPO -> userBOList.add(poConvertBO(userPO)));
        return userBOList;
    }

    /**
     * 将用户BO转为PO
     *
     * @param userBO 用户BO
     * @return UserPO
     */
    public static UserPO boConvertBO(UserBO userBO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userBO, UserPO.class);
    }

}
