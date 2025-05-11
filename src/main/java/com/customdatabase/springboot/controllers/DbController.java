package com.customdatabase.springboot.controllers;


import com.customdatabase.springboot.dtos.DatabaseDTO;
import com.customdatabase.springboot.entities.DbEntity;
import com.customdatabase.springboot.services.DbService;
import com.customdatabase.springboot.dtos.TableDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class DbController<T>{


    @Autowired
    private DbService dbService;


    @PostMapping("/add/db")
    public DatabaseDTO addDatabase(@RequestBody DatabaseDTO database) throws JsonProcessingException{
      return  dbService.addDatabase(database);
    }
    @GetMapping("/get/{db}")
    public DatabaseDTO addDatabase(@PathVariable("db") String database) throws JsonProcessingException{
        return  dbService.getDatabase(database);
    }

}
