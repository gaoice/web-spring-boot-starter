package com.gaoice.web.advice;

import com.gaoice.web.exception.WebException;
import com.gaoice.web.r.RTime;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gaoice
 */
@Slf4j
public class WebExceptionRTimeAdvice implements WebExceptionAdvice {

    @Override
    public RTime<?> handleException(Exception e) {
        log.debug("controller exception: ", e);
        if (e instanceof WebException) {
            WebException webException = (WebException) e;
            return RTime.error(webException.getCode(), webException.getMsg());
        }
        return RTime.error(e.getMessage());
    }
}
