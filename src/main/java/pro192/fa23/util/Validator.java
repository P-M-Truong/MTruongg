/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package pro192.fa23.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import pro192.fa23.data.Address;
import pro192.fa23.data.Person;
import pro192.fa23.data.Student;
/**
 *
 * @author phamm
 */
public class Validator {

    private static Set<Integer> studentIds = new HashSet<>();
    private static Set<Integer> professorIds = new HashSet<>();

    public static boolean isValidateEmail(String email) {
        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidateAddress(Address address) {
        if (!address.getStreet().isEmpty()
                && !address.getCity().isEmpty()
                && !address.getState().isEmpty()
                && address.getPostalCode() > 0
                && !address.getCountry().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicatedId(int id, ArrayList<? extends Person> list, String userType) {
        if (userType.equalsIgnoreCase("Student")) {
            return studentIds.contains(id);
        } else if (userType.equalsIgnoreCase("Professor")) {
            return professorIds.contains(id);
        } else {
            return false;
        }
    }

    public static boolean isEligibleToGraduate(Student student) {
        return student.getAverageMark() >= 5.0f;
    }

    public static boolean isAverageMark(float averageMark) {
        return averageMark >= 0.0f && averageMark <= 10.0f;
    }

    public static boolean isSalary(int salary) {
        if (salary > 0 && salary <= Integer.MAX_VALUE) {
            return true;
        } else {
            System.out.println("Salary is out of valid range for int. Please type again!!");
            return false;
        }
    }
}
