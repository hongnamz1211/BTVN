package com;

public class Candy {
    private static int VALUE = 0;
    private int id;
    private String color;
    private String property;
    private int quantity;
    private double price;

    public Candy() {
    }

    public Candy(String color, String property, int quantity, double price) {
        this.id = ++VALUE;
        this.color = color;
        this.property = property;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String
    toString() {
        return "Candy{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", property='" + property + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
