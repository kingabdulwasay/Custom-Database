package com.customdatabase.springboot.dtos;

import jakarta.persistence.Table;

import java.util.ArrayList;

public class TableDTO {
    private String table;
    private ArrayList<Object> records;


    public TableDTO(String table) {
        this.table = table;
        this.records = new ArrayList<>();
    }


    public String getTable() {
        return table;
    }

    public ArrayList<Object> getRecords() {
        return records;
    }
}
