package com.springSecurity.SpringSecuritySession.web.exception.customException;

public class DuplicateUser extends RuntimeException{
    public DuplicateUser() {
    }

    public DuplicateUser(String message) {
        super(message);
    }

    public DuplicateUser(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateUser(Throwable cause) {
        super(cause);
    }

    public DuplicateUser(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
