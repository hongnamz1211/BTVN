package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final StudentManager studentManager = new StudentManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        int choice;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Add student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. Find student");
            System.out.println("5. Display student sort up");
            System.out.println("6. Display student sort down");
            System.out.println("7. Display student high point");
            System.out.println("8. Write file CSV");
            System.out.println("9. Read file CSV");
            System.out.println("0. Exit");
            System.out.println("-------------");
            System.out.println("Input your choice");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentManager.createStudent();
                    break;
                case 2:
                    System.out.println("Input edit id");
                    int idEdit = scanner.nextInt();
                    System.out.println(studentManager.editStudent(idEdit));
                    break;
                case 3:
                    System.out.println("Input delete id");
                    int idDel = scanner.nextInt();
                    System.out.println(studentManager.deleteStudent(idDel));
                    break;
                case 4:
                    System.out.println("Input find id");
                    int idFind = scanner.nextInt();
                    studentManager.displayStudent(idFind);
                    break;
                case 5:
                    studentManager.sortStudentUp();
                    break;
                case 6:
                    studentManager.sortStudentDown();
                    break;
                case 7:
                    studentManager.displayHighPoint();
                    break;
                case 8:
                    studentManager.writeFile(studentManager.getStudents(), StudentManager.PATH_NAME);
                    break;
                case 9:
                    ArrayList<Student> studentRead = studentManager.readFile(StudentManager.PATH_NAME);
                    studentRead.forEach(System.out::println);
                    break;
            }
        } while (choice != 0);
    }
}
