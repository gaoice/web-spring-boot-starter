package com.gaoice.web.advice;

import com.gaoice.web.exception.WebException;
import com.gaoice.web.r.R;
import lombok.extern.slf4j.Slf4j;

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
