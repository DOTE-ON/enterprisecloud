package com.miyano.enterprisecloud.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miyano.enterprisecloud.entity.User;

import java.util.Date;

/**
 * @author Miyano
 * @since 2020/11/20 10:35
 */
public class Test {

//    String account, String password, String email, Date created

    public static void main (String[] args) {
        ObjectMapper mapper = new ObjectMapper ();
        User user = new User ("ac", "pwd", "email", new Date ());
        try {
            System.out.println (mapper.writeValueAsString (user));
        } catch (JsonProcessingException e) {
            e.printStackTrace ();
        }
    }
}
