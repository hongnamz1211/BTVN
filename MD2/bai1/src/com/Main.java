package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerHotel managerHotel = new ManagerHotel();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("-----Hotel-----");
            System.out.println("1. Hiện thông tin khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Xóa khách hàng theo số CMND");
            System.out.println("4. Tính tiền khách hàng");
            System.out.println("5. Tìm kiếm khách hàng theo số CMND");
            System.out.println("0. Exit");
            System.out.println("---------------");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    managerHotel.displayAll();
                    break;
                case 2:
                    managerHotel.createHuman();
                    break;
                case 3:
                    System.out.println("Nhập số CMND người muốn xóa");
                    int inputIdCard = scanner.nextInt();
                    Human human = managerHotel.deleteHuman(inputIdCard);
                    break;
                case 4:
                    System.out.println("Nhập số phòng muốn tính tiền");
                    int inputNumRoom2 = scanner.nextInt();
                    managerHotel.displayPriceOfHuman(inputNumRoom2);
                    break;
                case 5:
                    System.out.println("Nhập số CMND người muốn tìm");
                    int inputInforById = scanner.nextInt();
                    managerHotel.displayInforById(inputInforById);
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);


//        ---------------------
//        System.out.println("Enter list size:");
//        int size = scanner.nextInt();
//        int[] list = new int[size];
//        System.out.println("Enter " + list.length + " values:");
//        for (int i = 0; i < list.length; i++) {
//            list[i] = scanner.nextInt();
//        }
//        System.out.println("Your input list:");
//        for (int e : list) {
//            System.out.print(e + "\t");
//        }
    }
}
