package com.customdatabase.springboot.services;

import com.customdatabase.springboot.entities.DbEntity;
import com.customdatabase.springboot.repositories.DbRepository;
import com.customdatabase.springboot.dtos.DatabaseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DbService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DbRepository dbRepository;

    public DatabaseDTO addDatabase(DatabaseDTO databaseDTO) throws JsonProcessingException{
       String db = objectMapper.writeValueAsString(databaseDTO);
       DbEntity entity = dbRepository.save(new DbEntity(databaseDTO.getDbName(), db));
       return objectMapper.readValue(entity.database, DatabaseDTO.class);
    }

    public DatabaseDTO getDatabase(String db) throws JsonProcessingException{
        DbEntity entity = dbRepository.findByDbName(db);
        return objectMapper.readValue(entity.database, DatabaseDTO.class);
    }
}
