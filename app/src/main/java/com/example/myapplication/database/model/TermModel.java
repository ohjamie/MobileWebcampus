package com.example.myapplication.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "terms")
public class TermModel {

    @PrimaryKey(autoGenerate = true)
    int termId;

    public String termTitle;

    public TermModel() {
        setTermId(termId);
        setTitle(termTitle);
    }

    public int getTermId() {
        return termId;
    }
    public String getTitle() {
        return termTitle;
    }
    public void setTermId(int termId) {
        this.termId = termId;
    }
    public void setTitle(String termTitle) {
        this.termTitle = termTitle;
    }
}
