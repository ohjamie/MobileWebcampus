package com.example.myapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.database.dao.TermDao;
import com.example.myapplication.database.model.TermModel;

@Database(entities = {TermModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract TermDao termDao();
}
