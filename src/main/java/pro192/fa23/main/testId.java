/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro192.fa23.main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author phamm
 */
public class testId {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> studentIDs = new ArrayList<>();
        ArrayList<Integer> professorIDs = new ArrayList<>();

        while (true) {
            System.out.print("Enter ID (0 to exit): ");
            int id = sc.nextInt();

            if (id == 0) {
                break;
            }

            if (studentIDs.contains(id) || professorIDs.contains(id)) {
                System.out.println("ID already exists. Please enter a different ID.");
            } else {
                System.out.print("Enter type (1 for Student, 2 for Professor): ");
                int type = sc.nextInt();
                sc.nextLine();  // Consume the newline character

                if (type == 1) {
                    studentIDs.add(id);
                    System.out.println("Student ID added: " + id);
                } else if (type == 2) {
                    professorIDs.add(id);
                    System.out.println("Professor ID added: " + id);
                } else {
                    System.out.println("Invalid type. Please enter 1 for Student or 2 for Professor.");
                }
            }
        }

        sc.close();
    }
}


