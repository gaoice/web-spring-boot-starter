package com.gaoice.web;

import org.springframework.http.HttpStatus;

/**
 * @author gaoice
 */
public interface RConst {

    /**
     * 成功
     */
    long OK = HttpStatus.OK.value();

    /**
     * 内部错误
     */
    long ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();

}
