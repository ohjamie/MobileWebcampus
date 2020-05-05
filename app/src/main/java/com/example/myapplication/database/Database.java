package com.example.myapplication.database;

import androidx.room.RoomDatabase;

import com.example.myapplication.database.model.CourseModel;
import com.example.myapplication.database.model.TermModel;

@androidx.room.Database(entities = {TermModel.class, CourseModel.class}, version 1)
public abstract class Database extends RoomDatabase {
}
