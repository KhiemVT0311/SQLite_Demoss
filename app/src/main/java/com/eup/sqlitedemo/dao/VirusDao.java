package com.eup.sqlitedemo.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.eup.sqlitedemo.model.Virus;

import java.util.List;

@Dao
public interface VirusDao {
    @Query("SELECT * FROM Virus")
    List<Virus> getAll();

    @Query("SELECT * FROM Virus WHERE name like :name")
    List<Virus> getStudent(String name);

    @Insert
    void insert(Virus ... virus);

    @Update
    void update(Virus ... virus);

    @Delete
    void delete(Virus ... virus);
}