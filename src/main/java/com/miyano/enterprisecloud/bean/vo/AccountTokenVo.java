package com.miyano.enterprisecloud.bean.vo;

import java.io.Serializable;

/**
 * @author Miyano
 * @since 2020/11/14 8:08
 */
public class AccountTokenVo implements Serializable {

    private static final long serialVersionUID = 12138L;

    private String account;

    private Integer validTime;

    public AccountTokenVo () {
    }

    public AccountTokenVo (String account, Integer validTime) {
        this.account = account;
        this.validTime = validTime;
    }
    
    public String getAccount () {
        return account;
    }

    public void setAccount (String account) {
        this.account = account;
    }

    public Integer getValidTime () {
        return validTime;
    }

    public void setValidTime (Integer validTime) {
        this.validTime = validTime;
    }

}
