package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public  String helloMvc(@RequestParam(name="name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("/hello-string")
    @ResponseBody //    http 통신 프로토콜의 body에 return값을 넣겠다.
    public String helloString(@RequestParam(name="name") String name){
        return "hello " + name;
//        템플릿 엔진과의 차이점은 return값 그대로 내려간다
    }

//    API 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(name="name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
