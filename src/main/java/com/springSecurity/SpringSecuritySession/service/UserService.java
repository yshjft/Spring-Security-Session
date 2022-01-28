package com.springSecurity.SpringSecuritySession.service;

import com.springSecurity.SpringSecuritySession.domain.Authority.Authority;
import com.springSecurity.SpringSecuritySession.domain.Authority.AuthorityName;
import com.springSecurity.SpringSecuritySession.domain.User.User;
import com.springSecurity.SpringSecuritySession.domain.User.UserRepository;
import com.springSecurity.SpringSecuritySession.web.dto.user.SignUpReqDto;
import com.springSecurity.SpringSecuritySession.web.exception.customException.DuplicateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public String signUp(SignUpReqDto signUpReqDto) {
        if(userRepository.existsByEmail(signUpReqDto.getEmail())) {
            throw new DuplicateUser("duplicate user");
        }

        Set<Authority> authorities = new HashSet<>();
        for(AuthorityName authorityName : signUpReqDto.getAuthorities()) {
            authorities.add(
                    Authority.builder()
                    .authorityName(authorityName)
                    .build()
            );
        }

        User user = User.builder()
                .email(signUpReqDto.getEmail())
                .password(passwordEncoder.encode(signUpReqDto.getPassword()))
                .name(signUpReqDto.getName())
                .authorities(authorities)
                .build();

        userRepository.save(user);

        return "sign up success";
    }
}
