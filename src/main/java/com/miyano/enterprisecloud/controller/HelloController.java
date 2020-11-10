package com.miyano.enterprisecloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miyano
 * @since 2020/11/10 14:02
 */
@RestController
public class HelloController {

    @RequestMapping ("/hello")
    public String hello () {
        System.out.println ("hello called.");
        return "hello, spring boot!";
    }
}