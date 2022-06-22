package com.gaoice.web.spring.boot.autoconfigure.advice;

import com.gaoice.web.R;
import com.gaoice.web.exception.WebException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author gaoice
 */
@Slf4j
public class WebExceptionRAdvice implements WebExceptionAdvice {

    @Override
    public R<?> handleException(Exception e) {
        log.debug("controller exception: ", e);
        if (e instanceof WebException) {
            WebException webException = (WebException) e;
            return R.error(webException.getCode(), webException.getMsg());
        }
        return R.error(e.getMessage());
    }
}
