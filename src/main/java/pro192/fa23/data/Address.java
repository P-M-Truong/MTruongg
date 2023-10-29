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
public class Address {

    private String street, city, state;
    private int postalCode;
    private String country;

    public Address() {
    }

    public void input(Scanner sc) {
        while (true) {
            System.out.println("Enter street: ");
            street = sc.nextLine();
            if (!street.isEmpty()) {
                break;
            } else {
                System.out.println("Street cannot be empty. Please enter a street.");
            }
        }

        while (true) {
            System.out.println("Enter city: ");
            city = sc.nextLine();
            if (!city.isEmpty()) {
                break;
            } else {
                System.out.println("City cannot be empty. Please enter a city.");
            }
        }

        while (true) {
            System.out.println("Enter state: ");
            state = sc.nextLine();
            if (!state.isEmpty()) {
                break;
            } else {
                System.out.println("State cannot be empty. Please enter a state.");
            }
        }

        boolean validPostalCode = false;
        do {
            try {
                System.out.println("Enter postalCode: ");
                postalCode = Integer.parseInt(sc.nextLine());
                if (postalCode > 0) {
                    validPostalCode = true;
                } else {
                    System.out.println("Postal code must be a positive integer. Please enter a valid postal code.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for postalCode. Please enter a valid integer postalCode.");
            }
        } while (!validPostalCode);

        while (true) {
            System.out.println("Enter country: ");
            country = sc.nextLine();
            if (!country.isEmpty()) {
                break;
            } else {
                System.out.println("Country cannot be empty. Please enter a country.");
            }
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void output() {
        System.out.println("Street: " + street);

        System.out.println("City: " + city);

        System.out.println("State: " + state);

        System.out.println("Postal code: " + postalCode);

        System.out.println("Country: " + country);

    }
}
