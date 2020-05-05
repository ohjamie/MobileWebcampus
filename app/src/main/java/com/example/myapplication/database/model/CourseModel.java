package com.example.myapplication.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "courses")
public class CourseModel {

    @PrimaryKey (autoGenerate = true)
    int courseId;

    String courseTitle;

    public CourseModel() {
        setCourseId(courseId);
        setCourseTitle(courseTitle);
    }

    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseTitle() {
        return courseTitle;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

}
