package com.skygudanr.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

/*
    handlebars-spring-boot-starter 덕분에 path 와 뒤의 파일 확장자는 자동으로 지정됨
        ==> src/main/resources/templates/main.hbs로 자동 전환되되어 View Resolver가 처리
    ViewResolver
        ==> URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 격의 역할 수행
*/
}
