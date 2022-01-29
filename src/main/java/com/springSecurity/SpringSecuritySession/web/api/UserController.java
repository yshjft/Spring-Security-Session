package com.springSecurity.SpringSecuritySession.web.api;

import com.springSecurity.SpringSecuritySession.service.UserService;
import com.springSecurity.SpringSecuritySession.web.dto.user.UserResDto;
import com.springSecurity.SpringSecuritySession.web.dto.user.SignUpReqDto;
import com.springSecurity.SpringSecuritySession.web.dto.user.UserWithAuthoritiesResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResDto> getUser() {
        UserResDto user = userService.getUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserWithAuthoritiesResDto>> getUsers() {
        List<UserWithAuthoritiesResDto> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Validated SignUpReqDto signUpReqDto) {
        String res = userService.signUp(signUpReqDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}
