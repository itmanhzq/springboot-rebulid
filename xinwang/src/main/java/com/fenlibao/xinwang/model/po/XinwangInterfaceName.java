package com.fenlibao.xinwang.model.po;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Flynn
 * 接口名称
 *
 */
public enum XinwangInterfaceName {
    PERSONAL_REGISTER_EXPAND(PersonalRegisterExpand.class,"PERSONAL_REGISTER_EXPAND", "个人绑卡注册"),
    QUERY_USER_INFORMATION(QueryProjectInformation.class,"QUERY_USER_INFORMATION", "查询用户的所有信息"),
    RECHARGE(Recharge.class,"RECHARGE", "充值"),
    WITHDRAW(Withdraw.class,"WITHDRAW", "提现"),
    USER_PRE_TRANSACTION(UserAutoPreTransaction.class,"USER_PRE_TRANSACTION", "用户预处理"),
    RESET_PASSWORD(ResetPassword.class,"RESET_PASSWORD","修改密码"),
    MODIFY_MOBILE_EXPAND(ModifyMobileExpand.class,"MODIFY_MOBILE_EXPAND","预留手机号更新"),
    UNBIND_BANKCARD(UnbindBankcard.class,"UNBIND_BANKCARD","解绑银行卡"),
    DOWNLOAD_CHECKFILE(DownloadCheckFile.class,"DOWNLOAD_CHECKFILE","对账文件下载"),
    ESTABLISH_PROJECT(EstablishProject.class,"ESTABLISH_PROJECT","创建标的"),
    QUERY_PROJECT_INFORMATION(QueryProjectInformation.class,"QUERY_PROJECT_INFORMATION","标的信息查询"),
    USER_AUTO_PRE_TRANSACTION(UserAutoPreTransaction.class,"USER_AUTO_PRE_TRANSACTION", "授权预处理"),
    SYNC_TRANSACTION(SyncTransaction.class,"SYNC_TRANSACTION", "单笔交易"),
    ASYNC_TRANSACTION(AsyncTransaction.class,"ASYNC_TRANSACTION","批量交易"),
    QUERY_TRANSACTION(QueryTransaction.class,"QUERY_TRANSACTION","单笔交易查询"),
    DEBENTURE_SALE(DebentureSale.class,"DEBENTURE_SALE", "单笔债权出让"),
    CANCEL_DEBENTURE_SALE(CancelDebentureSale.class,"CANCEL_DEBENTURE_SALE", "取消债权出让"),
    PERSONAL_BIND_BANKCARD_EXPAND(PersonalRegisterExpand.class,"PERSONAL_BIND_BANKCARD_EXPAND", "个人绑卡"),
    MODIFY_PROJECT(ModifyProject.class,"MODIFY_PROJECT", "变更标的"),
    ENTERPRISE_INFORMATION_UPDATE(EnterpriseInformationUpdate.class,"ENTERPRISE_INFORMATION_UPDATE", "企业信息修改"),
    ENTERPRISE_REGISTER(EnterpriseRegister.class,"ENTERPRISE_REGISTER", "企业绑卡注册"),
    ENTERPRISE_BIND_BANKCARD(EnterpriseBindBankcard.class,"ENTERPRISE_BIND_BANKCARD", "企业绑卡"),
    CANCEL_PRE_TRANSACTION(CancelPreTransaction.class,"CANCEL_PRE_TRANSACTION", "取消已冻结的预处理金额"),
    AUTHORIZATION_ENTRUST_PAY(AuthorizationEntrustPay.class,"AUTHORIZATION_ENTRUST_PAY", "委托支付授权"),
    CONFIRM_CHECKFILE(ConfirmCheckfile.class,"CONFIRM_CHECKFILE", "对账文件确认"),
    QUERY_AUTHORIZATION_ENTRUST_PAY_RECORD(QueryAuthorizationEntrustPayRecord.class,"QUERY_AUTHORIZATION_ENTRUST_PAY_RECORD", "委托支付授权记录查询"),
    ACTIVATE_STOCKED_USER(ActivateStockedUser.class,"ACTIVATE_STOCKED_USER", "会员激活"),
    CANCEL_USER_AUTHORIZATION(CancelUserAuthorization.class,"CANCEL_USER_AUTHORIZATION", "取消用户授权"),
    USER_AUTHORIZATION(UserAuthorization.class,"USER_AUTHORIZATION", "用户授权");

    protected final Class basePo;
    protected final String serviceName;
    protected final String name;

    XinwangInterfaceName(Class basePo, String serviceName, String name) {
        this.basePo = basePo;
        this.serviceName = serviceName;
        this.name = name;
    }

    protected static Map<Class, String> maps = new HashMap();
    static {
        for (XinwangInterfaceName xinwangInterfaceName : values()) {
            maps.put(xinwangInterfaceName.basePo,xinwangInterfaceName.serviceName);
        }
    }

    public static String getServiceName(Class basePo) {
        return maps.get(basePo);
    }

}

