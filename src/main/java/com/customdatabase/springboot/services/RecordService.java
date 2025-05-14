package com.customdatabase.springboot.services;

import com.customdatabase.springboot.dtos.DatabaseDTO;
import com.customdatabase.springboot.entities.DbEntity;
import com.customdatabase.springboot.repositories.DbRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    @Autowired
    private DbRepository dbRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public String addRecord(String db, String table, Object data)throws JsonProcessingException {
        DbEntity dbEntity = dbRepository.findByDbName(db);
        DatabaseDTO database = objectMapper.readValue(dbEntity.getDatabase(), DatabaseDTO.class);
         database.getTables().get(table).getRecords().add(data);
        String jsonDB = objectMapper.writeValueAsString(database);
        dbEntity.setDatabase(jsonDB);
        dbRepository.save(dbEntity);
        return jsonDB;
    }
}
