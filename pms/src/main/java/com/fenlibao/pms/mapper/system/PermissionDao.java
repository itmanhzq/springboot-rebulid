package com.fenlibao.pms.mapper.system;

import com.fenlibao.pms.model.po.idmt.PermissionPO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 权限数据访问层
 *
 * @author LeiXinXin
 * @date 2018/11/26
 */
@Repository
public interface PermissionDao extends tk.mybatis.mapper.common.Mapper<PermissionPO>, tk.mybatis.mapper.common.MySqlMapper<PermissionPO> {

    /**
     * 获取系统权限菜单
     * @param map
     * @return
     */
    List<PermissionPO> getMenuByType(Map map);

    /**
     * 通过id主键查询权限信息
     *
     * @param id 主键id
     * @return Permission
     */
    PermissionPO selectById(Integer id);
}
