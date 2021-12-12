package com.company;


public class ScienceBook extends Book{
    private String category;

    public ScienceBook() {
    }

    public ScienceBook(String category) {
        this.category = category;
    }

    public ScienceBook(String name, double price, int quantity, String dateManufacture, String category) {
        super(name, price, quantity, dateManufacture);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ScienceBook{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", dateManufacture='" + getDateManufacture() + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
