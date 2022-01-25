package com;

import com.Bill;
import com.Customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BillManager {
    ArrayList<Bill> bills;
    Scanner scanner = new Scanner(System.in);

    public BillManager() {
        this.bills = new ArrayList<>();
    }

    public Bill createBill(Customer customer) {
        System.out.println("Nhập số điện cũ");
        double oldElectric = scanner.nextDouble();
        System.out.println("Nhập số điện mới");
        double newElectric = scanner.nextDouble();
        Bill bill = new Bill(oldElectric, newElectric, customer);
        bills.add(bill);
        return bill;
    }

    public void displayBill() {
        HashSet<Customer> customerHashSet = new HashSet<>();
        for (Bill b :
                bills) {
            customerHashSet.add(b.getCustomer());
        }
        System.out.println(customerHashSet);
    }

//    public void displayBillOfCustomer(int num) {
//        for (Bill b :
//                bills) {
//            if (b.getCustomer().getElectricNumer() == num) {
//                System.out.println(b);
//            }
//        }
//    }

    public double payElectric(int num) {
        ArrayList<Bill> billPay = new ArrayList<>();
        double sumPrice = 0;
        for (Bill b : bills) {
            if (b.getCustomer().getElectricNumer() == num) {
                sumPrice += (b.getNewElectric() - b.getOldElectric()) * 750;
                billPay.add(b);
            }
        }
        bills.removeAll(billPay);
        return sumPrice;
    }
}
