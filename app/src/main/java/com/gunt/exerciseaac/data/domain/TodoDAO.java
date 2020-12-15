package com.gunt.exerciseaac.data.domain;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDAO {
    @Query("SELECT * FROM Todo")
    List<Todo> getAll();

    @Insert
    void insertAll(Todo... todos);

    @Insert
    void insert(Todo todo);

    @Update
    void update(Todo todo);

    @Delete
    void delete(Todo todo);
}
