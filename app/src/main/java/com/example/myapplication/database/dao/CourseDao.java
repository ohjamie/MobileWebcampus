package com.example.myapplication.database.dao;

/** COURSES ARE SET VALUES AND CANNOT BE DELETED */
/** INITIALIZE SET COURSES IN STUDENT DB CLASS */
/** COURSES MUST BE ABLE TO BE A SUBTYPE OF A TERM INSTANCE */

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.myapplication.database.model.Course;
import java.util.List;

@Dao
public interface CourseDao {

    @Insert
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    @Query("SELECT * FROM course_table ORDER BY courseId ASC")
    LiveData<List<Course>> getAllCourses();
}
