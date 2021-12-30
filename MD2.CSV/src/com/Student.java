package com;

public class Student extends Human{
    private double avg;

    public Student() {
    }

    public Student(String name, int age, String gender, String address, double avg) {
        super(name, age, gender, address);
        this.avg = avg;
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
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", gender='" + super.getGender() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", average=" + avg +
                '}';
    }
}
