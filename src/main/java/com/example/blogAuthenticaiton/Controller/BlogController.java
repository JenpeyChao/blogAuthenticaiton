package com.example.blogAuthenticaiton.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BlogController {
    @GetMapping("/")
    public String goH0me(){
        return "This is publicly accessible withing needing authentication ";
    }
}
