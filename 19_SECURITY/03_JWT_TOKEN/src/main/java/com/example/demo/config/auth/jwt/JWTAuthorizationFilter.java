package com.example.demo.config.auth.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //전
        //access-token 쿠키 받아 Authentication 생성이후 SecurityContextHolder에 저장
        System.out.println("[JWTAuthorizationFilter] doFilterInternal ...");
        filterChain.doFilter(request,response);

        //후

    }
}