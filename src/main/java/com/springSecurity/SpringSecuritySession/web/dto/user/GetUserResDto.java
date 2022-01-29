package com.springSecurity.SpringSecuritySession.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetUserResDto {
    private String email;
    private String name;

    @Builder
    public GetUserResDto(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
