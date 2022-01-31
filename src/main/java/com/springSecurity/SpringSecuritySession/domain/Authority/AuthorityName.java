package com.springSecurity.SpringSecuritySession.domain.Authority;


public enum AuthorityName {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    String value;

    AuthorityName(String value) {
        this.value = value;
    }
}
