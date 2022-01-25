package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CadresManager {
    ArrayList<Cadres> cadresArrayList;
    Scanner scanner = new Scanner(System.in);

    public CadresManager() {
        this.cadresArrayList = new ArrayList<>();
    }

    public Cadres createCadres(int choice) {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String date = scanner.next();
        LocalDate dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Nhập giới tính");
        String gender = scanner.next();
        System.out.println("Nhập địa chỉ");
        scanner.nextLine();
        String add = scanner.nextLine();
        switch (choice) {
            case 1:
                Cadres cadres = new Cadres(name, dateOfBirth, gender, add);
                cadresArrayList.add(cadres);
                return cadres;
            case 2:
                System.out.println("Nhập số bậc (1-7)");
                int level = scanner.nextInt();
                if (level < 1 || level > 7) {
                    System.out.println("Nhập lại!!!");
                    return null;
                }
                Worker worker = new Worker(name, dateOfBirth, gender, add, level);
                cadresArrayList.add(worker);
                return worker;
            case 3:
                System.out.println("Nhập chuyên ngành");
                String career = scanner.nextLine();
                Engineer engineer = new Engineer(name, dateOfBirth, gender, add, career);
                cadresArrayList.add(engineer);
                return engineer;
            case 4:
                System.out.println("Nhập công việc");
                String work = scanner.nextLine();
                Staff staff = new Staff(name, dateOfBirth, gender, add, work);
                cadresArrayList.add(staff);
                return staff;
        }
        return null;
    }

    public ArrayList<Cadres> findByName(String name) {
        if (cadresArrayList.isEmpty()) {
            System.out.println("Chưa có nhân viên nào");
        }
        ArrayList<Cadres> cadres = new ArrayList<>();
        for (Cadres c :
                cadresArrayList) {
            if (c.getName().equals(name)) {
                cadres.add(c);
            }
        }
        return cadres;
    }

    public void displayAll() {
        if (!cadresArrayList.isEmpty()) {
            for (Cadres c :
                    cadresArrayList) {
                System.out.println(c);
            }
        } else {
            System.out.println("Chưa có nhân viên nào");
        }
    }
}
