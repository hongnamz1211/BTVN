package com;

import java.time.LocalDate;

public class Cadres {
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String add;

    public Cadres() {
    }

    public Cadres(String name, LocalDate dateOfBirth, String gender, String add) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Cadres: " +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", add='" + add + '\''
                ;
    }
}