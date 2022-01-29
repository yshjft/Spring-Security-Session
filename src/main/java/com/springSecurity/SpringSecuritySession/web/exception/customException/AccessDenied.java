package com.springSecurity.SpringSecuritySession.web.exception.customException;

public class AccessDenied extends RuntimeException{
    public AccessDenied() {
        super();
    }

    public AccessDenied(String message) {
        super(message);
    }

    public AccessDenied(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDenied(Throwable cause) {
        super(cause);
    }

    protected AccessDenied(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
