package com.company;

import java.util.Collections;

public class Student{
    private String name;
    private int age;
    private String gender, add;
    private double avg;
    private int id;

    public Student() {
    }

    public Student(String name, int age, String gender, String add, double avg) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.add = add;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }


    @Override
    public String toString() {
        return "Student{" +
                "Tên: '" + name + '\'' +
                ", tuổi: " + age +
                ", giới tính: '" + gender + '\'' +
                ", địa chỉ: '" + add + '\'' +
                ", điểm TB: " + avg +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
