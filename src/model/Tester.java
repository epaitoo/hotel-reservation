package model;

import model.customer.Customer;

public class Tester {
    public static void main(String[] args) {
        Customer customer = new Customer("joe", "doe", "j@gmail.com");
        System.out.println(customer);
    }
}
