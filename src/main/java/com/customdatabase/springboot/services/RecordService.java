package com.customdatabase.springboot.services;

import com.customdatabase.springboot.dtos.DatabaseDTO;
import com.customdatabase.springboot.dtos.RecordDTO;
import com.customdatabase.springboot.dtos.TableDTO;
import com.customdatabase.springboot.entities.DbEntity;
import com.customdatabase.springboot.repositories.DbRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecordService {

    @Autowired
    private DbRepository dbRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public String addRecord(RecordDTO recordDTO)throws JsonProcessingException {
        DbEntity dbEntity = dbRepository.findByDbName(recordDTO.getDb());
        DatabaseDTO database = objectMapper.readValue(dbEntity.getDatabase(), DatabaseDTO.class);
         database.getTables().get(recordDTO.getTable()).getRecords().add(recordDTO.getData());
        String jsonDB = objectMapper.writeValueAsString(database);
        dbEntity.setDatabase(jsonDB);
        dbRepository.save(dbEntity);
        return jsonDB;
    }

    public ArrayList<Object> getRecord(String db, String tableName) throws JsonProcessingException {
        DbEntity dbEntity = dbRepository.findByDbName(db);
        DatabaseDTO database = objectMapper.readValue(dbEntity.getDatabase(), DatabaseDTO.class);
        TableDTO table = database.getTables().get(tableName);
        if (table == null) {
            return null;
        }
        return table.getRecords();
    }


}
