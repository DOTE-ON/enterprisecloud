package com.miyano.enterprisecloud.controller;

import com.miyano.enterprisecloud.bean.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miyano
 * @since 2020/11/12 16:03
 */
@RestController
@RequestMapping("/password")
public class PasswordController {

    @RequestMapping("passwords")
    public static Object getPassword () {
        return new Account ("password", "password");
    }
}
