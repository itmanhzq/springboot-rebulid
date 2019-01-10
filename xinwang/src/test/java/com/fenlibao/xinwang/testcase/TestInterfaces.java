package com.fenlibao.xinwang.testcase;

import cn.hutool.core.date.DateUtil;
import com.fenlibao.xinwang.request.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.*;

/**
 * test用例
 * @author hubert
 * @Date: 2018/12/20 15:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class TestInterfaces {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    private static String TIME_STAMP = DateUtil.format(DateUtil.date(),"yyyyMMddHHmmss");

    public synchronized String createRequestNo(){
        String uuid = UUID.randomUUID().toString();
        String randomString = uuid.substring(0,8);
        return DateUtil.format(DateUtil.date(),"yyyyMMddHHmmss") + randomString.replace("-","");
    }

    @Test
    public void testCancelDebentureSale() {
        CancelDebentureSale cancelDebentureSale = new CancelDebentureSale();
        cancelDebentureSale.setTimestamp(TIME_STAMP);
        //CreditsaleRequestNo取的是6260表的creditsale_no
        cancelDebentureSale.setCreditsaleRequestNo("201709121016498aaf95d11b");
        cancelDebentureSale.setRequestNo("201709121016498aaf95d11b");
        this.sendRequest("cancelDebentureSale",cancelDebentureSale);
    }

    @Test
    public void testPersonalBindBankcardExpand() {
        PersonalBindBankcardExpand personalBindBankcardExpand = new PersonalBindBankcardExpand();
        personalBindBankcardExpand.setTimestamp(TIME_STAMP);
        personalBindBankcardExpand.setRequestNo("201812181710518b4fe30d-b");
        personalBindBankcardExpand.setRedirectUrl("www.929jj.com");
        personalBindBankcardExpand.setPlatformUserNo("INVESTOR9605");
        personalBindBankcardExpand.setMobile("15603078188");
        this.sendRequest("personalBindBankcardExpand",personalBindBankcardExpand);
    }

    @Test
    public void testModifyProject() {
        ModifyProject modifyProject = new ModifyProject();
        modifyProject.setRequestNo("2018122116014571003480-b");
        modifyProject.setTimestamp(TIME_STAMP);
        modifyProject.setProjectNo("2159944");
        modifyProject.setStatus("FINISH");
        this.sendRequest("modifyProject",modifyProject);
    }

    @Test
    public void testEnterpriseInformationUpdate(){
        EnterpriseInformationUpdate enterpriseInformationUpdate = new EnterpriseInformationUpdate();
        enterpriseInformationUpdate.setTimestamp(TIME_STAMP);
        enterpriseInformationUpdate.setRequestNo(this.createRequestNo());
        enterpriseInformationUpdate.setPlatformUserNo("BORROWERS5728143");
        enterpriseInformationUpdate.setRedirectUrl("www.baidu.com");
        this.sendRequest("enterpriseInformationUpdate",enterpriseInformationUpdate);
    }

    @Test
    public void testEnterpriseRegister(){
        EnterpriseRegister enterpriseRegister = new EnterpriseRegister();
        enterpriseRegister.setTimestamp(TIME_STAMP);
        enterpriseRegister.setRequestNo(this.createRequestNo());
        enterpriseRegister.setPlatformUserNo("BORROWERS5728143");
        enterpriseRegister.setRedirectUrl("www.baidu.com");
        this.sendRequest("enterpriseRegister",enterpriseRegister);
    }

    @Test
    public void testCancelPreTransaction(){
        CancelPreTransaction cancelPreTransaction = new CancelPreTransaction();
        cancelPreTransaction.setTimestamp(TIME_STAMP);
        cancelPreTransaction.setRequestNo(this.createRequestNo());
        cancelPreTransaction.setPreTransactionNo("26443561");
        cancelPreTransaction.setAmount(new BigDecimal("100"));
        this.sendRequest("cancelPreTransaction",cancelPreTransaction);
    }

    @Test
    public void testEnterpriseBindBankcard(){
        EnterpriseBindBankcard enterpriseBindBankcard = new EnterpriseBindBankcard();
        enterpriseBindBankcard.setTimestamp(TIME_STAMP);
        enterpriseBindBankcard.setRequestNo(this.createRequestNo());
        enterpriseBindBankcard.setBankcardNo("6226902103067775");
        enterpriseBindBankcard.setBankcode("ICBK");
        enterpriseBindBankcard.setPlatformUserNo("BORROWERS9806");
        enterpriseBindBankcard.setRedirectUrl("www.fenlibao.com");
        this.sendRequest("enterpriseBindBankcard",enterpriseBindBankcard);
    }

    @Test
    public void testConfirmCheckfile(){
        ConfirmCheckfile confirmCheckfile = new ConfirmCheckfile();
        confirmCheckfile.setTimestamp(TIME_STAMP);
        confirmCheckfile.setRequestNo(this.createRequestNo());
        confirmCheckfile.setFileDate("20181223");
        List<Map<String,String>> detail = new ArrayList<>();
        Map<String,String> map1=new HashMap<>();
        map1.put("fileType","RECHARGE");
        detail.add(map1);
        Map<String,String> map2=new HashMap<>();
        map2.put("fileType","WITHDRAW");
        detail.add(map2);
        Map<String,String> map3=new HashMap<>();
        map3.put("fileType","COMMISSION");
        detail.add(map3);
        Map<String,String> map4=new HashMap<>();
        map4.put("fileType","TRANSACTION");
        detail.add(map4);
        Map<String,String> map5=new HashMap<>();
        map5.put("fileType","BACKROLL_RECHARGE");
        detail.add(map5);
        confirmCheckfile.setDetail(detail);
        this.sendRequest("confirmCheckfile",confirmCheckfile);
    }

    @Test
    public void testActivateStockedUser(){
        ActivateStockedUser activateStockedUser = new ActivateStockedUser();
        activateStockedUser.setTimestamp(TIME_STAMP);
        activateStockedUser.setRequestNo(this.createRequestNo());
        activateStockedUser.setRedirectUrl("www.fenlibao.com");
        activateStockedUser.setAmount(new BigDecimal("10000"));
        activateStockedUser.setPlatformUserNo("INVESTOR5728720");
        this.sendRequest("activateStockedUser",activateStockedUser);
    }

    @Test
    public void testCancelUserAuthorization(){
        CancelUserAuthorization cancelUserAuthorization = new CancelUserAuthorization();
        cancelUserAuthorization.setTimestamp(TIME_STAMP);
        cancelUserAuthorization.setRequestNo(this.createRequestNo());
        cancelUserAuthorization.setAuthList("TENDER,REPAYMENT");
        cancelUserAuthorization.setPlatformUserNo("INVESTOR5728720");
        this.sendRequest("cancelUserAuthorization",cancelUserAuthorization);
    }

    @Test
    public void testUserAuthorization(){
        UserAuthorization userAuthorization = new UserAuthorization();
        userAuthorization.setTimestamp(TIME_STAMP);
        userAuthorization.setRequestNo(this.createRequestNo());
        userAuthorization.setAuthList("TENDER,REPAYMENT");
        userAuthorization.setPlatformUserNo("INVESTOR5728720");
        userAuthorization.setRedirectUrl("www.fenlibao.com");
        this.sendRequest("userAuthorization",userAuthorization);
    }

    @Test
    public void testAuthorizationEntrustPay(){
        AuthorizationEntrustPay authorizationEntrustPay = new AuthorizationEntrustPay();
        authorizationEntrustPay.setTimestamp(TIME_STAMP);
        authorizationEntrustPay.setRequestNo(this.createRequestNo());
        authorizationEntrustPay.setBorrowPlatformUserNo("BORROWERS9232");
        authorizationEntrustPay.setProjectNo("3588");
        authorizationEntrustPay.setCheckType("LIMIT");
        authorizationEntrustPay.setEntrustedType("PERSONAL");
        authorizationEntrustPay.setEntrustedPlatformUserNo("INVESTOR8996");
        this.sendRequest("authorizationEntrustPay",authorizationEntrustPay);
    }

    @Test
    public void testQueryAuthorizationEntrustPayRecord(){
        QueryAuthorizationEntrustPayRecord queryAuthorizationEntrustPayRecord = new QueryAuthorizationEntrustPayRecord();
        queryAuthorizationEntrustPayRecord.setTimestamp(TIME_STAMP);
        queryAuthorizationEntrustPayRecord.setRequestNo("201707141147248952");
        this.sendRequest("queryAuthorizationEntrustPayRecord",queryAuthorizationEntrustPayRecord);
    }

    public void sendRequest(String methode,BasePO po) {
//        String url = "http://192.168.40.120:7001/xinwang/"+methode;
//        String request = new Gson().toJson(po);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("accessKey", "aaa");
//        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//        headers.setContentType(type);
//        HttpEntity<String> httpEntity = new HttpEntity(request, headers);
//        ResponseEntity<String> strs = restTemplate.postForEntity(url,httpEntity,String.class );
//        log.info("\""+ methode + "\"响应报文：{}",strs.getBody());

        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .post("/xinwang/" + methode)
                    .header("accessKey", "aaa")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(po.toJson()))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            log.error(methode + "请求失败",e.getMessage());
        }
    }
}
