package com.miyano.enterprisecloud.service.serviceImpl;

import com.miyano.enterprisecloud.bean.Account;
import com.miyano.enterprisecloud.mapper.AccountMapper;
import com.miyano.enterprisecloud.service.serviceAPI.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miyano
 * @since 2020/11/11 9:52
 */
@Service
public class AccountServiceImpl implements AccountService {

    final AccountMapper accountMapper;

    public AccountServiceImpl (AccountMapper accountMapper) {this.accountMapper = accountMapper;}

//    public static List<Account> ls = new ArrayList<> ();
//
//    static {
//        ls.add (new Account ("乔伟龙", "18209291263"));
//        ls.add (new Account ("miyano", "12138"));
//    }

    @Override
    public List<Account> findAllAccounts () {
        return accountMapper.findAccounts ();
    }

    @Override
    public Account login (String account, String pwd) {
        System.out.println ("login service 被调用");
        return accountMapper.login (account, pwd);
    }
}