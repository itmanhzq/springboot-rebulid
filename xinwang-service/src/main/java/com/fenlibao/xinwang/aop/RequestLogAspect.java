package com.fenlibao.xinwang.aop;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fenlibao.base.dto.Response;
import com.fenlibao.xinwang.dto.base.ResponseStatus;
import com.fenlibao.xinwang.mapper.InterfacePrivilegeMapper;
import com.fenlibao.xinwang.mapper.RequestLogMapper;
import com.fenlibao.xinwang.model.enums.RequestHeaderEnum;
import com.fenlibao.xinwang.request.*;
import com.fenlibao.xinwang.request.enums.RequestState;
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

    private static final  String CODE_STR = "code";
    private static final  String MSG_ERROR_CODE = "errorCode";
    private static final  String STATUS_STR = "status";
    private static final  String SUCCESS_STR = "SUCCESS";
    private static final  String SUCCESS_CODE = "0";
    private static final  String FAIL_CODE = "1";
    private static final  String NOT_EXITS = "100007";

    /**
     * 记录网关请求前记录报文
     */
    @Before("execution(* com.fenlibao.xinwang.service.XinwangService.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        RequestLog requestLog = new RequestLog();
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            Object[] obj = joinPoint.getArgs();
            BasePO basePO = (BasePO) obj[0];

            //排除查询接口
            if(basePO.getClass().isAssignableFrom(QueryTransaction.class)
                    ||basePO.getClass().isAssignableFrom(QueryProjectInformation.class)
                    ||basePO.getClass().isAssignableFrom(QueryUserInformation.class)
                    ){
                return;
            }
            String accessKey = request.getHeader(RequestHeaderEnum.ACCESS_KEY.getValue());

            InterfacePrivilege interfacePrivilege = interfacePrivilegeMapper.selectByPrimaryKey(accessKey);
            requestLog.setInterfaceName(XinwangInterfaceName.getServiceName(basePO.getClass()));
            requestLog.setRequestNo(basePO.getRequestNo());
            requestLog.setCreateTime(new Date());
            requestLog.setOrderId(basePO.getFlbOrderId()==null?0:basePO.getFlbOrderId());
            requestLog.setUserId(basePO.getFlbUserId()==null?0:basePO.getFlbUserId());
            requestLog.setStatus(RequestState.DTJ.getCode());
            requestLog.setRequestParams(basePO.toJsonFilterFlb());
            requestLog.setInterfaceUser(interfacePrivilege.getInterfaceUser());
            requestLogMapper.insert(requestLog);
        } catch (Exception e) {
            if(!e.getClass().isAssignableFrom(DuplicateKeyException.class)){
                log.error("记录请求报文：{}", requestLog.toString());
                log.error("请求出错信息：{}",e.getMessage());
            }
        }
    }

    /**
     * 后置通知，记录相应报文
     */
    @AfterReturning(pointcut = "execution(* com.fenlibao.xinwang.service.XinwangService.*(..))", returning = "response")
    public void doAfter(JoinPoint joinPoint, Response response) {
        RequestLog requestLog = new RequestLog();
        try {
            int status = RequestState.DQR.getCode();
            Object[] obj = joinPoint.getArgs();
            BasePO basePO =  (BasePO)obj[0];
            //排除查询接口
            if(basePO.getClass().isAssignableFrom(QueryProjectInformation.class)
                    ||basePO.getClass().isAssignableFrom(QueryUserInformation.class)
                    ){
                return;
            }
            requestLog.setRequestNo(basePO.getRequestNo());

            if(basePO.getClass().isAssignableFrom(DownloadCheckFile.class)){
                // 下载的文件流无法转json
                requestLog.setResponseMsg(response.toString());
            }else {
                requestLog.setResponseMsg(new Gson().toJson(response));
            }
            requestLog.setUpdateTime(new Date());

            if(ResponseStatus.COMMON_OPERATION_SUCCESS.getCode().equals(response.getCode())){
                Object body = response.getBody();
                JSONObject jsonObject = JSONUtil.parseObj(body);
                if(SUCCESS_CODE.equals(jsonObject.get(CODE_STR)) && SUCCESS_STR.equals(jsonObject.get(STATUS_STR))){
                    status = RequestState.CG.getCode() ;
                }
                if(FAIL_CODE.equals(jsonObject.get(CODE_STR))){
                    status = RequestState.SB.getCode();
                }
            }else {
                Object msgStr = response.getMsg();
                JSONObject msgJson = JSONUtil.parseObj(msgStr);

                if(NOT_EXITS.equals(msgJson.get(MSG_ERROR_CODE))){
                    status = RequestState.BCZ.getCode();
                }else{
                    status = RequestState.SB.getCode();
                }
            }

            requestLog.setStatus(status);
            Example example = Example
                    .builder(RequestLog.class)
                    .where(Sqls
                            .custom()
                            .andEqualTo("requestNo", requestLog.getRequestNo()))
                    .build();
            requestLogMapper.updateByExampleSelective(requestLog,example);
        } catch (Exception e) {
            log.error("记录响应报文出错：{}", requestLog.toString());
            log.error("响应出错信息：{}",e.getMessage());
        }

    }


}
