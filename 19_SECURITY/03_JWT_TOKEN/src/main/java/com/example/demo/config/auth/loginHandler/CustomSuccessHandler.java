package com.example.demo.config.auth.loginHandler;

import com.example.demo.config.auth.jwt.JWTProperties;
import com.example.demo.config.auth.jwt.JWTTokenProvider;
import com.example.demo.config.auth.jwt.TokenInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    JWTTokenProvider jwtTokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        //TOKEN 을 COOKIE로 전달
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
        Cookie cookie = new Cookie(JWTProperties.ACCESS_TOKEN_COOKIE_NAME,tokenInfo.getAccessToken());
        cookie.setMaxAge(JWTProperties.ACCESS_TOKEN_EXPIRATION_TIME);    //accesstoken 유지시간
        cookie.setPath("/");    //쿠키 적용경로(/ : 모든경로)
        response.addCookie(cookie); //응답정보에 쿠키 포함


        log.info("CustomSuccessHandler's onAuthenticationSuccess invoke...genToken.."+tokenInfo);




        //Role 별로 redirect 경로 수정
        String redirectUrl = "/";
//        for(GrantedAuthority authority : authentication.getAuthorities())
//        {
//            log.info("authority : " + authority);
//            String role = authority.getAuthority(); //String
//
//            if(role.contains("ROLE_ADMIN")){
//                // /admin 리다이렉트
//                redirectUrl = "/admin";
//                break;
//            }else if(role.contains("ROLE_MANAGER")){
//                // /manager 리다이렉트
//                redirectUrl = "/manager";
//                break;
//            }else{
//                // /user 리다이렉트
//                redirectUrl = "/user";
//                break;
//            }
//
//        }
        response.sendRedirect(redirectUrl);

    }
}