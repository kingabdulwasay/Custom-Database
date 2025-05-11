package com.customdatabase.springboot.repositories;

import com.customdatabase.springboot.entities.DbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbRepository extends JpaRepository<DbEntity, Long> {
    DbEntity findByDbName(String dbName);
}
