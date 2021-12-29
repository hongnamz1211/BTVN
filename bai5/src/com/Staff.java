package com;

import java.time.LocalDate;

public class Staff extends Cadres {
    private String work;

    public Staff() {
    }

    public Staff(String name, LocalDate dateOfBirth, String gender, String add, String work) {
        super(name, dateOfBirth, gender, add);
        this.work = work;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return super.toString() +
                "work='" + work + '\'';
    }
}