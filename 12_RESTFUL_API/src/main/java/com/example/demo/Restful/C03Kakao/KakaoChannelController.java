package com.example.demo.Restful.C03Kakao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/kakao")
public class KakaoChannelController {
    @GetMapping("/channel")
    public void channel(){
        log.info("GET /kakao/channel....");
    }
}
