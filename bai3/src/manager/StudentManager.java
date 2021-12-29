package manager;

import model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StudentManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public Student createStudent() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập mã sinh viên");
        String idStudent = scanner.nextLine();
        for (Student s :
                students) {
            if (Objects.equals(s.getIdStudent(), idStudent)) {
                System.out.println("Trùng mã sinh viên, nhập lại");
                return null;
            }
        }
        System.out.println("Nhập ngày sinh");
        String date = scanner.next();
        LocalDate dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-LL-yyyy"));
        System.out.println("Nhập lớp");
        scanner.nextLine();
        String classOfStudent = scanner.nextLine();
        Student student = new Student(name, idStudent, dateOfBirth, classOfStudent);
        students.add(student);
        return student;
    }

    public void deleteStudent(String idStudent) {
        Student student = null;
        for (Student s :
                students) {
            if (Objects.equals(s.getIdStudent(), idStudent)) {
                student = s;
            }
        }
        boolean check = students.remove(student);
        if (check) {
            System.out.println("Xoá thành công");
        } else  {
            System.out.println("Không tìm thấy mã sinh viên");
        }
    }

    public void displayStudent(String idStudent) {
        Student student = null;
        for (Student s :
                students) {
            if (Objects.equals(s.getIdStudent(), idStudent)) {
                student = s;
            }
        }
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Không tìm thấy mã sinh viên");
        }
    }

    public void displayAll() {
        for (Student s :
                students) {
            System.out.println(s);
        }
    }

    public Student getStudent(String idStudent) {
        Student student = null;
        for (Student s :
                students) {
            if (Objects.equals(s.getIdStudent(), idStudent)) {
                student = s;
            }
        }
        return student;
    }
}