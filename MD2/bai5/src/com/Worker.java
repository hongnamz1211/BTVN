package com;

import java.time.LocalDate;

public class Worker extends Cadres{
    private int level;

    public Worker() {
    }

    public Worker(String name, LocalDate dateOfBirth, String gender, String add, int level) {
        super(name, dateOfBirth, gender, add);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", level='" + level +
                "/7" + '\'';
    }
}