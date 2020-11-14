package com.miyano.enterprisecloud.mapper;

import com.miyano.enterprisecloud.bean.Account;

import java.util.List;

/**
 * @author Miyano
 * @since 2020/11/10 15:56
 */
public interface AccountMapper {

    /**
     * 登录, 比对给定的账户与密码是否一致.
     * @param account 账户
     * @param pwd 密码
     * @return 登录状态
     */
    Account login (String account, String pwd);

    /**
     * 找到全部用户
     * @return 所有用户数组
     */
    List<Account> findAccounts ();

    /**
     * 删除给定账户的用户
     * @param account 给定的账户
     * @return 返回结果, 0 表示删除成功, 1 表示未找到. 2 表示删除失败.
     */
    Integer deleteAccount (String account);
}
