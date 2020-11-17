package com.miyano.enterprisecloud.controller;

import com.miyano.enterprisecloud.entity.User;
import com.miyano.enterprisecloud.model.ResponseModel;
import com.miyano.enterprisecloud.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Miyano
 * @since 2020/11/16 21:57
 */
@RestController
@RequestMapping("/account")
public class TestController {

    @Value("${redis.lifecycle}")
    private Integer validTime;

    final UserService userService;

    final JedisPool jedisPool;

    public TestController (UserService userService, JedisPool jedisPool) {
        this.userService = userService;
        this.jedisPool = jedisPool;
    }

    /**
     * 登录
     *
     * @param request
     * @return
     */
    @GetMapping("/token")
    public Object login (HttpServletRequest request) {
        return new ResponseModel (301, "Moved Permanently.", "/main.html");
    }

    /**
     * 获取全部用户列表
     *
     * @return
     */
    @GetMapping("/accounts")
    public Object findUsers () {

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
        user.setCreated (new Date ());
        System.out.println ("user = " + user);
        return userService.createUser (user);
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

//        try {
//            userService.login (request.getHeader ("account"), request.getHeader ("password"));
//            String account = request.getHeader ("account");
//
//            String token = UID.getuid () + request.getHeader ("account") + System.currentTimeMillis ();
//            Jedis jedis = jedisPool.getResource ();
//            jedis.set (token, account);
//            jedis.expire (token, validTime);
//            jedis.close ();
//            md.addObject ("state", 200);
//            md.addObject ("message", "请求已完成.");
//            md.addObject ("uri", "/main.html");
//            md.addObject ("token", token);
//
//            System.out.println ("token = " + token);
//
//        } catch (NullPointerException e) {
//
//            md.addObject ("state", 444);
//            md.addObject ("message", "参数异常");
//            md.addObject ("uri", "/index.html");
//            md.addObject ("token", null);
//        }
//        return md;
//}
