package arraylist;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalManager animalManager = new AnimalManager();

        int choice;
        do {
            System.out.println("-------------Menu--------");
            System.out.println("1. Thêm");
            System.out.println("2. Xóa theo tên");
            System.out.println("3. Sửa theo tên");
            System.out.println("4. Hiện theo tên");
            System.out.println("5. Hiện tất cả");
            System.out.println("6. Hiện từng loại");
            System.out.println("7. Hiện tên trong khoảng cân");
            System.out.println("0. Exit");
            System.out.println("Nhập");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.println("1. Dog");
                        System.out.println("2. Cat");
                        System.out.println("3. Mouse");
                        System.out.println("0. Exit");
                        System.out.println("Nhập");
                        choice1 = scanner.nextInt();
                        if (choice1 > 0 && choice1 < 4) {
                            animalManager.addAnimal(choice1);
                        }
                    } while (choice1 != 0);
                    break;
                case 2:
                    System.out.println("Nhập tên muốn xóa");
                    String deleteName = scanner.nextLine();
                    System.out.println(animalManager.deleteAnimalByName(deleteName));
                    break;
                case 3:
                    System.out.println("Nhập tên muốn sửa");
                    String updateName = scanner.nextLine();
                    System.out.println(animalManager.updateAnimalByName(updateName));
                    break;
                case 4:
                    System.out.println("Nhập tên muốn hiện");
                    String displayName = scanner.nextLine();
                    animalManager.displayByName(displayName);
                    break;
                case 5:
                    animalManager.displayAll();
                    break;
                case 6:
                    int choice2;
                    do {
                        System.out.println("1. Dog");
                        System.out.println("2. Cat");
                        System.out.println("3. Mouse");
                        System.out.println("0. Exit");
                        System.out.println("Nhập");
                        choice2 = scanner.nextInt();
                        if (choice2 > 0 && choice2 < 4) {
                            animalManager.displayBySpecies(choice2);
                        }
                    } while (choice2 != 0);
                    break;
                case 7:
                    System.out.println("Nhập trong khoảng cân");
                    double lowerWeight;
                    double higherWeight;
                    do {
                        System.out.print("Khoảng dưới");
                        lowerWeight = scanner.nextDouble();
                        System.out.print("Khoảng trên");
                        higherWeight = scanner.nextDouble();
                    } while (lowerWeight > higherWeight);
                    animalManager.displayByWeight(lowerWeight, higherWeight);
                    break;
            }
        } while (choice != 0);

    }
}
