package com.gaoice.web;

import lombok.Data;

/**
 * Web Result
 *
 * @author gaoice
 */
@Data
public class R<T> {

    private long code;

    private T data;

    private String msg;

    public R() {
    }

    public R(long code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setCode(RConst.OK);
        r.setData(data);
        return r;
    }

    public static <T> R<T> error(long code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static <T> R<T> error(String msg) {
        return error(RConst.ERROR, msg);
    }

    public boolean isSuccess() {
        return RConst.OK == code;
    }
}
