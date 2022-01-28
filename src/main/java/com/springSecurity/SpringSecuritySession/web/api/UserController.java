package com.springSecurity.SpringSecuritySession.web.api;

import com.springSecurity.SpringSecuritySession.service.UserService;
import com.springSecurity.SpringSecuritySession.web.dto.user.SignUpReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("test", HttpStatus.CREATED);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Validated SignUpReqDto signUpReqDto) {
        String res = userService.signUp(signUpReqDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
