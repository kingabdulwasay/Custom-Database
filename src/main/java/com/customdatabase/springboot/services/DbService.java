package com.customdatabase.springboot.services;

import com.customdatabase.springboot.entities.DbEntity;
import com.customdatabase.springboot.repositories.DbRepository;
import com.customdatabase.springboot.dtos.DatabaseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class DbService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DbRepository dbRepository;

    public DatabaseDTO addDatabase(DatabaseDTO databaseDTO) throws JsonProcessingException{
       String db = objectMapper.writeValueAsString(databaseDTO);
       DbEntity entity = dbRepository.save(new DbEntity(databaseDTO.getUsername(), databaseDTO.getDbName(), db));
       return objectMapper.readValue(entity.database, DatabaseDTO.class);
    }
    public DatabaseDTO[] getDatabases(String owner) throws JsonProcessingException{
        DbEntity[] entity = dbRepository.findByUsername(owner);
        return Arrays.stream(entity)
                .map(e-> {
                    try {
                        return objectMapper.readValue(e.getDatabase(), DatabaseDTO.class);
                    } catch (JsonProcessingException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .toArray(DatabaseDTO[]::new);
    }


    public DatabaseDTO getDatabase(String db) throws JsonProcessingException {
        DbEntity dbEntity = dbRepository.findByDbName(db);
        return objectMapper.readValue(dbEntity.getDatabase(), DatabaseDTO.class);
    }

    public String deleteDatabase(String db) {
        DbEntity dbEntity = dbRepository.findByDbName(db);
        dbRepository.delete(dbEntity);
        return "DB DELETED";
    }

    public List<DatabaseDTO> getAllDatabases() {
        List<DbEntity> dbEntities = dbRepository.findAll();
      return  dbEntities.stream().map(db -> {
            try {
                return objectMapper.readValue(db.getDatabase(), DatabaseDTO.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
