package com.company;

public class Student extends Human{
    private double pointMath;
    private double pointPhysics;
    private double pointChemistry;

    public Student() {
    }

    public Student(double pointMath, double pointPhysics, double pointChemistry) {
        this.pointMath = pointMath;
        this.pointPhysics = pointPhysics;
        this.pointChemistry = pointChemistry;
    }

    public Student(int id, String name, int age, double pointMath, double pointPhysics, double pointChemistry) {
        super(id, name, age);
        this.pointMath = pointMath;
        this.pointPhysics = pointPhysics;
        this.pointChemistry = pointChemistry;
    }

    public double getPointMath() {
        return pointMath;
    }

    public void setPointMath(double pointMath) {
        this.pointMath = pointMath;
    }

    public double getPointPhysics() {
        return pointPhysics;
    }

    public void setPointPhysics(double pointPhysics) {
        this.pointPhysics = pointPhysics;
    }

    public double getPointChemistry() {
        return pointChemistry;
    }

    public void setPointChemistry(double pointChemistry) {
        this.pointChemistry = pointChemistry;
    }

    public double getAvg() {
        return (pointMath + pointPhysics + pointChemistry) / 3;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", pointMath=" + pointMath +
                ", pointPhysics=" + pointPhysics +
                ", pointChemistry=" + pointChemistry +
                '}';
    }
}
