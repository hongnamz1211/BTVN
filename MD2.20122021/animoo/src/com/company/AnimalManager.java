package com.company;

import java.util.*;

public class AnimalManager {
    public Set<Animal> animalSet;
    private final Scanner scanner = new Scanner(System.in);

    public AnimalManager() {
        this.animalSet = new HashSet<>();
    }


    public void displayList() {
        for (Animal animal: animalSet){
            System.out.println(animal);
        }
    }

    public Animal createAnimal(Scanner scanner, int choice1) {
        scanner.nextLine();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age = scanner.nextInt();
        System.out.println("Nhập cân nặng");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        if (choice1 == 1) {
            return new Dog(name, age, weight);
        } else if (choice1 == 2) {
            return new Cat(name, age, weight);
        } else if (choice1 == 3) {
            return new Mouse(name, age, weight);
        }
        return null;
    }

    public Animal delByName() {
        System.out.println("Nhập tên muốn xóa");
        String name = scanner.nextLine();
//        for (Animal animal:
//                animalSet) {
//            if (animal.getName().equals(name)) {
//                return animal;
//            }
//        }
//        return null;
    }

    public Animal findByName() {
        System.out.println("Nhập tên muốn tìm");
        String name = scanner.nextLine();
        for (Animal animal: animalSet) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public Animal updateByName(String name) {

    }
}
