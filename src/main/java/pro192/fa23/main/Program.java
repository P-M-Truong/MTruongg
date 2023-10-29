/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro192.fa23.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import pro192.fa23.data.Address;
import pro192.fa23.data.Person;
import pro192.fa23.data.Professor;
import pro192.fa23.data.Student;
import pro192.fa23.util.Validator;

/**
 *
 * @author phamm
 */
public class Program {

    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Person> list = new ArrayList<>();
    private static Set<Integer> idSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create a person");
            System.out.println("2. Display all persons");
            System.out.println("3. Find person by name");
            System.out.println("4. Update a person by id");
            System.out.println("5. Remove a person by id");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextLine();

            if (!option.matches("[1-6]")) {
                System.out.println("Invalid input. Please enter a valid option (1-6).");
                option = sc.nextLine();
            }

            switch (option) {
                case "1":
                    createPerson(sc, list);
                    break;
                case "2":
                    displayAllPersons(sc, list);
                    break;
                case "3":
                    findPersonByName(sc, list);
                    break;
                case "4":
                    updatePersonById(sc, list);
                    break;
                case "5":
                    removePersonById(sc, list);
                    break;
                case "6":
                    System.out.println("Exiting program.");
                    break;
            }
        } while (!option.equals("6"));

        sc.close();
    }

    private static void createPerson(Scanner sc, ArrayList<Person> list) {
        int type = 0;
        do {
            System.out.println("Choose the type of person (1. Student / 2. Professor): ");
            String typeInput = sc.nextLine();
            try {
                type = Integer.parseInt(typeInput);
                if (type != 1 && type != 2) {
                    System.out.println("Invalid input for type. Please enter 1 for Student or 2 for Professor.");
                }
            } catch (NumberFormatException a) {
                System.out.println("Invalid input for type. Please enter 1 for Student or 2 for Professor.");
            }
        } while (type != 1 && type != 2);

        boolean validId = false;
        int id = 0;

        do {
            System.out.println("Enter ID: ");
            String idInput = sc.nextLine();
            try {
                id = Integer.parseInt(idInput);
                if (!idSet.contains(id)) { // Kiểm tra xem ID đã tồn tại hay chưa
                    validId = true;
                    idSet.add(id); // Thêm ID mới vào Set
                } else {
                    System.out.println("ID already exists. Enter a different ID: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for ID. Please enter a valid integer ID.");
            }
        } while (!validId);
        Address address = new Address();
        address.input(sc);
        System.out.println("Enter emailAddress: ");
        String emailAddress = sc.nextLine();
        boolean validEmail = false;

        while (!validEmail) {
            if (Validator.isValidateEmail(emailAddress)) {
                System.out.println("Valid email format.");
                validEmail = true;
            } else {
                System.out.println("Invalid email format. Please enter a valid format email address: username@domain");
                emailAddress = sc.nextLine();
            }
        }

        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter phoneNumber: ");
        String phoneNumber = sc.nextLine();

        if (type == 1) {
            boolean cont = true;
            while (cont) {
                System.out.println("Enter average mark: ");
                float averageMark;
                try {
                    averageMark = Float.parseFloat(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for average mark. Average mark must be in (0-10]. Please enter a valid number.");
                    averageMark = sc.nextFloat();
                }

                if (Validator.isAverageMark(averageMark) && Validator.isValidateAddress(address)) {
                    Student student = new Student(id, averageMark, name, phoneNumber, emailAddress, address);
                    student.setUserType("Student");
                    list.add(student);
                    System.out.println("Student created successfully.");
                    cont = false;
                } else {
                    System.out.println("Invalid average mark.");
                }
            }
        } else if (type == 2) {
            int salary = 0;
            boolean validSalary = false;
            do {
                System.out.println("Enter salary: ");
                String salaryInput = sc.nextLine();

                try {
                    salary = Integer.parseInt(salaryInput);
                    if (Validator.isSalary(salary) && Validator.isValidateAddress(address)) {
                        validSalary = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Salary is out of valid range for int(0 to 2,147,483,647). Enter a valid salary.");
                }
            } while (!validSalary);

            if (Validator.isValidateAddress(address)) {
                Person professor = new Professor(id, salary, name, phoneNumber, emailAddress, address);
                professor.setUserType("Professor");
                list.add(professor);
                System.out.println("Professor created successfully.");
                boolean cont = false;
            } else {
                System.out.println("Invalid address.");
            }
        } else {
            System.out.println("Invalid person type.");
        }
    }

    private static void displayAllPersons(Scanner sc, ArrayList<Person> list) {
        boolean isEmpty = true;

        for (Person person : list) {
            if (person != null) {
                person.output();
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("No object for displaying.");
        }
    }

    private static void findPersonByName(Scanner sc, ArrayList<Person> list) {
        boolean found = false;

        while (true) {
            System.out.println("Enter the name to search object, type 'Exit' or press 'Enter'  to return to the main menu: ");
            String searchName = sc.nextLine();

            if (searchName.equalsIgnoreCase("Exit") || searchName.isEmpty()) {
                break;
            }

            found = false;

            for (Person person : list) {
                if (person.getName().equalsIgnoreCase(searchName)) {
                    person.output();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No person found with the specified name.");
            }
        }
    }

    private static void updatePersonById(Scanner sc, ArrayList<Person> list) {
        System.out.println("Enter the ID of the person to update: ");
        int updateId = sc.nextInt();
        sc.nextLine(); // Đọc dòng thừa sau khi đọc ID

        boolean found = false;

        for (Person person : list) {
            if (person instanceof Professor && person.getId() == updateId) {
                Professor professor = (Professor) person; // Ép kiểu về Professor
                System.out.println("Choose what to update for Professor:");
                System.out.println("1. Name");
                System.out.println("2. Phone Number");
                System.out.println("3. Email");
                System.out.println("4. Address");
                System.out.println("5. Salary");
                int choice = sc.nextInt();
                sc.nextLine(); // Đọc dòng thừa sau khi đọc lựa chọn

                switch (choice) {
                    case 1:
                        System.out.println("Enter new name: ");
                        String newName = sc.nextLine();
                        professor.setName(newName);
                        break;
                    case 2:
                        System.out.println("Enter new phone number: ");
                        String newPhoneNumber = sc.nextLine();
                        professor.setPhoneNumber(newPhoneNumber);
                        break;
                    case 3:
                        System.out.println("Enter new email: ");
                        String newEmail = sc.nextLine();
                        if (Validator.isValidateEmail(newEmail)) {
                            professor.setEmailAddress(newEmail);
                        } else {
                            System.out.println("Invalid email address.");
                        }
                        break;
                    case 4:
                        Address newAddress = new Address();
                        newAddress.input(sc);
                        if (Validator.isValidateAddress(newAddress)) {
                            professor.setAddress(newAddress);
                        } else {
                            System.out.println("Invalid address.");
                        }
                        break;
                    case 5:
                        System.out.println("Enter new salary: ");
                        int newSalary = sc.nextInt();
                        sc.nextLine(); // Đọc dòng thừa sau khi đọc lương
                        if (Validator.isSalary(newSalary)) {
                            professor.setSalary(newSalary);
                        } else {
                            System.out.println("Invalid salary.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

                System.out.println("Professor information updated.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Professor not found with the specified ID.");
        }
    }

    private static void removePersonById(Scanner sc, ArrayList<Person> list) {
        System.out.println("Enter the ID of the person to remove: ");
        int removeId = sc.nextInt();
        sc.nextLine(); // Đọc dòng thừa sau khi đọc ID

        boolean found = false;

        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person instanceof Professor && person.getId() == removeId) {
                iterator.remove();
                System.out.println("Professor removed successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Professor not found with the specified ID.");
        }
    }
}
