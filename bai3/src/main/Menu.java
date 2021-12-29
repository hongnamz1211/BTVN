package main;

import manager.LibraryManager;
import manager.StudentManager;
import model.Student;

import java.util.Scanner;

public class Menu {
    private static final StudentManager studentManager = new StudentManager();
    private static final LibraryManager libraryManager = new LibraryManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Menu Student");
            System.out.println("2. Menu Library");
            System.out.println("0. Exit");
            System.out.println("--------------");
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    menuStudent();
                    break;
                case 2:
                    menuLibrary();
                    break;
            }
        } while (choice != 0);
    }

    public static void menuStudent() {
        int choice1;
        do {
            System.out.println("-----Menu Student-----");
            System.out.println("1. Tạo sinh viên");
            System.out.println("2. Xoá sinh viên");
            System.out.println("3. Hiển thị sinh viên theo id");
            System.out.println("4. Hiển thị tất cả sinh viên");
            System.out.println("0. Exit");
            System.out.println("----------------------");
            System.out.println("Nhập lựa chọn");
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    System.out.println(studentManager.createStudent());
                    break;
                case 2:
                    System.out.println("Nhập mã sinh viên");
                    String idStudent2 = scanner.next();
                    studentManager.deleteStudent(idStudent2);
                    break;
                case 3:
                    System.out.println("Nhâp mã sinh viên");
                    String idStudent3 = scanner.next();
                    studentManager.displayStudent(idStudent3);
                    break;
                case 4:
                    studentManager.displayAll();
                    break;
            }
        } while (choice1 != 0);
    }

    public static void menuLibrary() {
        int choice2;
        do {
            System.out.println("-----Menu Library-----");
            System.out.println("1. Thuê sách");
            System.out.println("2. Trả sách");
            System.out.println("3. Thông tin sinh viên thuê sách");
            System.out.println("4. Thông tin tất cả sinh viên thuê sách");
            System.out.println("0. Exit");
            System.out.println("----------------------");
            System.out.println("Nhập lựa chọn");
            choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    System.out.println("Nhập mã sinh viên muốn thuê");
                    String idStudent1 = scanner.next();
                    Student student = studentManager.getStudent(idStudent1);
                    if (student != null) {
                        System.out.println(libraryManager.createLibrary(student));
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 2:
                    System.out.println("Nhập số phiếu mượn");
                    int idStudent2 = scanner.nextInt();
                    System.out.println("Ngày phải trả sách");
                    System.out.println(libraryManager.endBorrow(idStudent2));
                    break;
                case 3:
                    System.out.println("Nhập mã sinh viên");
                    String idStudent3 = scanner.next();
                    libraryManager.displayAllBookOfStudent(idStudent3);
                    break;
                case 4:
                    libraryManager.displayAll();
                    break;

            }
        } while (choice2 != 0);
    }
}