package com.company;

import com.company.ScienceBook;
import com.company.NovelBook;

public class Book {
    private String name;
    private double price;
    private int quantity;
    private String dateManufacture;

    public Book() {
    }

    public Book(String name, double price, int quantity, String dateManufacture) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.dateManufacture = dateManufacture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(String dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", dateManufacture='" + dateManufacture + '\'' +
                '}';
    }
}
