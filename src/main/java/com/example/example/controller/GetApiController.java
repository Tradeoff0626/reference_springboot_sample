package com.example.example.controller;

import com.example.example.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "hello")     // 'path'는 default param이므로 생략 가능. [ @GetMapping("hello") ]
    public String hello(){
        return "get hello";
    }

    // '@RequestMapping'의 'method'를 지정한 것과 '@GetMapping'는 같음.
    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    // Path로 변수를 받는 방법.
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){  // '@PathVariable'
        return name;
    }
    /*
        public String pathVariable(@PathVariable(name = "name") String pathName)  // name을 pathName으로 변경 가능
    * */

    // K-V 형태로 제한 없이 파라미터 받기 (지정한 파라미터만 받기 힘든 단점있음)
    @GetMapping(path = "query-param01")
    public String queryParam01(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        /*
        queryParam.entrySet().forEach( entry -> {
            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });
        */

        queryParam.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
            System.out.println("\n");

            sb.append(key).append(" = ").append(value).append("\n");
        });

        return sb.toString();
    }

    // 명시적으로 파라미터 지정하여 받기(유동적으로 파라미터 받아 처리 하김 힘든 단점이 있음 - 파라미터 추가 시 내부도 수정 필요)
    @GetMapping(path = "query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " , " + email + " , " + age + "\n";
    }


    // DTO를 이용한 방법 (위 2가지 단점 해결을 해결한 적정한 방법)
    @GetMapping(path = "query-param")
    public String queryParam(UserRequest userRequest){  // (*)'@RequestParam' 사용 X
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }


}
