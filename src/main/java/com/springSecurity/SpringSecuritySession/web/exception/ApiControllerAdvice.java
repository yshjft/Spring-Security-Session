package com.springSecurity.SpringSecuritySession.web.exception;

import com.springSecurity.SpringSecuritySession.SessionUtil;
import com.springSecurity.SpringSecuritySession.web.exception.customException.AccessDenied;
import com.springSecurity.SpringSecuritySession.web.exception.customException.LoginFailException;
import com.springSecurity.SpringSecuritySession.web.exception.customException.NoUserException;
import com.springSecurity.SpringSecuritySession.web.exception.customException.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpSession;

@RestControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler(LoginFailException.class)
    public ResponseEntity<String> loginFailException(LoginFailException e) {
        return new ResponseEntity<>("login fail! check email or password!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> unAuthorizedException(UnauthorizedException e) {
        return new ResponseEntity<>("unauthorized access", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDenied.class)
    public ResponseEntity<String> accessDeniedException() {
        return new ResponseEntity<>("access denied", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NoUserException.class)
    public ResponseEntity<String> noUserException(NoUserException e) {
        HttpSession session = SessionUtil.getSession();
        if(session != null) {
            session.invalidate();
        }

        return new ResponseEntity<>("can't find user", HttpStatus.NOT_FOUND);
    }
}
