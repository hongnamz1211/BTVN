package manager;

import model.Library;
import model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class LibraryManager {
    ArrayList<Library> libraries;
    Scanner scanner = new Scanner(System.in);

    public LibraryManager() {
        this.libraries = new ArrayList<>();
    }

    public Library createLibrary(Student student) {
        System.out.println("Nhập số phiếu mượn");
        int cardBorrow = scanner.nextInt();
        System.out.println("Nhập ngày bắt đầu mượn");
        String date = scanner.next();
        LocalDate startBorrow = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-LL-yyyy"));
        System.out.println("Nhập số ngày mượn");
        int dayBorrow = scanner.nextInt();
        System.out.println("Nhập số hiệu sách");
        int numOfBook = scanner.nextInt();
        Library library = new Library(student, cardBorrow, startBorrow, dayBorrow, numOfBook);
        libraries.add(library);
        return library;
    }

    public void displayAll() {
        HashSet<Student> studentHashSet = new HashSet<>();
        for (Library l :
                libraries) {
            studentHashSet.add(l.getStudent());
        }
        System.out.println(studentHashSet);
    }

    public void displayAllBookOfStudent(String idStudent) {
        for (Library l :
                libraries) {
            if (Objects.equals(l.getStudent().getIdStudent(), idStudent)) {
                System.out.println(l);
            }
        }
    }

    public String endBorrow(int cardBorrow) {
        ArrayList<Library> libraryEndBorrow = new ArrayList<>();
        String endBorrow;
        for (Library l :
                libraries) {
            if (l.getCardBorrow() == cardBorrow) {
                endBorrow = String.valueOf(l.getStartBorrow().plusDays(l.getDaysBorrow()));
                if (LocalDate.now().isBefore(l.getEndBorrow())) {
                    System.out.println("Quá hạn trả sách");
                }
                return endBorrow;
            }
        }
        libraries.removeAll(libraryEndBorrow);
        return null;
    }
}