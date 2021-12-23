package com;

import java.util.Scanner;

public class Main {
    private static final CustomerManager customerManager = new CustomerManager();
    private static final BillManager billManager = new BillManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý biên lai");
            System.out.println("0. Exit");
            System.out.println("--------------");
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menuCustomer();
                    break;
                case 2:
                    menuBill();
                    break;
            }
        } while (choice != 0);
    }

    public static void menuCustomer() {
        int choice1;
        do {
            System.out.println("-----Menu Customer-----");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị tất cả khách hàng");
            System.out.println("3. Tìm kiếm khách");
            System.out.println("4. Xóa khách hàng");
            System.out.println("0. Exit");
            System.out.println("-----------------------");
            System.out.println("Nhập lựa chọn");
            choice1 = scanner.nextInt();
            scanner.nextLine();
            switch (choice1) {
                case 1:
                    customerManager.createCustomer();
                    break;
                case 2:
                    customerManager.displayAll();
                    break;
                case 3:
                    System.out.println("Nhập vào mã số công tơ điện");
                    int num3 = scanner.nextInt();
                    customerManager.displayCustomer(num3);
                    break;
                case 4:
                    System.out.println("Nhập vào mã số công tơ điện");
                    int num4 = scanner.nextInt();
                    customerManager.deleteCustomer(num4);
                    break;
            }
        } while (choice1 != 0);
    }

    public static void menuBill() {
        int choice2;
        do {
            System.out.println("-----Menu Bill-----");
            System.out.println("1. Thêm số điện");
            System.out.println("2. Thanh toán hóa đơn");
            System.out.println("3. Hiển thị thông tin khách hàng");
//            System.out.println("4. Xóa khách hàng");
            System.out.println("0. Exit");
            System.out.println("-------------------");
            System.out.println("Nhập lựa chọn");
            choice2 = scanner.nextInt();

            switch (choice2) {
                case 1:
                    System.out.println("Nhập mã số công tơ điện");
                    int num = scanner.nextInt();
                    Customer customer = customerManager.getCustomer(num);
                    if (customer != null) {
                        System.out.println(billManager.createBill(customer));
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 2:
                    System.out.println("Nhập mã số công tơ điện");
                    int num2 = scanner.nextInt();
                    System.out.println("Số  tiền phải thanh toán là:");
                    System.out.println(billManager.payElectric(num2));
                    break;
                case 3:
                    billManager.displayBill();
                    break;
            }
        } while (choice2 != 0);
    }
}
