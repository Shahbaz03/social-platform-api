package com.social.platform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPostException extends RuntimeException {
    public InvalidPostException(String cause) {
        super(cause);
    }
}
