package com.springSecurity.SpringSecuritySession.web.api;

import com.springSecurity.SpringSecuritySession.web.exception.customException.UnauthorizedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exception")
public class ExceptionController {
    @GetMapping("/unauthorized")
    public void unAuthorizedException() {
        throw new UnauthorizedException();
    }
}
