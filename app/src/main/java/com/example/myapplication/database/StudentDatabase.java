package com.example.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.database.dao.TermDao;
import com.example.myapplication.database.model.TermModel;

@Database(entities = {TermModel.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase instance;

    public abstract TermDao termDao();

    public static synchronized StudentDatabase getInstance(Context c) {
        if(instance ==null) {
            instance = Room.databaseBuilder(c.getApplicationContext(),
                    StudentDatabase.class, "StudentDB")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
