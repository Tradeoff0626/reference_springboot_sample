package com.example.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                     // REST API를 처리하는 컨트롤러 선언.
@RequestMapping("/api")             // RequestMapping URI를 지정. (모든 Method 허용)
public class ApiController {

    @GetMapping("/hello")           // '/api/hello'를 Get Method로 매핑
    public String hello(){
        return "Hello Spring Boot!!!";
    }
}
