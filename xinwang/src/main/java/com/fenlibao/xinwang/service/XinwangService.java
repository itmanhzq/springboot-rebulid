package com.fenlibao.xinwang.service;

import com.fenlibao.base.dto.Response;
import com.fenlibao.xinwang.model.po.BasePO;
import com.fenlibao.xinwang.model.po.DownloadCheckFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author Flynn
 */
public interface XinwangService {


    /**
     * 直连接口
     * @param basePO 业务实体类
     * @return 受理状况响应报文
     * @throws Exception
     */
    Response serviceRequest(BasePO basePO) throws  GeneralSecurityException, IOException;


    /**
     * 网关接口 (构造参数跳转到新网页面)
     * @param basePO
     * @return
     * @throws Exception
     */
    Response gatewayRequest(BasePO basePO) throws  GeneralSecurityException, IOException;


    /**
     *  对账文件下载接口
     * @param downloadCheckFile
     * @return
     * @throws Exception
     */
    Response download(DownloadCheckFile downloadCheckFile) throws  GeneralSecurityException, IOException;

}
