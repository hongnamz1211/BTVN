package com.company;

public class Cat extends Animal implements Interface {
    public Cat() {
    }

    public Cat(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Cat{" +
                '}';
    }

    @Override
    public int run() {
        return 8;
    }

    @Override
    public String makeSound() {
        return "meo mêo";
    }
}
