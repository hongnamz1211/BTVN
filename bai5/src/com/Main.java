package com;

import java.util.Scanner;

public class Main {
    private static final CadresManager cadresManager = new CadresManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Tìm kiếm nhân viên theo tên");
            System.out.println("3. Hiển thị tất cả nhân viên");
            System.out.println("--------------");
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.println("-----Cadres Manager-----");
                        System.out.println("1. Thêm cán bộ");
                        System.out.println("2. Thêm công nhân");
                        System.out.println("3. Thêm kỹ sư");
                        System.out.println("4. Thêm nhân viên");
                        System.out.println("0. Exit");
                        System.out.println("----------");
                        choice1 = scanner.nextInt();
                        scanner.nextLine();
                        cadresManager.createCadres(choice1);
                    } while (choice1 != 0);
                    break;
                case 2:
                    System.out.println("Nhập tên nhân viên muốn tìm kiếm");
                    String name = scanner.nextLine();
                    System.out.println(cadresManager.findByName(name));
                    break;
                case 3:
                    cadresManager.displayAll();
                    break;
            }
        } while (choice != 0);
    }
}