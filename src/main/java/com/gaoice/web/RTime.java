package com.gaoice.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 带时间戳的 Result
 *
 * @author gaoice
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RTime<T> extends R<T> {

    private Long timestamp = System.currentTimeMillis();

    public RTime() {
    }

    public RTime(long code, T data, String msg) {
        super(code, data, msg);
    }

    public static <T> RTime<T> ok(T data) {
        RTime<T> r = new RTime<>();
        r.setCode(RConst.OK);
        r.setData(data);
        return r;
    }

    public static <T> RTime<T> error(long code, String msg) {
        RTime<T> r = new RTime<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static <T> RTime<T> error(String msg) {
        return error(RConst.ERROR, msg);
    }
}
