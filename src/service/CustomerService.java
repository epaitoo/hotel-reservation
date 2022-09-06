package service;

import model.customer.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerService {
    // static  variable reference of the class instance
    private static CustomerService instance = null;

    ArrayList<Customer> customers = new ArrayList<Customer>();
    Customer customer;

    private CustomerService() {}

    public void addCustomer(String email, String firstName, String lastName) {
        try {
            Customer customer = new Customer(firstName, lastName, email);
            customers.add(customer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public Customer getCustomer(String customerEmail) {
        // loop through the list of customers
        // search if the email field equals customerEmail
        for (Customer customer: customers) {
            if (customer.getEmail().equals(customerEmail)) {
                this.customer = customer;
            }
        }
        return customer;
    }

    public Collection<Customer> getAllCustomers() {
        return customers;
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

}
