package com.company;


public class NovelBook extends Book {
    private String author;

    public NovelBook() {
    }

    public NovelBook(String author) {
        this.author = author;
    }

    public NovelBook(String name, double price, int quantity, String dateManufacture, String author) {
        super(name, price, quantity, dateManufacture);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "NovelBook{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", dateManufacture='" + getDateManufacture() + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
