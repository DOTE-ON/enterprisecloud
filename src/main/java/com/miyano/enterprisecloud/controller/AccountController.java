package com.miyano.enterprisecloud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miyano.enterprisecloud.bean.Account;
import com.miyano.enterprisecloud.bean.vo.AccountTokenVo;
import com.miyano.enterprisecloud.service.serviceAPI.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


/**
 * @author Miyano
 * @since 2020/11/10 14:02
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    final AccountService accountService;
    final JedisPool jedisPool;

    @Value ("${redis.lifecycle}")
    private Integer validTime;

    public AccountController (AccountService accountService, JedisPool jedisPool) {
        this.accountService = accountService;
        this.jedisPool = jedisPool;
    }

    @RequestMapping("/accounts")
    public Object getAccounts () {
        return accountService.findAllAccounts ();
    }

    @RequestMapping("/login")
    public void login (String account, String password, HttpServletResponse response) {

        System.out.println ("/login 被访问.");
        Account ac = accountService.login (account, password);
        String token = UUID.randomUUID ().toString ().replace ("-", "").toLowerCase ();
        ObjectMapper mapper = new ObjectMapper();
        AccountTokenVo tokenVo = new  AccountTokenVo(account, validTime);
        String jsonRst = null;

        try {
            jsonRst = mapper.writeValueAsString(tokenVo);
        } catch (JsonProcessingException e) {
            e.printStackTrace ();
        }

        //连接池对象，
        Jedis jedis = jedisPool.getResource ();

        System.out.println ("jedis 对象为: " + jedis);
        System.out.println ("jedisPool 对象为: " + jedisPool);
        System.out.println ("token = " + token);
        System.out.println ("jsonRst = " + jsonRst);
        System.out.println ("mapper = " + mapper);
        System.out.println ("tokenVo = " + tokenVo);

        //写入token和对应的用户对象
        jedis.set (token, jsonRst);

        //设置键值对的有效时间
        jedis.expire (token, validTime);
        jedis.close ();

        if (ac != null) {
            try {
                response.sendRedirect ("/findAll.html");
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }

//    /**
//     * 传入账户和密码
//     * @param account 账户
//     * @param password 密码
//     * @return 登录状态
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public Object login (String account, String password, HttpSession session) {
//
//        System.out.println (account);
//        System.out.println (password);
//        session.setAttribute ("id", account);
//        return new Account (account, password);
//    }
}