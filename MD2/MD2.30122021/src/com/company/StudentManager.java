package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
    public static final String PATH_NAME = "E:\\btvn\\MD2.30122021\\src\\com\\company\\student.csv";
    private final ArrayList<Student> students;
    private final Scanner scanner = new Scanner(System.in);

    public StudentManager() {
        this.students = readFile(PATH_NAME);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student createStudent() {
        System.out.println("Input id");
        int id = scanner.nextInt();
        for (Student s :
                students) {
            if (s.getId() == id) {
                System.out.println("Input again");
                return null;
            }
        }
        System.out.println("Input name");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Input age");
        int age = scanner.nextInt();
        System.out.println("Input Math point");
        double pointMath = scanner.nextDouble();
        System.out.println("Input Physics point");
        double pointPhysics = scanner.nextDouble();
        System.out.println("Input Chemistry point");
        double pointChemistry = scanner.nextDouble();
        Student student = new Student(id, name, age, pointMath, pointPhysics, pointChemistry);
        students.add(student);
        writeFile(students, PATH_NAME);
        System.out.println("Add student have name " + name + " successfully");
        return student;
    }

    public Student editStudent(int idS) {
        Student editStudent = null;
        for (Student s :
                students) {
            if (s.getId() == idS) {
                editStudent = s;
            }
        }
        if (editStudent != null) {
            int index = students.indexOf(editStudent);
            System.out.println("Input new id");
            int id = scanner.nextInt();
            for (Student s :
                    students) {
                if (s.getId() == id) {
                    System.out.println("Input again");
                    return null;
                }
            }
            editStudent.setId(id);
            System.out.println("Input new name");
            scanner.nextLine();
            String name = scanner.nextLine();
            editStudent.setName(name);
            System.out.println("Input new age");
            int age = scanner.nextInt();
            editStudent.setAge(age);
            System.out.println("Input new Math point");
            double pointMath = scanner.nextDouble();
            editStudent.setPointMath(pointMath);
            System.out.println("Input new Physics point");
            double pointPhysics = scanner.nextDouble();
            editStudent.setPointPhysics(pointPhysics);
            System.out.println("Input new Chemistry point");
            double pointChemistry = scanner.nextDouble();
            editStudent.setPointChemistry(pointChemistry);
            students.set(index, editStudent);
            writeFile(students, PATH_NAME);
            System.out.println("Update student have name " + name + " successfully");
        }
        return editStudent;
    }

    public Student deleteStudent(int id) {
        Student deleteStudent = null;
        for (Student s :
                students) {
            if (s.getId() == id) {
                deleteStudent = s;
            }
        }
        if (deleteStudent != null) {
            students.remove(deleteStudent);
            writeFile(students, PATH_NAME);
            System.out.println("Delete student have name " + deleteStudent.getName() + " successfully");
        }
        return deleteStudent;
    }


    public void displayStudent(int id) {
        Student displayStudent = null;
        for (Student s :
                students) {
            if (s.getId() == id) {
                displayStudent = s;
            }
        }
        if (displayStudent != null) {
            System.out.println(displayStudent);
        }
    }

    public void displayHighPoint() {
        ArrayList<Student> displayHighPoint = new ArrayList<>();
        double max = 0;
        Student student = null;
        for (Student s :
                students) {
            if ((s.getAvg()) > max) {
                max = s.getAvg();
                student = s;
            }
        }
        for (Student s :
                students) {
            assert student != null;
            if (s.getAvg() == student.getAvg()) {
                displayHighPoint.add(s);
            }
        }
        System.out.println(displayHighPoint);
    }

    public void sortStudentUp() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAvg() - o2.getAvg() > 0) return 1;
                else if (o1.getAvg() - o2.getAvg() < 0) return -1;
                else return 0;
            }
        });
        students.forEach(System.out::println);
    }

    public void sortStudentDown() {
        students.sort((o1, o2) -> {
            if (o1.getAvg() - o2.getAvg() > 0) return -1;
            else if (o1.getAvg() - o2.getAvg() < 0) return 1;
            else return 0;
        });
        students.forEach(System.out::println);
    }

    public void writeFile(ArrayList<Student> students, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Student s :
                    students) {
                bufferedWriter.write(s.getId() + "," +
                        s.getName() + "," +
                        s.getAge() + "," +
                        s.getPointMath() + "," +
                        s.getPointPhysics() + "," +
                        s.getPointChemistry() + "\n");
            }
            bufferedWriter.close();
            System.out.println("Write file successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> readFile(String path) {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(PATH_NAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                students.add(new Student(Integer.parseInt(strings[0]),
                        strings[1],
                        Integer.parseInt(strings[2]),
                        Double.parseDouble(strings[3]),
                        Double.parseDouble(strings[4]),
                        Double.parseDouble(strings[5])));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return students;
    }
}
