package com.fenlibao.pms.mapper.system;

import com.fenlibao.pms.common.BaseMapper;
import com.fenlibao.pms.dto.req.system.RequestLogReq;
import com.fenlibao.pms.dto.resp.system.RequestLogRespBody;
import com.fenlibao.pms.model.po.idmt.RequestLogPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WangBoRan
 * @date 2018-12-11
 *
 * 请求日志数据层
 */
@Repository
public interface RequestLogDao extends BaseMapper<RequestLogPO> {
    /**
     * 根据条件查询日志访问记录视图信息
     * @param req 请求参数
     * @return
     */
    List<RequestLogRespBody> selectView(RequestLogReq req);

}