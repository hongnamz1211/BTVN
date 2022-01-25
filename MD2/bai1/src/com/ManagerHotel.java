package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ManagerHotel {
    HashMap<Human, Hotel> hotelHashMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void createHuman() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh(xx/yy/mm)");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập số CMND");
        int idCard = scanner.nextInt();
        System.out.println("Nhập số ngày thuê phòng");
        int date = scanner.nextInt();
        System.out.println("Nhập loại phòng");
        scanner.nextLine();
        String typeRoom = scanner.nextLine();
        System.out.println("Nhập số phòng");
        int numRoom = scanner.nextInt();
        System.out.println("Nhập giá phòng");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Human human = new Human(name, dateOfBirth, idCard);
        Hotel hotel = new Hotel(date, typeRoom, numRoom, price);
        hotelHashMap.put(human, hotel);
    }

//    public void displayAll() {
////        System.out.println(hotelHashMap);
////    }

    public void bored() {
        System.out.printf("%-20S%-15S%-15S", "tên khách hàng", "ngày sinh", "số cmnd");
        System.out.printf("%-15S%-15S%-15S%-15S", "số ngày thuê", "loại phòng", "số phòng", "đơn giá");
        System.out.println();
        System.out.println();
    }

    public void displayAll() {
        bored();
        Set<Map.Entry<Human, Hotel>> setAll = hotelHashMap.entrySet();
        for (Map.Entry<Human, Hotel> s :
                setAll) {
            s.getKey().displayHuman();
            s.getValue().displayHotel();
        }
    }

    public Human deleteHuman(int inputIdCard) {
        Human human = null;
        boolean check = false;
        for (Human h : hotelHashMap.keySet()) {
            if (h.getIdCard() == inputIdCard) {
                human = h;
                check = true;
            }
        }

        if (!check) {
            System.out.println("Không có CMND");
        } else {
            hotelHashMap.remove(human);
            System.out.println("Xóa thành công");
        }
        return human;
    }

    public void displayInforById(int inputInforById) {
        boolean check = false;
        for (Map.Entry<Human, Hotel> find :
                hotelHashMap.entrySet()) {
            if (find.getKey().getIdCard() == inputInforById) {
                bored();
                find.getKey().displayHuman();
                find.getValue().displayHotel();
                check = true;
            }
        }

        if (!check) {
            System.out.println("Không có khách hàng tương ứng");
        }
    }

    public void displayPriceOfHuman(int inputNumRoom) {
        for (Hotel h : hotelHashMap.values()) {
            if (h.getNumRoom() == inputNumRoom) {
                System.out.println("Room " + h.getNumRoom() + ": " + (h.getDate() * h.getPrice()) + "USD");
            }
        }
    }

}
