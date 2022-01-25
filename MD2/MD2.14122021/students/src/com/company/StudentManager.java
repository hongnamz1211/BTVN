package com.company;


import java.util.*;

public class StudentManager implements Comparator<Student> {
    private Student[] students;
    private static int index = 0;
    private int id = 1;

    public StudentManager() {
    }

    public StudentManager(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addStudent(Scanner scanner, String name, int age, String gender, String add, double avg, int id) {
        Student student = new Student(name, age, gender, add, avg);
        students[index] = student;
        index++;
        id++;
    }

    public static void displayStudents(Student[] students) {
        System.out.println("Danh sách sinh viên");
        for (Student s :
                students) {
            boolean compareNull = s != null;
            if (compareNull) {
                System.out.println(s);
            }
        }
    }

    public static void highestAvg(Student[] students) {
        double max = students[0].getAvg();
        int indexMax = 0;
        double min = students[0].getAvg();
        int indexMin = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getAvg() > max) {
                indexMax = i;
            }
            if (students[i].getAvg() < min) {
                indexMin = i;
            }
        }
        System.out.println("Sinh viên có điểm cao nhất");
        System.out.println(students[indexMax]);
        System.out.println("Sinh viên có điểm thấp nhất");
        System.out.println(students[indexMin]);
    }

    public static void findStudent(Scanner scanner, Student[] students) {
        System.out.println("Nhập tên sinh viên muốn tìm");
        scanner.nextLine();
        String findName = scanner.nextLine();
        boolean check = false;
        for (Student n :
                students) {
            if (n.getName().equals(findName)) {
                check = true;
                System.out.println("Thông tin sinh viên: " + findName);
                System.out.println(n);
            }
        }
        if (!check) {
            System.out.println("Không có sinh viên này");
        }
    }

    public static void findToGender(Scanner scanner, Student[] students) {
        System.out.println("Nhập giới tính");
        scanner.nextLine();
        String findGender = scanner.nextLine();
        boolean check = false;
        for (Student g :
                students) {
            if (g.getGender().equals(findGender)) {
                check = true;
                System.out.println("Thông tin sinh viên có giới tính: " + findGender);
                System.out.println(g);
            }
        }
        if (!check) {
            System.out.println("Lớp không có sinh viên nào giới tính là " + findGender);
        }
    }

    public static void sortAvg(Student[] students) {
        StudentManager studentManager = new StudentManager();
        Arrays.sort(students, studentManager);
        for (Student s :
                students) {
            System.out.println(s);
        }
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAvg() > o2.getAvg()) return 1;
        else if (o1.getAvg() < o2.getAvg()) return -1;
        else return 0;
    }


    public static Student[] delStudent(Student[] students, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Nhập tên sinh viên muốn xóa");
        String delName = scanner.nextLine();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getName().equals(delName)) {
                for (int j = i; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[students.length - 1] = null;
            }
        }
        index--;
        return students;
    }

    public static void editStudentById(Scanner scanner, Student[] students) {
        scanner.nextLine();
        System.out.println("Nhập id của sinh viên muốn thay đổi");
        int editId = scanner.nextInt();
        for (Student s : students) {
            if (s != null && editId == s.getId()) {
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
            }
        }
    }
}

