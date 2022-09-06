package model.customer;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        if (!validateEmail(email)) {
            throw new IllegalArgumentException("Invalid Email format");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private boolean validateEmail(String email) {
        String emailRegex = "^(.+)@(.+)(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer: " + firstName + " " + lastName + " email: " + email;
    }
}
