package com;

public class Human {
    private String name;
    private String dateOfBirth;
    private int idCard;

    public Human() {
    }

    public Human(String name, String dateOfBirth, int idCard) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public void displayHuman() {
        System.out.printf("%-20S", name);
        System.out.printf("%-15s", dateOfBirth);
        System.out.printf("%-15s", idCard);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idCard=" + idCard +
                '}';
    }
}
