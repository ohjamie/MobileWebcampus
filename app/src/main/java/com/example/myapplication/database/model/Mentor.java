package com.example.myapplication.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mentor_table")
public class Mentor {

    @PrimaryKey(autoGenerate = true)
    int mentorId;
    String mentorName;
    String mentorPhone;
    String mentorEmail;

    public Mentor() {
        setMentorId(mentorId);
        setMentorName(mentorName);
        setMentorPhone(mentorPhone);
        setMentorEmail(mentorEmail);
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMentorPhone() {
        return mentorPhone;
    }

    public void setMentorPhone(String mentorPhone) {
        this.mentorPhone = mentorPhone;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }
}
