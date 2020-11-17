package com.miyano.enterprisecloud.service.impl;

import com.miyano.enterprisecloud.entity.User;
import com.miyano.enterprisecloud.service.UserService;
import com.miyano.enterprisecloud.util.MD5;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Miyano
 * @since 2020/11/16 21:52
 */
@Service
public class UserServiceImpl implements UserService {

    static List<User> userList = new ArrayList<> ();

    static {
        userList.add (new User ("miyano", MD5.stringMD5 ("miyanopwd"), "miyano@gmail.com", new Date ()));
        userList.add (new User ("rky", MD5.stringMD5 ("rkypwd"), "rky@gmail.com", new Date ()));
    }

    /**
     * 获取所有用户
     * @return 用户列表
     */
    @Override
    public List<User> findUsers () {
        return userList;
    }

    /**
     * 删除 account 相同的用户
     * @param account 账号
     * @return 查找到的用户
     */
    @Override
    public User findUserByAccount (String account) {
        for (User user : userList) {
            if (account.equals (user.getAccount ())) {
                return user;
            }
        }
        return null;
    }

    /**
     * 删除 account 相同的用户
     * @param account
     * @return
     */
    @Override
    public int deleteUserByAccount (String account) {
        int res = 0;
        if (userList.size () <= 0) {
            return 0;
        }
        for (User user : userList) {
            if (user.getAccount ().equals (account)) {
                userList.remove (user);
                res++;
            }
        }
        return res;
    }

    @Override
    public int alterUser (User input) {
        return 0;
    }


    @Override
    public boolean login (String account, String password) {
        System.out.println ("account = " + account);
        System.out.println ("password = " + password);
        for (User user : userList) {
            if (account.equals (user.getAccount ()) && password.equals (user.getPassword ())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int createUser (User user) {
        userList.add (user);
        return 1;
    }

}
