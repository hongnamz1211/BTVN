package model;

import java.time.LocalDate;

public class Student {
    private String name;
    private String idStudent;
    private LocalDate dateOfBirth;
    private String classOfStudent;

    public Student() {
    }

    public Student(String name, String idStudent, LocalDate dateOfBirth, String classOfStudent) {
        this.name = name;
        this.idStudent = idStudent;
        this.dateOfBirth = dateOfBirth;
        this.classOfStudent = classOfStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassOfStudent() {
        return classOfStudent;
    }

    public void setClassOfStudent(String classOfStudent) {
        this.classOfStudent = classOfStudent;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", idStudent='" + idStudent + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", classOfStudent='" + classOfStudent;
    }
}