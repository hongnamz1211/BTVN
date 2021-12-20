package arraylist;

import com.company.Animal;
import com.company.Cat;
import com.company.Dog;
import com.company.Mouse;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalManager {
    private final ArrayList<Animal> animals;
    Scanner scanner = new Scanner(System.in);

    public AnimalManager() {
        animals = new ArrayList<>();
    }

    public void addAnimal(int choice) {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
//        name = checkName(name);
        System.out.println("Nhập tuổi");
        int age = scanner.nextInt();
        System.out.println("Nhập cân nặng");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        if (choice == 1) {
            Dog dog = new Dog(name, age, weight);
            animals.add(dog);
        } else if (choice == 2) {
            Cat cat = new Cat(name, age, weight);
            animals.add(cat);
        } else if (choice == 3) {
            Mouse mouse = new Mouse(name, age, weight);
            animals.add(mouse);
        }
    }

    private String checkName(String name) {
        for (Animal animal :
                animals) {
            while (animal.getName().equals(name)) {
                System.out.println("Tên đã tồn tại. Nhập lại");
                name = scanner.nextLine();
            }
        }
        return name;
    }

    public Animal deleteAnimalByName(String name) {
        Animal ani = new Animal();
        for (Animal animal :
                animals) {
            ani = animal;
            animals.remove(animal);
            break;
        }
        return ani;
    }

    public Animal updateAnimalByName(String updateName) {
        Animal ani = new Animal();
        for (Animal animal :
                animals) {
            if (animal.getName().equals(updateName)) {
                System.out.println("Nhập lại tên");
                String name = scanner.nextLine();
                animal.setName(name);
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                animal.setAge(age);
                System.out.print("Enter weight: ");
                double weight = scanner.nextDouble();
                scanner.nextLine();
                animal.setWeight(weight);
                ani = animal;
                break;
            }
        }
        return ani;
    }

    public void displayByName(String displayName) {
        for (Animal animal : animals) {
            if (animal.getName().equals(displayName)) {
                System.out.println(animal);
            }
        }
    }

    public void displayAll() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public void displayBySpecies(int choice) {
        for (Animal animal : animals) {
            if (choice == 1 && animal instanceof Dog) {
                System.out.println(animal);
            } else if (choice == 2 && animal instanceof Cat) {
                System.out.println(animal);
            } else if (choice == 3 && animal instanceof Mouse) {
                System.out.println(animal);
            }
        }
    }

    public void displayByWeight(double lowerWeight, double higherWeight) {
        for (Animal animal : animals) {
            if (animal.getWeight() >= lowerWeight && animal.getWeight() <= higherWeight) {
                System.out.println(animal);
            }
        }
    }

}
