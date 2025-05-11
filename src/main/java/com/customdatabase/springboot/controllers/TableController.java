package com.customdatabase.springboot.controllers;

import com.customdatabase.springboot.dtos.TableDTO;
import com.customdatabase.springboot.services.DbService;
import com.customdatabase.springboot.services.TableService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping(path = "/table")
public class TableController {
    @Autowired
    private TableService tableService;
    @PostMapping(path = "/add/{db}")
    public String addTable(@PathVariable("db") String database, @RequestBody TableDTO tableDTO) throws JsonProcessingException {
        return tableService.addTables(database, tableDTO.getTable());
    }

}
