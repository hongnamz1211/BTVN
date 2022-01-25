package com.company;

import com.company.Book;
import com.company.ScienceBook;
import com.company.NovelBook;

import java.util.Scanner;

public class ManagerBook {

    public static void displayListBooks(Book[] listBook) {
        for (Book b : listBook) {
            System.out.println(b);
        }
    }

    public static void createListBooks(Scanner scanner, Book[] listBook) {
        for (int i = 0; i < listBook.length; i++) {
            System.out.println("-[1. Book]-" +
                    "-[2. Science Book]-" +
                    "-[3. Novel Book]-");
            System.out.println("Nhập thể loại sách thứ " + (i + 1) + ": ");
            int type = scanner.nextInt();
            if (type == 1) {
                listBook[i] = createBook(scanner);
            } else if (type == 2) {
                listBook[i] = createScienceBook(scanner);
            } else if (type == 3) {
                listBook[i] = createNovelBook(scanner);
            } else {
                System.out.println("Nhập lại");
            }
        }
    }

    public static Book createBook(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhập tên sách : ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá tiền : ");
        double price = scanner.nextDouble();
        System.out.print("Nhập số lượng : ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập ngày xuất bản YY/MM/DD: ");
        String dateManufature = scanner.nextLine();
        return new Book(name, price, quantity, dateManufature);
    }

    public static ScienceBook createScienceBook(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhập tên sách : ");
        String name = scanner.nextLine();
        System.out.print("Nhập thể loại : ");
        String category = scanner.nextLine();
        System.out.print("Nhập giá tiền : ");
        double price = scanner.nextDouble();
        System.out.print("Nhập số lượng : ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập ngày xuất bản YY/MM/DD: ");
        String dateManufature = scanner.nextLine();
        return new ScienceBook(name, price, quantity, dateManufature, category);
    }

    public static NovelBook createNovelBook(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhập tên sách : ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá tiền : ");
        double price = scanner.nextDouble();
        System.out.print("Nhập số lượng : ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập ngày xuất bản YY/MM/DD: ");
        String dateManufature = scanner.nextLine();
        System.out.print("Nhập tên tác giả : ");
        String author = scanner.nextLine();
        return new NovelBook(name, price, quantity, dateManufature, author);
    }

    public static double sumBook(Book[] listBook) {
        double sum = 0;
        for (Book b : listBook) {
            sum += b.getPrice() * b.getQuantity();
        }
        return sum;
    }

    public static void findHighestPriceBook(Book[] listBook) {
        double highestPrice = listBook[0].getPrice();
        int index = 0;
        for (int i = 1; i < listBook.length; i++) {
            if (listBook[i].getPrice() > highestPrice) {
                highestPrice = listBook[i].getPrice();
                index = i;
            }
        }
        System.out.println(listBook[index]);
    }

    public static void findLowestPriceBook(Book[] listBook) {
        double lowestPrice = listBook[0].getPrice();
        int index = 0;
        for (int i = 0; i < listBook.length; i++) {
            if (listBook[i].getPrice() < lowestPrice) {
                lowestPrice = listBook[i].getPrice();
                index = i;
            }
        }
        System.out.println(listBook[index]);
    }

    public static void findCategory(Scanner scanner, Book[] listBook) {
        System.out.print("Nhập thể loại sách muốn tìm: ");
        scanner.nextLine();
        String category = scanner.nextLine();
        for (Book c : listBook) {
            if (c instanceof ScienceBook) {
                if (((ScienceBook) c).getCategory().equals(category)) {
                    System.out.println(c);
                    break;
                } else {
                    System.out.println("Không có thể loại này");
                }
            }
        }
    }

    public static void findAuthor(Scanner scanner, Book[] listbook) {
        System.out.println("Nhập tên tác giả muốn tìm: ");
        scanner.nextLine();
        String author = scanner.nextLine();
        for (Book a : listbook) {
            if (a instanceof NovelBook) {
                if (((NovelBook) a).getAuthor().equals(author)) {
                    System.out.println(a);
                    break;
                }
            }
        }
    }

    public static double avgScienceBook(Book[] listBook) {
        double sumScienceBook = 0;
        int count = 0;
//        for (int i = 0; i < listBook.length; i++) {
//            if (listBook[i] instanceof ScienceBook) {
//                sumScienceBook += listBook[i].getPrice();
//                count++;
//            }
//        }
        for (Book s : listBook) {
            if (s instanceof ScienceBook) {
                sumScienceBook += ((ScienceBook) s).getPrice();
                count++;
            }
        }
        return sumScienceBook / count;
    }

    public static void findAllAuthorBook(Scanner scanner, Book[] listBook) {
        System.out.println("Nhập tên tác giả muốn tìm: ");
        scanner.nextLine();
        String author = scanner.nextLine();
        for (Book a : listBook) {
            if (a instanceof NovelBook) {
                if (((NovelBook) a).getAuthor().equals(author)) {
                    System.out.println(a);
                }
            }
        }
    }

    public static void findAllScienceBook(Book[] listbook) {
        for (Book s : listbook) {
            if (s instanceof ScienceBook) {
                System.out.println(s);
            }
        }
    }

    public static void findAllNovelBook(Book[] listbook) {
        for (Book n : listbook) {
            if (n instanceof NovelBook) {
                System.out.println(n);
            }
        }
    }

    public static void findBookByPrice(Scanner scanner, Book[] listbook) {
        System.out.println("Nhập giá tiền cuốn sách muốn tìm");
        double price = scanner.nextDouble();
        for (Book p : listbook) {
//            if (p instanceof Book) {
            if (((Book) p).getPrice() == (price)) {
                System.out.println(p);
            }
//            }
        }
    }

    public static void findBookByPriceRange(Scanner scanner, Book[] listBook) {
        System.out.println("Nhập khoảng giá từ: .(1). đến .(2).");
        System.out.print("(1): ");
        double price1 = scanner.nextDouble();
        System.out.print("(2): ");
        double price2 = scanner.nextDouble();

        for (Book p : listBook) {
            if (p.getPrice() >= price1 && p.getPrice() <= price2) {
                System.out.println(p);
            }
        }
    }


}
