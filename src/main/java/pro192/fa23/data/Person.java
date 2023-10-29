/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro192.fa23.data;

import java.util.Scanner;

/**
 *
 * @author phamm
 */
public abstract class Person {

    private int id;

    public int getId() {
        return id;
    }
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    private String name, phoneNumber, emailAddress;
    private Address address;

    public Person(String name, String phoneNumber, String emailAddress, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public Person() {
    }

    public void input(Scanner sc) {
        System.out.println("Enter address");
        address = new Address();
        address.input(sc);
        System.out.println("Enter name: ");
        name = sc.nextLine();
        System.out.println("Enter phone number: ");
        phoneNumber = sc.nextLine();
        System.out.println("Enter email: ");
        emailAddress = sc.nextLine();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void output() {
        System.out.println("Name: " + name);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Email: " + emailAddress);
        System.out.println("ADDRESS: ");
        address.output();

    }

    public abstract boolean isPurchaseParkingPass();
}

