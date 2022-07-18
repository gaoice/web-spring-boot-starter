package com.gaoice.web.advice;

import com.gaoice.web.r.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author gaoice
 */
@RestControllerAdvice
public interface WebExceptionAdvice {

    @ExceptionHandler
    R<?> handleException(Exception e);
}
