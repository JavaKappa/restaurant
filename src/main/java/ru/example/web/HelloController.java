package ru.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

//@Controller
public class HelloController {
    @RequestMapping("/")

    public String printWelcone(HttpServletRequest request) {
        
        request.setAttribute("hello", "Hello this is SPRING WEBMVC application");

        return "index";
    }
}
