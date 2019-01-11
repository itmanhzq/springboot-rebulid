package com.fenlibao.pms.service.system.impl;

import com.fenlibao.pms.mapper.system.RequestLogMapper;
import com.fenlibao.pms.model.po.idmt.RequestLogPO;
import com.fenlibao.pms.model.bo.idmt.RequestLogBO;
import com.fenlibao.pms.dto.req.system.RequestLogReq;
import com.fenlibao.pms.dto.resp.system.RequestLogRespBody;
import com.fenlibao.pms.service.system.RequestLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WangBoRan
 * @date 2018-12-11
 */
@Service
public class RequestLogServiceImpl implements RequestLogService {
    @Autowired
    private RequestLogMapper requestLogMapper;

    @Override
    public void saveLog(RequestLogBO bo) {
        RequestLogPO po=new RequestLogPO();
        BeanUtils.copyProperties(bo,po);
        po.setCostTime(bo.getEndTime()-bo.getStartTime());
        requestLogMapper.insert(po);
    }

    @Override
    public PageInfo<RequestLogRespBody> getLogList(RequestLogReq requestLogReq) {
        return PageHelper.startPage(requestLogReq.getPageNum(), requestLogReq.getPageSize())
                .doSelectPageInfo(() -> requestLogMapper.selectView(requestLogReq));
    }
}
