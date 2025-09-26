package com.example.demo.Controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

    @InitBinder
    public void dataBinder(WebDataBinder webDataBinder){
        log.info("MemoControlller's dataBinder...." + webDataBinder);
        webDataBinder.registerCustomEditor(LocalDate.class,"data_test", new DataTestEditor());
    }

    private static class DataTestEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            log.info("DataTestEditor's setAsText text : " + text);
            LocalDate date = null;
            if(text.isEmpty()) {
                date = LocalDate.now();
            } else {
                // format 확인(yyyy#MM#dd)
                text = text.replaceAll("#","-");
                date = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyy-MM-dd"));
            }
        }
    }

    @GetMapping("/add")
    public void add_memo_get(){
        log.info("GET /memo/add...");
    }
    @PostMapping("/add")
    public void add_memo_post(@Valid MemoDto dto, BindingResult bindingResult, Model model){
        log.info("POST /memo/add..."+dto);
        // 파라미터
        // 입력값검증(데이터)
        log.info("유효성 오류 발생여부 : " + bindingResult.hasErrors());
        if(bindingResult.hasErrors()) {
            for(FieldError error : bindingResult.getFieldErrors()){
                log.info("Error Field : " + error.getField() + "Error Message : " + error.getDefaultMessage());
                model.addAttribute(error.getField(),error.getDefaultMessage());
            }
        }
        // 서비스 요청 -> Domain.Common.Service
        // 뷰로 이동
    }
}
