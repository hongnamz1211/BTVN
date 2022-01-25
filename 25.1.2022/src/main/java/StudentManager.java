import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager {
    private static final ArrayList<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Nam", 22, "HN", 7.8));
        students.add(new Student(2, "Tuyen", 20, "HCM", 8.3));
        students.add(new Student(3, "Long", 26, "DN", 7.7));
        students.add(new Student(4, "Hieu", 23, "HN", 8.2));
        students.add(new Student(5, "Tien", 24, "HD", 8.6));
    }

    public Student getStudent(int id) {
        for (Student s :
                students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> display() {
        return students;
    }

    public void createStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public void editStudent(int id, Student student) {
        students.set(id, student);
    }

    public ArrayList<Student> sortStudent() {
        students.sort((o1, o2) -> {
            if (o1.getAvg() > o2.getAvg()) return 1;
            else if (o1.getAvg() < o2.getAvg()) return -1;
            else return 0;
        });
        return students;
    }

    public ArrayList<Student> getStudentListByAvg() {
        ArrayList<Student> studentList = new ArrayList<>();
        for (Student s :
                students) {
            if (s.getAvg() >= 8) {
                studentList.add(s);
            }
        }
        return studentList;
    }

    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> studentList = new ArrayList<>();
        for (Student s :
                students) {
            if (s.getName().equals(name)) {
                studentList.add(s);
            }
        }
        return studentList;
    }
}
