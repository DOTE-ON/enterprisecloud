package com.miyano.enterprisecloud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Miyano
 * @since 2020/11/10 15:55
 */
public class Account {

    public String name;

    public String phone;

//    @JsonFormat (pattern = "yyyy-MM-dd mm:ss", locale="zh", timezone = "GMT+8")
//    public Date beginTime;

    public Account () {
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public Account (String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
