package com.company;

import java.util.Scanner;

public class Main {
    private static final StudentManager studentManager = new StudentManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        int choice;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Sửa thông tin sinh viên");
            System.out.println("4. Hiển thị tất cả sinh viên");
            System.out.println("5. Hiển thị sinh viên có điểm trên 7,5");
            System.out.println("6. Hiển thị tất cả sinh viên theo xếp loại");
            System.out.println("7. Đọc ghi ra file CSV");
            System.out.println("--------------");
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Chọn giới tính");
                    System.out.println("1. Nam");
                    System.out.println("2. Nữ");
                    System.out.println("Nhập lựa chọn");
                    int choiceGender = scanner.nextInt();
                    scanner.nextLine();
                    studentManager.createStudent(choiceGender);
                    break;
                case 2:
                    System.out.println("Nhập tên sinh viên muốn xóa");
                    String delName = scanner.nextLine();
                    studentManager.deleteStudent(delName);
                    break;
                case 3:
                    System.out.println("Nhập tên sinh viên muốn sửa");
                    String editName = scanner.nextLine();
                    System.out.println("Chọn giới tính");
                    System.out.println("1. Nam");
                    System.out.println("2. Nữ");
                    System.out.println("Nhập lựa chọn");
                    scanner.nextLine();
                    int choiceGender3 = scanner.nextInt();
                    studentManager.editStudent(editName, choiceGender3);
                    break;
                case 4:
                    System.out.println("Danh sách sinh viên");
                    studentManager.displayAll();
                    break;
                case 5:
                    System.out.println("Danh sách sinh viên có điểm trung bình trên 7.5");
                    studentManager.displayAvg();
                    break;
                case 6:
                    System.out.println("Xếp loại sinh viên");
                    studentManager.displayLevel();
                    break;
                case 7:
                    studentManager.exportCSV();
                    break;
            }
        } while (choice != 0);
    }
}
