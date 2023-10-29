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
public class Student extends Person {

    private float averageMark;
    private int studentId;

    public Student(int studentId, float averageMark, String name, String phoneNumber, String emailAddress, Address address) {
        super(name, phoneNumber, emailAddress, address);
        this.averageMark = averageMark;
        this.studentId = studentId;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.println("Enter studentId: ");
        studentId = sc.nextInt();
        System.out.println("Enter averageMark: ");
        averageMark = sc.nextFloat();
    }

    @Override
    public void output() {
        System.out.println("OUTPUT: ");
        System.out.println("Object: Student ");
        System.out.println("Id: " + studentId);
        System.out.println("Average mark: " + averageMark);
        super.output();
        System.out.println("----------------------------------------");
    }

    @Override
    public boolean isPurchaseParkingPass() {
        return false;
    }

    @Override
    public int getId() {
        return studentId;
    }
}
