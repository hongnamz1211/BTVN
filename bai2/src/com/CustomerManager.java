package com;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    public Customer createCustomer() {
        scanner.nextLine();
        System.out.println("Nhập tên khách hàng");
        String name = scanner.nextLine();
        System.out.println("Nhập số nhà");
        int numOfHouse = scanner.nextInt();
        System.out.println("Nhập mã số công tơ điện");
        int electricNumber = scanner.nextInt();
        for (Customer customer : customers) {
            if (customer.getElectricNumer() == electricNumber) {
                System.out.println("Trùng mã số công tơ điện, nhập lại");
                return null;
            }
        }
        scanner.nextLine();
        Customer customer = new Customer(name, numOfHouse, electricNumber);
        customers.add(customer);
        return customer;
    }

    public void deleteCustomer(int electricNumber) {
        Customer customer = null;
        for (Customer c :
                customers) {
            if (c.getElectricNumer() == electricNumber) {
                customer = c;
            }
        }
        boolean check = customers.remove(customer);
        if (check) {
            System.out.println(customer);
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    public void displayCustomer(int electricNumber) {
        Customer customer = null;
        for (Customer c :
                customers) {
            if (c.getElectricNumer() == electricNumber) {
                customer = c;
            }
        }
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    public void displayAll() {
        for (Customer c :
                customers) {
            System.out.println(c);
        }
    }

    public Customer getCustomer(int electricNumber) {
        Customer customer = null;
        for (Customer c :
                customers) {
            if (c.getElectricNumer() == electricNumber) {
                customer = c;
            }
        }
        return customer;
    }
}
