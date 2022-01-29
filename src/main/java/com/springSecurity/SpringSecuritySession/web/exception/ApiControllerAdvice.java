package com.springSecurity.SpringSecuritySession.web.exception;

import com.springSecurity.SpringSecuritySession.web.exception.customException.LoginFailException;
import com.springSecurity.SpringSecuritySession.web.exception.customException.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler(LoginFailException.class)
    public ResponseEntity<String> loginFailException(LoginFailException e) {
        return new ResponseEntity<>("login fail! check email or password!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> accessDeniedException(UnauthorizedException e) {
        return new ResponseEntity<>("unauthorized access", HttpStatus.UNAUTHORIZED);
    }
}
