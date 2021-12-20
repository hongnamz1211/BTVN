package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        AnimalManager animalManager = new AnimalManager();

        int choice;
        do {
            System.out.println("-------------");
            System.out.println("1. hiện");
            System.out.println("2. thêm");
            System.out.println("3. xóa");
            System.out.println("4. tìm");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.println("1. Dog");
                        System.out.println("2. Cat");
                        System.out.println("3. Mouse");
                        System.out.println("Enter a choice");
                        choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:
                                Dog dog = (Dog) animalManager.createAnimal(scanner, choice1);
                                break;
                            case 2:
                                Cat cat = (Cat) animalManager.createAnimal(scanner, choice1);
                                break;
                            case 3:
                                Mouse mouse = (Mouse) animalManager.createAnimal(scanner, choice1);
                                break;
                        }
                    } while (choice1 != 0);
                    break;
                case 2:
                    animalManager.displayList();
                    break;
                case 3:
                    animalManager.delByName();
                    break;
                case 4:
                    animalManager.findByName();
                    break;
                case 5:

            }
        } while (choice != 0);

//        for (int i = 0; i < AnimalManager.VALUE; i++) {
//            int choice = scanner.nextInt();
//            animalMap.put(i, animal) = AnimalManager.createAnimal(scanner,choice);
//        }
//
//        for (Map.Entry<Integer, Animal> ani : animalMap.entrySet()) {
//            System.out.println(ani.toString());
//        }
    }
}
