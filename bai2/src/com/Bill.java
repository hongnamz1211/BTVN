package com;

public class Bill {
    private double oldElectric;
    private double newElectric;
    private Customer customer;

    public Bill() {
    }

    public Bill(double oldElectric, double newElectric, Customer customer) {
        this.oldElectric = oldElectric;
        this.newElectric = newElectric;
        this.customer = customer;
    }



    public double getOldElectric() {
        return oldElectric;
    }

    public void setOldElectric(double oldElectric) {
        this.oldElectric = oldElectric;
    }

    public double getNewElectric() {
        return newElectric;
    }

    public void setNewElectric(double newElectric) {
        this.newElectric = newElectric;
    }

    public void displayBill() {
        System.out.printf("%-20.3f%-20.3f", oldElectric, newElectric);
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return customer +
                ", oldElectric=" + oldElectric +
                ", newElectric=" + newElectric;
    }
}
