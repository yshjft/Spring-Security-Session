package com.springSecurity.SpringSecuritySession.web.dto.user;

import com.springSecurity.SpringSecuritySession.domain.Authority.Authority;
import com.springSecurity.SpringSecuritySession.domain.Authority.AuthorityName;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class UserWithAuthoritiesResDto {
    private String email;
    private String name;
    private List<AuthorityName> authorities;

    @Builder
    public UserWithAuthoritiesResDto(String email, String name, List<AuthorityName> authorities) {
        this.email = email;
        this.name = name;
        this.authorities = authorities;
    }
}
