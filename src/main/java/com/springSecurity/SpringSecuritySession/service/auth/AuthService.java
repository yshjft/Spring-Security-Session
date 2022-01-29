package com.springSecurity.SpringSecuritySession.service.auth;

import com.springSecurity.SpringSecuritySession.SessionUtil;
import com.springSecurity.SpringSecuritySession.web.dto.auth.LoginReqDto;
import com.springSecurity.SpringSecuritySession.web.exception.customException.LoginFailException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public String login(LoginReqDto loginReqDto) {
        try{
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginReqDto.getEmail(), loginReqDto.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return "login success";
        }catch (Exception e) {
            throw new LoginFailException();
        }
    }

    public String logout() {
        HttpSession session = SessionUtil.getSession();
        if(session != null) {
            session.invalidate();
        }

        return "logout success";
    }
}
