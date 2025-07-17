package com.customdatabase.springboot.dtos;

public class RecordDTO{

    private String db;
    private String table;
    private Object data;

    public RecordDTO(String db, String table, Object data) {
        this.db = db;
        this.table = table;
        this.data = data;
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

    public void setTable(String table) {
        this.table = table;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
