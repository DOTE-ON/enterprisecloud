package com.miyano.enterprisecloud.controller;

import com.miyano.enterprisecloud.entity.User;
import com.miyano.enterprisecloud.model.ResponseModel;
import com.miyano.enterprisecloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Miyano
 * @since 2020/11/16 21:57
 */
@RestController
@RequestMapping("/account")
public class TestController {

    @Value("${redis.lifecycle}")
    private Integer validTime;

    @Autowired
    UserService userService;

    @Autowired
    JedisPool jedisPool;

    /**
     * 登录
     *
     * @param account 登录账户
     * @param password 登录密码
     * @return 返回登录对象
     */
    @GetMapping("/token")
    public Object login (String account, String password, HttpServletRequest request) {
        userService.login (account, password);
        return new ResponseModel (301, "Moved Permanently.", "/main.html");
    }

    /**
     * 获取全部用户列表
     *
     * @return
     */
    @GetMapping("/accounts")
    public Object findUsers () {
        User user = new User ();
        user.setAccount ("rky");
        user.setEmail ("renkangyang.");

        System.out.println ("userservice.updateByExampleSelective () called");
        userService.updateByPrimaryKeySelective (user);
        return userService.findUsers ();
    }

    /**
     * 获取用户 id 为 account 的 User 对象
     *
     * @param account 用户账号
     * @return 用户对象
     */
    @GetMapping("/accounts/{account}")
    public Object findUserByAccount (@PathVariable("account") String account) {
        return userService.findUserByAccount (account);
    }

    /**
     * 增加一个用户
     *
     * @param user
     * @return
     */
    @PostMapping("/accounts")
    public Object createUser (User user) {

        return null;
    }

    /**
     * 删除用户 通过 account
     *
     * @param account
     * @return
     */
    @DeleteMapping("/accounts/{account}")
    public Object deleteUserByAccount (@PathVariable("account") String account) {
        try {
            userService.deleteUserByAccount (account);
            return new ResponseModel (200, "删除成功.", "" + 1);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return new ResponseModel (403, "Forbidden.", "" + 0);
    }

}

