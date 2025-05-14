package com.customdatabase.springboot.services;

import com.customdatabase.springboot.dtos.DatabaseDTO;
import com.customdatabase.springboot.dtos.TableDTO;
import com.customdatabase.springboot.entities.DbEntity;
import com.customdatabase.springboot.repositories.DbRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {
    @Autowired
    private DbRepository dbRepository;
    @Autowired
    private DbService dbService;
    @Autowired
    private ObjectMapper objectMapper;

    public String addTables(String db, String table) throws JsonProcessingException {
        DbEntity dbEntity = dbRepository.findByDbName(db);
        DatabaseDTO database = objectMapper.readValue(dbEntity.getDatabase(), DatabaseDTO.class);
        database.getTables().put(table, new TableDTO(table));
        String jsondb = objectMapper.writeValueAsString(database);
        dbEntity.setDatabase(jsondb);
        dbRepository.save(dbEntity);
        return "Table Added";
    }



}

