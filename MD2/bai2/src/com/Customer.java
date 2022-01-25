package com;

public class Customer {
    private String name;
    private int numOfHouse;
    private int electricNumber;

    public Customer() {
    }

    public Customer(String name, int numOfHouse, int electricNumber) {
        this.name = name;
        this.numOfHouse = numOfHouse;
        this.electricNumber = electricNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfHouse() {
        return numOfHouse;
    }

    public void setNumOfHouse(int numOfHouse) {
        this.numOfHouse = numOfHouse;
    }

    public int getElectricNumer() {
        return electricNumber;
    }

    public void setElectricNumer(int electricNumber) {
        this.electricNumber = electricNumber;
    }

    public void displayCustomer() {
        System.out.printf("%-20S%-15s%-20s", name, numOfHouse, electricNumber);
    }

    @Override
    public String toString() {
        return "Customer -- " +
                "name='" + name + '\'' +
                ", numOfHouse=" + numOfHouse +
                ", number=" + electricNumber;
    }
}
