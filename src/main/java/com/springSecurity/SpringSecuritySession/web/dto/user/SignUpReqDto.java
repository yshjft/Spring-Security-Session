package com.springSecurity.SpringSecuritySession.web.dto.user;

import com.springSecurity.SpringSecuritySession.annotation.Authorities;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SignUpReqDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min=4, max=20)
    private String password;

    @NotBlank
    private String name;

    @Authorities
    private String[] authorities;

    @Builder
    public SignUpReqDto(String email, String password, String name, String[] authorities) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.authorities = authorities;
    }
}
