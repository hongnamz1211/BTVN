package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sinh viên");
        int size = scanner.nextInt();
        Student[] students = new Student[size];
        StudentManager studentManager = new StudentManager(students);


        int choice;
        do {
            System.out.println("--------Menu---------");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiện danh sách sinh viên");
            System.out.println("3. Sinh viên có điểm cao nhất và thấp nhất");
            System.out.println("4. Tìm sinh viên theo tên");
            System.out.println("5. Tìm sinh viên theo giới tính");
            System.out.println("6. Thêm sinh viên");
            System.out.println("7. Xóa sinh viên theo tên");
            System.out.println("8. Sắp xếp theo điểm trung bình");
            System.out.println("9. Thay đổi thông tin sinh viên theo id");
            System.out.println("---------------------");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Nhập tên sinh viên");
                    String name = scanner.nextLine();
                    System.out.println("Nhập tuổi");
                    int age = scanner.nextInt();
                    System.out.println("Nhập giới tính");
                    scanner.nextLine();
                    String gender = scanner.nextLine();
                    System.out.println("Nhập địa chỉ");
                    String add = scanner.nextLine();
                    System.out.println("Nhập điểm trung bình");
                    double avg = scanner.nextDouble();
                    studentManager.addStudent(scanner, name, age, gender, add, avg);
                    break;
                case 2:
                    StudentManager.displayStudents(students);
                    break;
                case 3:
                    StudentManager.highestAvg(students);
                    break;
                case 4:
                    StudentManager.findStudent(scanner, students);
                    break;
                case 5:
                    StudentManager.findToGender(scanner, students);
                    break;
                case 6:
                    break;
                case 7:
                    StudentManager.delStudent(students,scanner);
                    break;
                case 8:
                    System.out.println("Danh sách sinh viên theo thứ tự điểm tăng dần");;
                    StudentManager.sortAvg(students);
                    break;
                case 9:
                    StudentManager.editStudentById(scanner,students);
                    break;
                default:
                    System.out.println("Nhập lại");
            }
        } while (choice != 0);
    }
}
