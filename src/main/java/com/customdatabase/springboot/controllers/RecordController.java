package com.customdatabase.springboot.controllers;

import com.customdatabase.springboot.dtos.DatabaseDTO;
import com.customdatabase.springboot.dtos.RecordDTO;
import com.customdatabase.springboot.services.DbService;
import com.customdatabase.springboot.services.RecordService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/record")
public class RecordController {

    @Autowired
    private RecordService recordService;
    @PostMapping(path = "/add")
    public String addData(@RequestBody RecordDTO recordDTO)throws JsonProcessingException {
        return recordService.addRecord(recordDTO);
    }
    @GetMapping(path = "/get/{db}/{table}")
    public ArrayList<Object> getRecord(@PathVariable("db") String db, @PathVariable("table") String table) throws JsonProcessingException {
        return recordService.getRecord(db, table);
    }

}
