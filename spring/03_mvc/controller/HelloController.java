package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.model.User;

/**
 * Spring MVC控制器示例
 */
@Controller
public class HelloController {
    
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "hello";  // 返回视图名
    }
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @GetMapping("/api/hello")
    @ResponseBody
    public String helloApi() {
        return "Hello, REST API!";
    }
    
    @GetMapping("/user/form")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }
    
    @PostMapping("/user/submit")
    public String userSubmit(User user, Model model) {
        model.addAttribute("user", user);
        return "userResult";
    }
} 