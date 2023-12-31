package com.example.mvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("home")
    public String home() {
        return "demo/demohome";
    }

    @RequestMapping("profile")
    public String profile() {
        return "demo/profile";
    }

    @RequestMapping("blog")
    public String blog() {
        return "demo/blog";
    }
}
