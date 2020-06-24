package com.example.myapplication.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class Course {

/**    enum Status {
        ENROLLED, // assigned to term
        UNENROLLED, // unassigned to any term
        INPROGRESS // assigned to term and started
    }

    enum Assessment {
        PREASSESSMENT,
        POSTASSESSMENT,
        OBJECTIVE,
        PERFORMANCE
    }*/

    @PrimaryKey(autoGenerate = true)
    int courseId;
    public int courseTermId;
    public int courseMentorId;
    public String courseName;
    public String start;
    public String end;
    public String status;
    public String assessment;

    public Course() {
        setCourseId(courseId);
        setCourseTermId(courseTermId);
        setCourseMentorId(courseMentorId);
        setCourseName(courseName);
        setStart(start);
        setEnd(end);
        setStatus(status);
        setAssessment(assessment);
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseTermId() {
        return courseTermId;
    }

    public void setCourseTermId(int courseTermId) {
        this.courseTermId = courseTermId;
    }

    public int getCourseMentorId() {
        return courseMentorId;
    }

    public void setCourseMentorId(int courseMentorId) {
        this.courseMentorId = courseMentorId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }
}
