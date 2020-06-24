package com.example.myapplication.database.dao;

/** MENTORS ARE SET VALUES AND CANNOT BE DELETED */
/** ADD SET MENTORS IN DB CLASS*/

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.database.model.Mentor;

import java.util.List;

@Dao
public interface MentorDao {

    @Insert
    void insert(Mentor mentor);

    @Update
    void update(Mentor mentor);

    @Delete
    void delete(Mentor mentor);

    @Query("DELETE FROM mentor_table")
    void deleteAllMentors();

    @Query("SELECT * FROM mentor_table ORDER BY mentorId ASC")
    LiveData<List<Mentor>> getAllMentors();

}
