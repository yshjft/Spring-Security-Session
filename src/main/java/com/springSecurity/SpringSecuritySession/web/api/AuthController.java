package com.springSecurity.SpringSecuritySession.web.api;

import com.springSecurity.SpringSecuritySession.service.auth.AuthService;
import com.springSecurity.SpringSecuritySession.web.dto.auth.LoginReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Validated LoginReqDto loginReqDto) {
        String msg = authService.login(loginReqDto);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        String msg = authService.logout();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
