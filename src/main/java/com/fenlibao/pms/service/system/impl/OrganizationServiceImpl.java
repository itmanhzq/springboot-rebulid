package com.fenlibao.pms.service.system.impl;

import com.fenlibao.pms.mapper.system.OrganizationMapper;
import com.fenlibao.pms.mapper.system.UserOrganizationMapper;
import com.fenlibao.pms.model.po.idmt.OrganizationPO;
import com.fenlibao.pms.service.system.OrganizationService;
import com.fenlibao.pms.model.bo.idmt.OrganizationBO;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import com.fenlibao.pms.model.po.idmt.IdmtUserOrganizationPO;
import com.fenlibao.pms.model.po.idmt.UserPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.*;


/**
 * @author chen
 * @date 2018-11-26
 */
@Service("OrganizationService")
public class OrganizationServiceImpl implements OrganizationService {

    private static final String PARENT_IDS_PROPERTY = "parentIds";
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private UserOrganizationMapper userOrganizationMapper;

    @Override
    public List<OrganizationPO> getOrganizationIdsByuserName(String userName) {
        OrganizationPO organizationPo = organizationMapper.getOrganizationByUserName(userName);
        if (organizationPo != null) {
            Example example = Example.builder(OrganizationPO.class).where(Sqls.custom().andLike(PARENT_IDS_PROPERTY, "%".concat(organizationPo.getId().toString().concat("%")))).build();
            return organizationMapper.selectByExample(example);
        }
        return new ArrayList<>();
    }

    @Override
    public OrganizationBO getOrganizationList(String userName) {
        OrganizationPO organizationPo = organizationMapper.getOrganizationByUserName(userName);
        if (organizationPo != null) {
            //递归子集
            recursionOrganization(organizationPo);

            OrganizationBO organizationBO = new OrganizationBO();
            BeanUtils.copyProperties(organizationPo, organizationBO);
            return organizationBO;
        }
        return null;
    }

    public void recursionOrganization(OrganizationPO organizationPo) {
        Example example = Example.builder(OrganizationPO.class).where(Sqls.custom().andEqualTo("parentId", organizationPo.getId())).build();
        List<OrganizationPO> childrenList = organizationMapper.selectByExample(example);
        organizationPo.setChildren(childrenList);
        for (OrganizationPO organizationPO : childrenList) {
            recursionOrganization(organizationPO);
        }
    }

    @Override
    public PageInfo<UserBO> getLeaguerListByOrganizationId(int pageNum, int pageSize, Integer organizationId, Integer status) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("organizationId", organizationId);
        params.put("status", status);

        PageInfo<UserPO> userPOPageInfo =  PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> organizationMapper.getLeaguerListByOrganizationId(params));
        PageInfo<UserBO> userBOPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(userPOPageInfo, userBOPageInfo);
        return userBOPageInfo;
    }

    @Override
    public PageInfo<OrganizationBO> childrenOrganizationList(int pageNum, int pageSize, Integer organizationId) {
        Example example = Example.builder(OrganizationPO.class).where(Sqls.custom().andLike(PARENT_IDS_PROPERTY, "%".concat(organizationId.toString().concat("%")))).build();
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> organizationMapper.selectByExample(example));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delOrganization(Integer organizationId) {
        OrganizationPO organizationPO = organizationMapper.selectByPrimaryKey(organizationId);
        organizationMapper.deleteByPrimaryKey(organizationId);
        //删除子集下的用户组织数据
        recursionDelete(organizationPO);
        String parentIds = organizationPO.getParentIds().concat(",") + organizationId;
        Example example = Example.builder(OrganizationPO.class).where(Sqls.custom().andLike(PARENT_IDS_PROPERTY, parentIds + "%")).build();
        organizationMapper.deleteByExample(example);
    }

    /**
     * 递归子集删除
     *
     * @param organizationPo
     */
    public void recursionDelete(OrganizationPO organizationPo) {
        Example delExample = Example.builder(IdmtUserOrganizationPO.class).where(Sqls.custom().andEqualTo("organizationId", organizationPo.getId())).build();
        userOrganizationMapper.deleteByExample(delExample);

        Example example = Example.builder(OrganizationPO.class).where(Sqls.custom().andEqualTo("parentId", organizationPo.getId())).build();
        List<OrganizationPO> childrenList = organizationMapper.selectByExample(example);
        for (OrganizationPO organizationPO : childrenList) {
            recursionOrganization(organizationPO);
        }
    }


    @Override
    public void addOrganization(Integer parentId, String name, String orderId, String marks, String eName) {
        Example example = Example.builder(OrganizationPO.class).where(Sqls.custom().andEqualTo("name", name)).build();
        int i = organizationMapper.selectCountByExample(example);
        if (i > 0) {
            //存在该组织
            return;
        }
        OrganizationPO organization = organizationMapper.selectByPrimaryKey(parentId);
        OrganizationPO organizationPO = new OrganizationPO();
        organizationPO.setParentId(parentId);
        organizationPO.setName(name);
        organizationPO.setStatus(true);
        organizationPO.setOrderId(orderId);
        organizationPO.setParentIds(organization.getParentIds().concat(",").concat(parentId.toString()));
        organizationPO.setEnglishName(eName);
        organizationMapper.insertSelective(organizationPO);
    }

    @Override
    public void updateOrganization(Integer id, String name, String orderId, String marks, String eName) {
        OrganizationPO organizationPO = organizationMapper.selectByPrimaryKey(id);
        Optional<Object> optional = Optional.ofNullable(organizationPO);
        if (!optional.isPresent()) {
            return;
        }
        organizationPO.setName(name);
        organizationPO.setOrderId(orderId);
        organizationPO.setEnglishName(eName);
        organizationPO.setMarks(marks);
        organizationMapper.updateByPrimaryKey(organizationPO);
    }
}
