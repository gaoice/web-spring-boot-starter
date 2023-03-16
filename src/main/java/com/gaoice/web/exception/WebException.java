package com.gaoice.web.exception;

import org.springframework.http.HttpStatus;

/**
 * @author gaoice
 */
public class WebException extends RuntimeException {

    private int code;

    private String msg;

    public WebException() {
        super();
    }

    public WebException(String s) {
        super(s);
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.msg = s;
    }

    public WebException(int code, String s) {
        super(s);
        this.code = code;
        this.msg = s;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
