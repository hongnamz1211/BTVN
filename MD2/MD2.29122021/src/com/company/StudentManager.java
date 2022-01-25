package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students;
    Scanner scanner = new Scanner(System.in);


    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public Student createStudent(int choiceGender) {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age = scanner.nextInt();
        if (age < 18 || age > 60) {
            System.out.println("Nhập sai tuổi. Nhập lại");
            return null;
        }
        scanner.nextLine();
        String gender = null;
        if (choiceGender == 1) {
            gender = "Nam";
        } else if (choiceGender == 2) {
            gender = "Nữ";
        }
        System.out.print("Giới tính: " + gender);
        System.out.println("\nNhập địa chỉ");
        String add = scanner.nextLine();
        System.out.println("Nhập điểm trung bình");
        double avg = scanner.nextDouble();
        if (avg < 0 || avg > 10) {
            System.out.println("Nhập sai giới hạn điểm. Nhập lại");
            return null;
        }
        Student student = new Student(name, age, gender, add, avg);
        students.add(student);
        return student;
    }

    public void deleteStudent(String student) {
        ArrayList<Student> student1 = new ArrayList<>();
        for (Student s :
                students) {
            if (s.getName().equals(student)) {
                student1.add(s);
            }
        }
        students.removeAll(student1);
        System.out.println("Xóa thành công");
    }

    public Student editStudent(String student, int choiceGender) {
        Student student1 = null;
        for (Student s :
                students) {
            if (s.getName().equals(student)) {
                student1 = s;
            }
        }
        if (student1 != null) {
            int index = students.indexOf(student1);
            System.out.println("Nhập tên");
            String name = scanner.nextLine();
            student1.setName(name);
            System.out.println("Nhập tuổi");
            int age = scanner.nextInt();
            if (age < 18 || age > 60) {
                System.out.println("Nhập sai tuổi. Nhập lại");
                return null;
            }
            student1.setAge(age);
            scanner.nextLine();
            String gender = null;
            if (choiceGender == 1) {
                gender = "Nam";
                student1.setGender(gender);
            } else if (choiceGender == 2) {
                gender = "Nữ";
                student1.setGender(gender);
            }
            System.out.print("Giới tính: " + gender);
            System.out.println("\nNhập địa chỉ");
            String add = scanner.nextLine();
            student1.setAdd(add);
            System.out.println("Nhập điểm trung bình");
            double avg = scanner.nextDouble();
            if (avg < 0 || avg > 10) {
                System.out.println("Nhập sai giới hạn điểm. Nhập lại");
                return null;
            }
            student1.setAvg(avg);
            students.set(index, student1);
        }
        return student1;
    }

    public void displayAll() {
        for (Student s :
                students) {
            System.out.println(s);
        }
    }

    public void displayAvg() {
        for (Student s :
                students) {
            if (s.getAvg() >= 7.5) {
                System.out.println(s);
            }
        }
    }

    public void displayLevel() {
        for (Student s :
                students) {
            if (s.getAvg() >= 8.0) {
                System.out.println("Sinh viên " + s.getName() + ": " + s.getAvg() + " xếp loại giỏi");
            } else if (s.getAvg() >= 6.0) {
                System.out.println("Sinh viên " + s.getName() + ": " + s.getAvg() + " xếp loại khá");
            } else if (s.getAvg() >= 4.5) {
                System.out.println("Sinh viên " + s.getName() + ": " + s.getAvg() + " xếp loại trung bình");
            } else {
                System.out.println("Sinh viên " + s.getName() + ": " + s.getAvg() + " xếp loại yếu");
            }
        }
    }

    public void exportCSV() {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter("E:\\btvn\\MD2.29122021\\src\\com\\company\\student.csv"))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tên,");
            sb.append("tuổi,");
            sb.append("giới tính,");
            sb.append("địa chỉ,");
            sb.append("điểm trung bình");
            sb.append('\n');

            if (students.size() > 0) {
                for (Student s :
                        students) {
                    sb.append(s.getName());
                    sb.append(',');
                    sb.append(s.getAge());
                    sb.append(',');
                    sb.append(s.getGender());
                    sb.append(',');
                    sb.append(s.getAdd());
                    sb.append(',');
                    sb.append(s.getAvg());
                    sb.append('\n');
                }
            }
            bufferedWriter.write(sb.toString());
            System.out.println("Write successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
