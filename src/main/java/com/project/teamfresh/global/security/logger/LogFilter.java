package com.project.teamfresh.global.security.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Slf4j
public class LogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();

        log.info(
                "Client <" + getRemoteAddress(request)
                        + "> Request to [" + request.getMethod()
                        + "] " + request.getRequestURL()
                        + " with Header Names : " + getHeaders(request)
        );
        filterChain.doFilter(request, response);
    }

    private String getRemoteAddress(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-FORWARDED-FOR");
        return remoteAddr == null ? request.getRemoteAddr() : remoteAddr;
    }

    private String getHeaders(HttpServletRequest request) {
        return Collections.list(request.getHeaderNames()).toString();
    }

}