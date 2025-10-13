package com.example.demo.config.auth.provider;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KakaoUserInfo implements OAuth2UserInfo {

    // 카카오 전용 속성
    private Long id;
    private LocalDateTime connected_at;
    private Map<String,Object> properties;
    private Map<String,Object> kakao_account;

    @Override
    String getName() {
        return (String)properties.get("nickname");
    }

    @Override
    String getEmail() {
        return (String)kakao_account.get("email");
    }

    @Override
    String getProvider() {
        return "Kakao";
    }

    @Override
    String getProviderId() {
        return id!=null ? id.toString() : "0";
    }

    @Override
    Map<String, Object> getAttributes() {
        return                                                         ;
    }
}
