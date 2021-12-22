package com;

public class Hotel {
    private int date;
    private String typeRoom;
    private int numRoom;
    private double price;


    public Hotel() {
    }

    public Hotel(int date, String typeRoom, int numRoom, double price) {
        this.date = date;
        this.typeRoom = typeRoom;
        this.numRoom = numRoom;
        this.price = price;
    }


    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayHotel() {
        System.out.printf("%-15d", date);
        System.out.printf("%-15S", typeRoom);
        System.out.printf("%-15d", numRoom);
        System.out.printf("%-15.2f", price);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "date=" + date +
                ", typeRoom='" + typeRoom + '\'' +
                ", price=" + price +
                '}';
    }
}
