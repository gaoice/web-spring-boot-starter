package com.gaoice.web.exception;

import com.gaoice.web.RConst;

/**
 * @author gaoice
 */
public class WebException extends RuntimeException {

    private long code;

    private String msg;

    public WebException() {
        super();
    }

    public WebException(String s) {
        super(s);
        this.code = RConst.ERROR;
        this.msg = s;
    }

    public WebException(long code, String s) {
        super(s);
        this.code = code;
        this.msg = s;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
