package com.example.myapplication.C196PA;

// TODO: Do I need the termID id DAO is implemented?
// TODO: Create DataBase folder with DB JDBC

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TermModel {
    @PrimaryKey
    int termId;

    @ColumnInfo(name = "termTitle")
    String title;

    public TermModel() {
        setTermId(termId);
        setTitle(title);
    }

    public int getTermId() {
        return termId;
    }
    public String getTitle() {
        return title;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
