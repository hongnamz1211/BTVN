package com.company;

public class Student extends Human{
    private double avg;

    public Student(String name, int age, String gender, String add, double avg) {
        super(name, age, gender, add);
        this.avg = avg;
    }

    public Student() {
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", avg=" + avg +
                '}';
    }
}
