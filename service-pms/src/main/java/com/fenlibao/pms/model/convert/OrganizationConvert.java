package com.fenlibao.pms.model.convert;

import com.fenlibao.pms.model.po.idmt.OrganizationPO;
import com.fenlibao.pms.model.bo.idmt.OrganizationBO;
import org.modelmapper.ModelMapper;

/**
 * 部门类转换
 *
 * @author LeiXinXin
 * @date 2018/12/20
 */
public class OrganizationConvert {
    private OrganizationConvert() {
    }

    public static OrganizationBO poConvertBO(OrganizationPO organizationPO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(organizationPO, OrganizationBO.class);
    }
}
