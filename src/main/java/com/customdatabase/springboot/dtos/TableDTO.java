package com.customdatabase.springboot.dtos;

import java.util.ArrayList;

public class TableDTO {
    private String db;
    private String table;
    private ArrayList<Object> records;


    public TableDTO(String db, String table) {
        this.db = db;
        this.table = table;
        this.records = new ArrayList<>();
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getTable() {
        return table;
    }

    public ArrayList<Object> getRecords() {
        return records;
    }
}
