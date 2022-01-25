package com.company;

public class Dog extends Animal implements Interface {

    public Dog() {
    }

    public Dog(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Dog{" +
                '}';
    }

    @Override
    public int run() {
        return 10;
    }

    @Override
    public String makeSound() {
        return "gô gô";
    }
}
