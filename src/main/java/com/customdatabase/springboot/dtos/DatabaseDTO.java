package com.customdatabase.springboot.dtos;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseDTO {
    private String username;
    private String dbName;

    private HashMap<String,TableDTO> tables;

    public DatabaseDTO(String username, String dbName) {
        this.username  = username;
        this.dbName = dbName;
        tables = new HashMap<>();
    }


    public String getDbName() {
        return dbName;
    }


    public String getUsername() {
        return username;
    }

    public HashMap<String, TableDTO> getTables() {
        return tables;
    }


}
