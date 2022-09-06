package service;

import model.customer.Customer;

import java.util.*;

public class CustomerService {
    // static  variable reference of the class instance
    private static CustomerService instance = null;

    Map<String, Customer> customers = new HashMap<String, Customer>();

    private CustomerService() {}

    public void addCustomer(String email, String firstName, String lastName) {
        try {
            checkEmail(email);
            Customer customer = new Customer(firstName, lastName, email);
            customers.put(customer.getEmail(), customer);
            System.out.println("New Customer Added");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        List<Customer> allCustomers = new ArrayList<Customer>(customers.values());
        return allCustomers;
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

    private void checkEmail(String email) throws Exception {
        if (customers.containsKey(email)) {
            throw new IllegalArgumentException("Email Already Exist");
        }
    }

}
