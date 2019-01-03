package com.fenlibao.xinwang.testcase;

import cn.hutool.core.date.DateUtil;
import com.fenlibao.xinwang.model.po.*;
import com.fenlibao.xinwang.service.XinwangService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * test用例
 * @author Flynn
 * @Date: 2018/12/20 15:29
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
public class TestInterface {
    @Resource
    XinwangService xinwangService;


    @Test
    public void queryTransaction() throws Exception {

        QueryTransaction queryTransaction = new QueryTransaction();

        this.init(queryTransaction);


        queryTransaction.setPlatformUserNo("INVESTOR9605");
        queryTransaction.setTransactionType(XinwangInterfaceName.getServiceName(Withdraw.class));
        queryTransaction.setRequestNo("20181222175304uu9f9c12bf");
        this.sendRequest("queryTransaction",queryTransaction);
    }


    @Test
    public void recharge() throws Exception {
        Recharge recharge = new Recharge();
        this.init(recharge);
        recharge.setAmount(new BigDecimal(101));
        recharge.setPlatformUserNo("INVESTOR9605");
        recharge.setRedirectUrl("http://192.168.40.213:8086/resultPage/rechargeSuccess");
        recharge.setExpired("20181221114935");
        recharge.setSwiftRoute("ORIGINAL_SWIFT");
        recharge.setRechargeWay("SWIFT");
        recharge.setRequestNo(this.createRequestNo());
        recharge.setExpectPayCompany("YEEPAY");
        recharge.setBankcode("ICBK");
        this.sendRequest("recharge",recharge);

    }

    @Test
    public void withDraw() throws Exception{

        Withdraw withdraw = new Withdraw();

        this.init(withdraw);


        withdraw.setExpired("20181221155029");
        withdraw.setRedirectUrl("http://192.168.40.215:90/#/withdrawalsSuccess");
        withdraw.setAmount(BigDecimal.TEN);
        withdraw.setWithdrawType("NORMAL_URGENT");
        withdraw.setCommission(new BigDecimal(2));
        withdraw.setTimestamp("20181221114935");
        this.sendRequest("withdraw",withdraw);
    }


    @Test
    public void resetPassword() throws Exception {

        ResetPassword resetPassword = new ResetPassword();
        this.init(resetPassword);
        resetPassword.setIsSkip("Remember");

        resetPassword.setRedirectUrl("aaaa");

        this.sendRequest("resetPassword",resetPassword);
    }


    @Test
    public void modifyMobileExpand(){
        ModifyMobileExpand modifyMobileExpand = new ModifyMobileExpand();
        this.init(modifyMobileExpand);
        modifyMobileExpand.setCheckType("LIMIT");
        modifyMobileExpand.setMobile("18819155128");
        modifyMobileExpand.setRedirectUrl("http://192.168.40.215:90/cg/modify_reserved_phone");

        this.sendRequest("modifyMobileExpand",modifyMobileExpand);

    }

    @Test
    public void establishProject(){
        EstablishProject establishProject = new EstablishProject();
        this.init(establishProject);



        establishProject.setPlatformUserNo("BORROWERS9234");
        establishProject.setProjectNo("hhher");
        establishProject.setRepaymentWay("ONE_TIME_SERVICING");
        establishProject.setProjectAmount(new BigDecimal("1000"));
        establishProject.setProjectType("STANDARDPOWDER");
        establishProject.setProjectPeriod(31);
        establishProject.setAnnnualInterestRate(new BigDecimal("0.1"));
        establishProject.setProjectName("哈哈测aaa试aaa啊");
        this.sendRequest("establishProject",establishProject);
    }


    @Test
    public void queryProjectInformation(){
        QueryProjectInformation queryProjectInformation = new  QueryProjectInformation();


        queryProjectInformation.setProjectNo("haaha");

        this.sendRequest("queryProjectInformation",queryProjectInformation);

    }

    @Test
    public void userAutoPreTransaction(){
        UserAutoPreTransaction userAutoPreTransaction = new UserAutoPreTransaction();
        this.init(userAutoPreTransaction);

        userAutoPreTransaction.setBizType("TENDER");
        userAutoPreTransaction.setAmount(BigDecimal.TEN);
        userAutoPreTransaction.setProjectNo("2159948");
        this.sendRequest("userAutoPreTransaction",userAutoPreTransaction);

    }

    @Test
    public void syncTransaction(){
        SyncTransaction syncTransaction = new SyncTransaction();
        this.init(syncTransaction);

        syncTransaction.setProjectNo("2159031");
        syncTransaction.setSaleRequestNo(this.createRequestNo());
        syncTransaction.setTradeType("MARKETING");
        Details details = new Details();
        details.setAmount(BigDecimal.TEN);
        details.setBizType("ALTERNATIVE_RECHARGE");
        details.setSourcePlatformUserNo("SYS_GENERATE_006");
        details.setTargetPlatformUserNo("INVESTOR9605");

        List<Details> detailsList = new ArrayList<>();
        detailsList.add(details);
        syncTransaction.setDetails(detailsList);
        this.sendRequest("syncTransaction",syncTransaction);

    }

    @Test
    public void asyncTransaction(){
        AsyncTransaction asyncTransaction = new AsyncTransaction();
        this.init(asyncTransaction);

        this.sendRequest("asyncTransaction",asyncTransaction);
    }
    @Test
    public void debentureSale(){
        DebentureSale debentureSale = new DebentureSale();
        this.init(debentureSale);
        debentureSale.setProjectNo("2159031");
        debentureSale.setSaleShare(new BigDecimal(10000));
        this.sendRequest("debentureSale",debentureSale);

    }

    //TODO 文件流传不过来？
    @Test
    public void download() throws  Exception{
        DownloadCheckFile downloadCheckFile = new DownloadCheckFile();
        this.init(downloadCheckFile);
//        downloadCheckFile.setAccessKey("aaa");
        downloadCheckFile.setRequestNo(this.createRequestNo());
        downloadCheckFile.setFileDate("20181221");
        downloadCheckFile.setTimestamp(DateUtil.format(DateUtil.date(),"yyyyMMddHHmmss"));


//        xinwangService.download(downloadCheckFile);
        this.sendRequest("downloadCheckFile",downloadCheckFile);

    }

    @Test
    public void confirmCheckfile() throws  Exception{
        ConfirmCheckfile confirmCheckfile = new ConfirmCheckfile();
//        confirmCheckfile.setAccessKey("aaa");
        confirmCheckfile.setRequestNo(this.createRequestNo());
//        confirmCheckfile.setPlatformUserNo("6000000311");
        confirmCheckfile.setFileDate("20181221");
        confirmCheckfile.setTimestamp(DateUtil.format(DateUtil.date(),"yyyyMMddHHmmss"));

        Map<String,String> aa = new HashMap<>();
        Map<String,String> aa1 = new HashMap<>();
        Map<String,String> aa2 = new HashMap<>();
        Map<String,String> aa3 = new HashMap<>();
        Map<String,String> aa4 = new HashMap<>();

        aa.put("fileType","RECHARGE");
        aa1.put("fileType","WITHDRAW");
        aa2.put("fileType","COMMISSION");
        aa3.put("fileType","TRANSACTION");
        aa4.put("fileType","BACKROLL_RECHARGE");

        List list = new ArrayList<>();
        list.add(aa);
        list.add(aa1);
        list.add(aa2);
        list.add(aa3);
        list.add(aa4);
        confirmCheckfile.setDetail(list);

        this.sendRequest("confirmCheckfile",confirmCheckfile);


    }


    public synchronized  String createRequestNo(){
        String uuid = UUID.randomUUID().toString();
        String randomString = uuid.substring(0,8);
        return DateUtil.format(DateUtil.date(),"yyyyMMddHHmmss") +"uu" + randomString;
    }
    public void init(BasePO po){
        po.setTimestamp(DateUtil.format(DateUtil.date(),"yyyyMMddHHmmss") );
        po.setRequestNo(this.createRequestNo());
    }

    public void sendRequest(String methode,BasePO po){


        po.setFlbOrderId(11);
        po.setFlbUserId(9605);

        HttpHeaders headers = new HttpHeaders();
        headers.set("accessKey", "aaa");
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);

        String url = "http://192.168.40.188:7001/xinwang/"+methode;

        String request = po.toJson();
        System.out.println("请求json参数:" + request);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity(request, headers);
        ResponseEntity<String> strs = restTemplate.postForEntity(url,httpEntity,String.class );
        log.info("响应报文：{}",strs.getBody());
    }
}
