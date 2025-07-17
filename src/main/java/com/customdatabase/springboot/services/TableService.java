package com.customdatabase.springboot.services;

import com.customdatabase.springboot.dtos.DatabaseDTO;
import com.customdatabase.springboot.dtos.TableDTO;
import com.customdatabase.springboot.entities.DbEntity;
import com.customdatabase.springboot.repositories.DbRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
        database.getTables().put(table, new TableDTO(db, table));
        String jsondb = objectMapper.writeValueAsString(database);
        dbEntity.setDatabase(jsondb);
        dbRepository.save(dbEntity);
        return "Table Added";
    }


    public String deleteTable(String db, String tableName) throws JsonProcessingException {
        DbEntity dbEntity = dbRepository.findByDbName(db);
        DatabaseDTO database = objectMapper.readValue(dbEntity.getDatabase(), DatabaseDTO.class);
        TableDTO table = database.getTables().get(tableName);
        if (table == null) {
                  return "Table not exist";
        }
        database.getTables().remove(tableName);
        String jsONDB = objectMapper.writeValueAsString(database);
        dbEntity.setDatabase(jsONDB);
        dbRepository.save(dbEntity);
        return jsONDB;
    }

    public HashMap<String, TableDTO> getTables(String db) throws JsonProcessingException {
        DbEntity dbEntity = dbRepository.findByDbName(db);
        return objectMapper.readValue(dbEntity.getDatabase(), DatabaseDTO.class).getTables();
    }
}

