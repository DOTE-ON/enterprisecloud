package com.miyano.enterprisecloud.model;

/**
 * @author Miyano
 * @since 2020/11/16 23:08
 */
public class ResponseModel {

    private int code;
    private String message;
    private Object body;


    public ResponseModel () {
    }

    public ResponseModel (int code, String message, String body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public int getCode () {
        return code;
    }

    public void setCode (int code) {
        this.code = code;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public Object getBody () {
        return body;
    }

    public void setBody (Object body) {
        this.body = body;
    }

}
