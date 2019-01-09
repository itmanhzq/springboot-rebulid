package com.fenlibao.xinwang.aop;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fenlibao.xinwang.dto.base.Response;
import com.fenlibao.xinwang.dto.base.ResponseStatus;
import com.fenlibao.xinwang.mapper.InterfacePrivilegeMapper;
import com.fenlibao.xinwang.mapper.RequestLogMapper;
import com.fenlibao.xinwang.model.enums.RequestHeaderEnum;
import com.fenlibao.xinwang.model.po.*;
import com.fenlibao.xinwang.model.po.enums.RequestState;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Flynn
 * 新网请求AOP
 */
@Aspect
@Configuration
@Slf4j
public class RequestLogAspect {


    @Resource
    private RequestLogMapper requestLogMapper;
    @Resource
    private InterfacePrivilegeMapper interfacePrivilegeMapper;

    private static final  String CODE = "code";
    private static final  String STATUS = "status";
    private static final  String SUCCESS = "SUCCESS";
    private static final  String ZERO = "0";
    private static final  String ONE = "1";
    private static final  String NOT_EXITS = "100007";
    /**
     *
     * 记录网关请求前记录报文
     */
    @Before("execution(* com.fenlibao.xinwang.service.XinwangService.*(..))")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
         RequestLog requestLog = new RequestLog();
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            Object[] obj = joinPoint.getArgs();
            BasePO basePO = (BasePO) obj[0];

            String serviceName =XinwangInterfaceName.getServiceName(basePO.getClass()) ;
            //排除查询接口
            if(serviceName.equals(XinwangInterfaceName.getServiceName(QueryTransaction.class))
                    ||serviceName.equals(XinwangInterfaceName.getServiceName(QueryProjectInformation.class))
                    ||serviceName.equals(XinwangInterfaceName.getServiceName(QueryUserInformation.class))
                    ){
                return;
            }
            String accessKey = request.getHeader(RequestHeaderEnum.ACCESS_KEY.getValue());

            InterfacePrivilege interfacePrivilege = interfacePrivilegeMapper.selectByPrimaryKey(accessKey);
            requestLog.setInterfaceName(XinwangInterfaceName.getServiceName(basePO.getClass()));
            requestLog.setRequestNo(basePO.getRequestNo());
            requestLog.setCreateTime(new Date());
            requestLog.setOrderId(basePO.getFlbOrderId());
            requestLog.setUserId(basePO.getFlbUserId());
            requestLog.setStatus(RequestState.DTJ.getCode());
            requestLog.setRequestParams(basePO.toJsonFilterFlb());
            requestLog.setInterfaceUser(interfacePrivilege.getInterfaceUser());
            try {
                requestLogMapper.insert(requestLog);
            } catch (DuplicateKeyException e) {
            }
        } catch (Exception e) {
            log.error("记录请求报文：{}", requestLog.toString());
            log.error("请求出错信息：{}",e.getMessage());
        }


    }
    /**
     *
     * 后置通知，记录相应报文
     */
    @AfterReturning(pointcut = "execution(* com.fenlibao.xinwang.service.XinwangService.*(..))", returning = "response")
    public void doAfter(JoinPoint joinPoint,Response response) {
        RequestLog requestLog = new RequestLog();
        try {
            int status = RequestState.DQR.getCode();
            Object[] obj = joinPoint.getArgs();
            BasePO basePO =  (BasePO)obj[0];
            requestLog.setRequestNo(basePO.getRequestNo());

            String serviceName =XinwangInterfaceName.getServiceName(basePO.getClass()) ;
            if(serviceName.equals(XinwangInterfaceName.getServiceName(DownloadCheckFile.class))){
                // 下载的文件流无法转json
                if(response.getCode()== ResponseStatus.COMMON_OPERATION_SUCCESS.getCode()){
                    requestLog.setResponseMsg(response.toString());
                    status = RequestState.CG.getCode();
                }else{
                    requestLog.setResponseMsg(response.toString());
                    status = RequestState.SB.getCode();
                }
            }else {
                requestLog.setResponseMsg(new Gson().toJson(response));
            }
            requestLog.setUpdateTime(new Date());
            Object body = response.getBody();
            JSONObject jsonObject = JSONUtil.parseObj(body);
            if(response.getCode()==ResponseStatus.COMMON_OPERATION_SUCCESS.getCode()){
                if(ZERO.equals(jsonObject.get(CODE)) && SUCCESS.equals(jsonObject.get(STATUS))){
                    status = RequestState.CG.getCode() ;
                }
                if(ONE.equals(jsonObject.get(CODE))){
                    status = RequestState.SB.getCode();
                }
            }
            if(response.getCode()==ResponseStatus.COMMON_OPERATION_FAIL.getCode()){
                if(ONE.equals(jsonObject.get(CODE))){
                    status = RequestState.SB.getCode();
                }
                if(NOT_EXITS.equals(jsonObject.get(CODE))){
                    status = RequestState.BCZ.getCode();
                }
            }
            requestLog.setStatus(status);
            Example example = Example.builder(RequestLog.class)
                    .where(Sqls.custom().andEqualTo("requestNo", requestLog.getRequestNo()))
                    .build();
            requestLogMapper.updateByExampleSelective(requestLog,example);
        } catch (Exception e) {
            log.error("记录响应报文出错：{}", requestLog.toString());
            log.error("响应出错信息：{}",e.getMessage());
        }

    }


}
