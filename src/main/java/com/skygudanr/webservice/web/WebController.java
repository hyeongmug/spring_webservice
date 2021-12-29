package com.skygudanr.webservice.web;

import com.skygudanr.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @GetMapping("/test")
    @ResponseBody
    public Map<String, String> test() {
        Map<String, String> testMap = new HashMap<>();
        return testMap;
    }

/*
    handlebars-spring-boot-starter 덕분에 path 와 뒤의 파일 확장자는 자동으로 지정됨
        ==> src/main/resources/templates/main.hbs로 자동 전환되되어 View Resolver가 처리
    ViewResolver
        ==> URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 격의 역할 수행
*/
}
