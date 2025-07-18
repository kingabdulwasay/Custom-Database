package com.customdatabase.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller {
  @GetMapping(path = "/test")
    public String test(){
      return "SITE IS LIVE";
  }
}
