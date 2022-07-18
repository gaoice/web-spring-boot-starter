package com.gaoice.web.exception;

import com.gaoice.web.r.RConst;

/**
 * @author gaoice
 */
public class WebException extends RuntimeException {

    private String code;

    private String msg;

    public WebException() {
        super();
    }

    public WebException(String s) {
        super(s);
        this.code = RConst.ERROR;
        this.msg = s;
    }

    public WebException(String code, String s) {
        super(s);
        this.code = code;
        this.msg = s;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
