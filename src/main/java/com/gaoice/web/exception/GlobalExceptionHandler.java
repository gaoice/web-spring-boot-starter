package com.gaoice.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        if (ex instanceof WebException) {
            WebException webException = (WebException) ex;
            log.debug("[WebException, code:{}, msg:{}]", webException.getCode(), webException.getMessage());
            errorResponse.setCode(webException.getCode());
            errorResponse.setMessage(webException.getMessage());
        } else {
            log.error("[may be a unplanned exception]", ex);
            errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorResponse.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
