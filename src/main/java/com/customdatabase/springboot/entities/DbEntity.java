package com.customdatabase.springboot.entities;

import com.customdatabase.springboot.dtos.TableDTO;
import jakarta.persistence.*;


@Entity
public class DbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String getDbName() {
        return dbName;
    }

    private String dbName;
    @Lob
    public String database;

    public DbEntity() {

    }
    public DbEntity(String dbName, String database) {
        this.dbName = dbName;
        this.database = database;
    }

    public Long getId() {
        return id;
    }

    public String getDatabase() {
        return database;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
