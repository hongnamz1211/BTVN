package com;

import java.time.LocalDate;

public class Engineer extends Cadres {
    private String career;

    public Engineer() {
    }

    public Engineer(String name, LocalDate dateOfBirth, String gender, String add, String career) {
        super(name, dateOfBirth, gender, add);
        this.career = career;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", career='" + career + '\'';
    }
}