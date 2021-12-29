package com.company;

public class Human {
    private String name;
    private int age;
    private String gender;
    private String add;

    public Human(String name, int age, String gender, String add) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.add = add;
    }

    public Human() {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", add='" + add + '\'' +
                '}';
    }
}
