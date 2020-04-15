package com.example.c196pa;
import java.time.LocalDateTime;

// TODO: Do I need the termID id DAO is implemented?

public class Term {
    // long termId;
    String title;
    LocalDateTime startDate;
    LocalDateTime endDate;
    int current;

    public Term() {
        // setTermId(termId);
        setTitle(title);
        setStartDate(startDate);
        setEndDate(endDate);
        setCurrent(current);
    }

    /**public long getTermId() {
        return termId;
    }*/
    public String getTitle() {
        return title;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public int getCurrent() {
        return current;
    }

    /**public void setTermId(long termId) {
        this.termId = termId;
    }*/
    public void setTitle(String title) {
        this.title = title;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public void setCurrent(int current) {
        this.current = current;
    }
}
