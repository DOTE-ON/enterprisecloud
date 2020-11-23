package com.miyano.enterprisecloud.service;

import com.miyano.enterprisecloud.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 通过账号查找 User 对象
     * @param account 账号
     * @return 用户对象
     */
    User findUserByAccount (String account);

    /**
     * 通过账户删除
     * @param account
     * @return
     */
    int deleteUserByAccount (String account);

    List<User> selectAll ();

    int alterUser (User input);

    boolean login (String account, String password);

    int createUser (User user);

    int updateByPrimaryKeySelective (User user);
}
