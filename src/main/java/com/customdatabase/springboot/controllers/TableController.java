package com.customdatabase.springboot.controllers;

import com.customdatabase.springboot.dtos.TableDTO;
import com.customdatabase.springboot.services.DbService;
import com.customdatabase.springboot.services.TableService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/table")
public class TableController {
    @Autowired
    private TableService tableService;
    @PostMapping(path = "/add")
    public String addTable(@RequestBody TableDTO tableDTO) throws JsonProcessingException {
        return tableService.addTables(tableDTO.getDb(), tableDTO.getTable());
    }

    @GetMapping(path = "/get/{db}")
    public HashMap<String, TableDTO> getTables(@PathVariable("db") String db) throws JsonProcessingException {
        return tableService.getTables(db);
    }

    @DeleteMapping(path = "/delete/{db}/{table}")
    public String deleteTable(@PathVariable("db") String db, @PathVariable("table") String table) throws JsonProcessingException {
        return tableService.deleteTable(db, table);
    }

}
