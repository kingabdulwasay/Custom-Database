package com.customdatabase.springboot.controllers;


import com.customdatabase.springboot.dtos.DatabaseDTO;
import com.customdatabase.springboot.entities.DbEntity;
import com.customdatabase.springboot.services.DbService;
import com.customdatabase.springboot.dtos.TableDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/db")
public class DbController{

    @Autowired
    private DbService dbService;


    @PostMapping("/add")
    public DatabaseDTO addDatabase(@RequestBody DatabaseDTO database) throws JsonProcessingException{
      return  dbService.addDatabase(database);
    }
    @GetMapping("/getofowner/{owner}")
    public DatabaseDTO[] getDatabases(@PathVariable("owner") String owner) throws JsonProcessingException{
        return  dbService.getDatabases(owner);
    }
    @GetMapping("/get/{db}")
    public DatabaseDTO getDatabase(@PathVariable("db") String db) throws JsonProcessingException{
        return  dbService.getDatabase(db);
    }
    @GetMapping("/getAll")
    public List<DatabaseDTO> getAllDatabases(){
        return dbService.getAllDatabases();
    }
    @DeleteMapping("/delete/{db}")
    public String deleteDatabase(@PathVariable("db") String db) throws JsonProcessingException{
        return  dbService.deleteDatabase(db);
    }
}
