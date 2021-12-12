package com.company;

import com.company.ManagerBook;
import com.company.Book;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sách: ");
        int size = scanner.nextInt();
        Book[] listBooks = new Book[size];

        int choice = -1;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    ManagerBook.createListBooks(scanner, listBooks);
                    break;
                case 2:
                    ManagerBook.displayListBooks(listBooks);
                    break;
                case 3:
                    System.out.println("Tổng giá: " + ManagerBook.sumBook(listBooks) + " USD");
                    break;
                case 4:
                    System.out.println("Giá sản phẩm cao nhất: ");
                    ManagerBook.findHighestPriceBook(listBooks);
                    System.out.println("Giá sản phẩm thấp nhất: ");
                    ManagerBook.findLowestPriceBook(listBooks);
                    break;
                case 5:
                    ManagerBook.findCategory(scanner, listBooks);
                    break;
                case 6:
                    ManagerBook.findAuthor(scanner, listBooks);
                    break;
                case 7:
                    System.out.println("Giá trung bình sách khoa học: " + ManagerBook.avgScienceBook(listBooks) + " USD");
                    break;
                case 8:
                    ManagerBook.findAllAuthorBook(scanner, listBooks);
                    break;
                case 9:
                    ManagerBook.findAllScienceBook(listBooks);
                    break;
                case 10:
                    ManagerBook.findAllNovelBook(listBooks);
                    break;
                case 11:
                    ManagerBook.findBookByPrice(scanner, listBooks);
                    break;
                case 12:
                    ManagerBook.findBookByPriceRange(scanner, listBooks);
                    break;
                default:
                    System.out.println("Nhập lại");
            }
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("-[0. Đi về]-");
        System.out.println("-[1. Thêm sách                ]-"
                + "-[2. Hiện sách                    ]-"
                + "-[3. Tính tổng giá của sách            ]-"
                + "-[4. Tìm giá cao nhất và thấp nhất ]-");
        System.out.println("-[5. Tìm sách theo thể loại   ]-"
                + "-[6. Tìm sách theo tác giả        ]-"
                + "-[7. Tính giá trung bình sách khoa học ]-"
                + "-[8. Tìm tất cả sách của tác giả   ]-");
        System.out.println("-[9. Tìm tất cả sách khoa học ]-"
                + "-[10. Tìm tất cả sách tiểu thuyết ]-"
                + "-[11. Tìm theo giá tiền                ]-"
                + "-[12. Tìm theo khoảng giá tiền     ]-");
    }
}
