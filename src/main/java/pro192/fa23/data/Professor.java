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
public class Professor extends Person {
    private int professorld;
    private int salary;

    public int getProfessorld() {
        return professorld;
    }

    public void setProfessorld(int professorld) {
        this.professorld = professorld;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Professor(int professorld, int salary, String name, String phoneNumber, String emailAddress, Address address) {
        super(name, phoneNumber, emailAddress, address);
        this.professorld = professorld;
        this.salary = salary;
    }

    public Professor() {
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.println("Enter professorld: ");
        professorld = sc.nextInt();
        System.out.println("Enter salary: ");
        salary = sc.nextInt();
    }

    @Override
    public void output() {
        System.out.println("OUTPUT: ");
        System.out.println("Object: Professor ");
        System.out.println("Id: " + professorld);
        System.out.println("Salary: " + salary);
        super.output();
        System.out.println("----------------------------------------");
    }

    @Override
    public boolean isPurchaseParkingPass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
