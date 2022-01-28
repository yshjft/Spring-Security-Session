package com.springSecurity.SpringSecuritySession.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    public static final String LOG_ID="LOG_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uuid = UUID.randomUUID().toString();
        request.setAttribute(LOG_ID, uuid);

        String uri = request.getRequestURI();
        String method = request.getMethod();

        log.info("[ID: {}] REQUEST {} {}", uuid, method, uri);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uuid = request.getAttribute(LOG_ID).toString();
        String uri = request.getRequestURI();
        String method = request.getMethod();

        log.info("[ID: {}] RESPONSE {} {}", uuid, method, uri);

        if(ex != null) {
            log.error("[ERROR] = {}", ex.getMessage());
        }
    }
}
