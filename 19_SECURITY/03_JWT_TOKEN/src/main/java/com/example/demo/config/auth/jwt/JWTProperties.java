package com.example.demo.config.auth.jwt;

public class JWTProperties {

    public static final int ACCESS_TOKEN_EXPIRATION_TIME=1000*30;  //30초  millisecond
    public static final int REFRESH_TOKEN_EXPIRATION_TIME=1000*60*5; // 5분
    public static final String ACCESS_TOKEN_COOKIE_NAME="access-token";
    public static final String REFRESH_TOKEN_COOKIE_NAME="refresh-token";
}