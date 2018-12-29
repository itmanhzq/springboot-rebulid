package com.fenlibao.pms.service.system;

import com.fenlibao.pms.dto.req.system.RequestLogReq;
import com.fenlibao.pms.dto.resp.system.RequestLogRespBody;
import com.fenlibao.pms.model.bo.idmt.RequestLogBO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @author WangBoRan
 * @date 2018-12-11
 */
@Service
public interface RequestLogService {
    /**
     * 添加访问日志
     * @param bo 访问日志BO类
     */
    void saveLog(RequestLogBO bo);

    /**
     * 查询访问日志
     * @param requestLogReq 请求参数
     * @return
     */
    PageInfo<RequestLogRespBody> listLog(RequestLogReq requestLogReq);
}
