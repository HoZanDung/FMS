package com.cms.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by HOZANDUNG on 17/5/24.
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class MessageException extends RuntimeException {

    public MessageException() {
    }

    public MessageException(String message) {
        super(message);
    }
    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }
    public MessageException(Throwable cause) {
        super(cause);
    }
    protected MessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
