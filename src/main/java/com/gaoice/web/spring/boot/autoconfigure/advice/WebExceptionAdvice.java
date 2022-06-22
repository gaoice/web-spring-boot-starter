package com.gaoice.web.spring.boot.autoconfigure.advice;

import com.gaoice.web.R;
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
