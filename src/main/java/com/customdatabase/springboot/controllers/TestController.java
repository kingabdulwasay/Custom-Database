package com.customdatabase.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(path = "/protected")
    public String protectedRoute(){
        return "Protected route";
    }


}
