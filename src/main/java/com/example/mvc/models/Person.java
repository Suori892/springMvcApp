package com.example.mvc.models;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Invalid name")
    @Size(min = 2, max = 30, message = "Check name length")
    private String name;
    @NotEmpty(message = "Write correct position")
    @Size(min = 2, max = 30)
    private String position;
    @NotEmpty(message = "Invalid email")
    @Size(min = 2, max = 30, message = "Check email size")
    @Email(message = "It is not email")
    private String email;

    //Country, city, index
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "write correct postal code")
    private String address;

    private int admin;
    public Person(int id, String name, String position, String email, String address, int admin) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.email = email;
        this.address = address;
        this.admin = admin;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
