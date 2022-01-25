package model;

import java.time.LocalDate;

public class Library {
    private int cardBorrow;
    private LocalDate startBorrow;
    private LocalDate endBorrow;
    private int daysBorrow;
    private int numOfBook;
    private Student student;

    public Library() {
    }

    public Library(Student student,int cardBorrow, LocalDate startBorrow, int daysBorrow, int numOfBook) {
        this.cardBorrow = cardBorrow;
        this.startBorrow = startBorrow;
        this.daysBorrow = daysBorrow;
        this.numOfBook = numOfBook;
        this.student = student;
    }

    public int getCardBorrow() {
        return cardBorrow;
    }

    public void setCardBorrow(int cardBorrow) {
        this.cardBorrow = cardBorrow;
    }

    public LocalDate getStartBorrow() {
        return startBorrow;
    }

    public void setStartBorrow(LocalDate startBorrow) {
        this.startBorrow = startBorrow;
    }

    public LocalDate getEndBorrow() {
        return getStartBorrow().plusDays(getDaysBorrow());
    }

    public void setEndBorrow(LocalDate endBorrow) {
        this.endBorrow = endBorrow;
    }

    public int getDaysBorrow() {
        return daysBorrow;
    }

    public void setDaysBorrow(int daysBorrow) {
        this.daysBorrow = daysBorrow;
    }

    public int getNumOfBook() {
        return numOfBook;
    }

    public void setNumOfBook(int numOfBook) {
        this.numOfBook = numOfBook;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return student +
                ", cardBorrow=" + cardBorrow +
                ", startBorrow=" + startBorrow +
                ", endBorrow=" + endBorrow +
                ", daysBorrow=" + daysBorrow +
                ", numOfBook=" + numOfBook;
    }
}
