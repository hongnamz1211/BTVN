package com.company;

public class Mouse extends Animal implements Interface {
    public Mouse() {
    }

    public Mouse(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Mouse{" +
                '}';
    }

    @Override
    public int run() {
        return 5;
    }

    @Override
    public String makeSound() {
        return "chít chít";
    }
}
