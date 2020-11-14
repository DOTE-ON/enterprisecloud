package com.miyano.enterprisecloud.service.serviceAPI;

import com.miyano.enterprisecloud.bean.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Miyano
 * @since 2020/11/11 9:50
 */
public interface AccountService {

    /**
     * 返回所有用户
     * @return 用户列表
     */
    List<Account> findAllAccounts ();

    /**
     * 登录方法
     * @param account 登录账户
     * @param pwd 登录密码
     * @return 登陆状态
     */
    Account login (String account, String pwd);
}