package com.fenlibao.pms.mapper.system;

import com.fenlibao.pms.model.po.idmt.OrganizationPO;
import com.fenlibao.pms.model.po.idmt.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author chen
 * @date 2018/11/21
 */
@Repository
public interface OrganizationDao extends tk.mybatis.mapper.common.Mapper<OrganizationPO>, tk.mybatis.mapper.common.MySqlMapper<OrganizationPO> {

    /**
     * 获取用户所在组别id
     * @param userName
     * @return
     */
    public OrganizationPO getOrganizationByUserName(@Param("userName")String userName);


    /**
     * 复杂查询示例
     * @param map
     * @return List<UserPo>
     */
    public List<UserPO> getLeaguerListByOrganizationId(Map map);


}
