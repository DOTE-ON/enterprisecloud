package com.miyano.enterprisecloud.service.impl;

import com.miyano.enterprisecloud.dao.UserDao;
import com.miyano.enterprisecloud.entity.User;
import com.miyano.enterprisecloud.entity.UserExample;
import com.miyano.enterprisecloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Miyano
 * @since 2020/11/17 15:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * 通过账号查找 User 对象
     *
     * @param account 账号
     * @return 用户对象
     */
    @Override
    public User findUserByAccount (String account) {
        return null;
    }

    /**
     * 通过账户删除
     *
     * @param account
     * @return
     */
    @Override
    public int deleteUserByAccount (String account) {
        return 0;
    }

    @Override
    public List<User> selectAll () {
        return userDao.selectAll ();
    }

    @Override
    public int alterUser (User input) {
        return 0;
    }

    @Override
    public boolean login (String account, String password) {
        System.out.println (account + password);
        UserExample userExample = new UserExample ();
        userDao.selectByExample (userExample);
        return false;
    }

    @Override
    public int createUser (User user) {
        System.out.println ("service user: " + user);
        return userDao.insert (user);
    }

    @Override
    public int updateByPrimaryKeySelective (User user) {
        return userDao.updateByPrimaryKeySelective (user);
    }
}
