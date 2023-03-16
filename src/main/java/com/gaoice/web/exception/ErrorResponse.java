package com.gaoice.web.exception;

import lombok.Data;

@Data
public class ErrorResponse {

    private int code;

    private String message;

}
