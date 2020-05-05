package com.example.myapplication.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.myapplication.database.model.TermModel;

import java.util.List;

@Dao
public interface TermDao {
    @Insert
    void insert(TermModel term);

    @Update
    void update(TermModel term);

    @Delete
    void delete(TermModel term);

    @Query("SELECT * FROM terms ORDER BY termId ASC")
    LiveData<List<TermModel>> getAllTerms();
}