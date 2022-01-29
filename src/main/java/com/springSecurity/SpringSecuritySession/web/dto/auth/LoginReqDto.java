package com.springSecurity.SpringSecuritySession.web.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class LoginReqDto {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Builder
    public LoginReqDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
