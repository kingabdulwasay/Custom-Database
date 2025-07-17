package com.customdatabase.springboot.controllers;

import com.customdatabase.springboot.dtos.UserDTO;
import com.customdatabase.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/add")
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @GetMapping(path = "/get/{username}")
    public UserDTO getUser(@PathVariable("username") String username){
        return userService.getUser(username);
    }

}
