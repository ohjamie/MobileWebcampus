package com.example.myapplication.C196PA;

// TODO: Do I need the termID id DAO is implemented?
// TODO: Create DataBase folder with DB JDBC

public class TermModel {
    int termId;
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
