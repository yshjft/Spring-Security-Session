package com.springSecurity.SpringSecuritySession.service;

import com.springSecurity.SpringSecuritySession.domain.Authority.Authority;
import com.springSecurity.SpringSecuritySession.domain.Authority.AuthorityName;
import com.springSecurity.SpringSecuritySession.domain.User.User;
import com.springSecurity.SpringSecuritySession.domain.User.UserRepository;
import com.springSecurity.SpringSecuritySession.service.auth.CustomUserDetails;
import com.springSecurity.SpringSecuritySession.web.dto.user.UserResDto;
import com.springSecurity.SpringSecuritySession.web.dto.user.SignUpReqDto;
import com.springSecurity.SpringSecuritySession.web.dto.user.UserWithAuthoritiesResDto;
import com.springSecurity.SpringSecuritySession.web.exception.customException.DuplicateUserException;
import com.springSecurity.SpringSecuritySession.web.exception.customException.NoUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public String signUp(SignUpReqDto signUpReqDto) {
        if(userRepository.existsByEmail(signUpReqDto.getEmail())) {
            throw new DuplicateUserException("duplicate user");
        }

        Set<Authority> authorities = new HashSet<>();
        for(String authorityStr : signUpReqDto.getAuthorities()) {
            switch(authorityStr) {
                case "ROLE_USER":
                    authorities.add(new Authority(AuthorityName.ROLE_USER));
                    break;
                case "ROLE_ADMIN":
                    authorities.add(new Authority(AuthorityName.ROLE_ADMIN));
                    break;
                default:
                    break;
            }
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

    @Transactional(readOnly = true)
    public UserResDto getUser() {
        CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = userDetails.getId();

        User user = userRepository.findById(id).orElseThrow(()-> new NoUserException());

        return UserResDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }

    @Transactional(readOnly = true)
    public List<UserWithAuthoritiesResDto> getUsers() {
        List<UserWithAuthoritiesResDto> UserWithAuthoritiesResDtoList = userRepository.findUserWithAuthorities().stream()
                .map(user ->
                        UserWithAuthoritiesResDto.builder()
                                .email(user.getEmail())
                                .name(user.getName())
                                .authorities(
                                        user.getAuthorities().stream().map(authority -> authority.getAuthorityName()).collect(Collectors.toList())
                                )
                                .build()
                )
                .collect(Collectors.toList());

        return UserWithAuthoritiesResDtoList;
    }
}
