package com.example.myapplication.database;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import com.example.myapplication.database.model.CourseModel;
import com.example.myapplication.database.model.TermModel;

@Database(entities = {TermModel.class, CourseModel.class}, version 1)
public abstract class StudentDatabase extends RoomDatabase {
}
