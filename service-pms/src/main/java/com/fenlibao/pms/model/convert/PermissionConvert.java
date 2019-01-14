package com.fenlibao.pms.model.convert;

import com.fenlibao.pms.model.po.idmt.PermissionPO;
import com.fenlibao.pms.model.bo.idmt.PermissionBO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限转换类
 *
 * @author LeiXinXin
 * @date 2018/12/13
 */
public class PermissionConvert {
    private PermissionConvert() {
    }

    /**
     * 将权限PO转为BO
     *
     * @param permissionPO 权限PO
     * @return PermissionBO
     */
    public static PermissionBO poConvertBO(PermissionPO permissionPO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(permissionPO, PermissionBO.class);
    }

    /**
     * 将权限PO转为BO
     *
     * @param permissionBO 权限BO
     * @return PermissionBO
     */
    public static PermissionPO boConvertPO(PermissionBO permissionBO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(permissionBO, PermissionPO.class);
    }

    public static List<PermissionBO> boConvertBOList(List<PermissionPO> permissionPOS) {
        List<PermissionBO> permissionBOS = new ArrayList<>();
        permissionPOS.forEach(permissionPO -> permissionBOS.add(poConvertBO(permissionPO)));
        return  permissionBOS;
    }
}
