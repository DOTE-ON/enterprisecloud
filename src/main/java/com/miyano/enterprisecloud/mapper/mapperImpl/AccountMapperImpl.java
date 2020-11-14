package com.miyano.enterprisecloud.mapper.mapperImpl;

import com.miyano.enterprisecloud.bean.Account;
import com.miyano.enterprisecloud.mapper.AccountMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miyano
 * @since 2020/11/11 16:18
 */
@Repository
public class AccountMapperImpl implements AccountMapper {

    public static List<Account> ls = new ArrayList<> ();
    static {
        ls.add (new Account ("张三", "pwd1"));
        ls.add (new Account ("张三风", "pwd2"));
        ls.add (new Account ("王五", "pwd3"));
        ls.add (new Account ("清华", "pwd4"));
        ls.add (new Account ("北大", "pwd4"));
        ls.add (new Account ("西工大", "pwd4"));
    }

    @Override
    public Account login (String account, String pwd) {

        System.out.println ("login mapper 被调用.");
        System.out.println (account + pwd);
        for (Account l : ls) {
            if (l.getName ().equals (account) && l.getPhone ().equals (pwd)) {
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Account> findAccounts () {
        return ls;
    }

    @Override
    public Integer deleteAccount (String account) {
        for (Account l : ls) {
            if (l.getName ().equals (account)) {
                ls.remove (l);
                return 0;
            }
        }
        return 1;
    }

}