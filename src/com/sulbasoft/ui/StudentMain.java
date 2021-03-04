/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sulbasoft.ui;

import com.sulbasoft.business.Student;
import com.sulbasoft.data.StudentDB;
import com.sulbasoft.utility.DBException;
import com.sulbasoft.utility.GenderType;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author M. S. Ali (CCS)
 */
public class StudentMain {

    public static void main(String... args) {
        Console.display("WELCOME TO STUDENT MANAGEMENT SYSTEM");
       
        menu();
        Console.displayNewLine();
        String action = "y";
        while (!action.equalsIgnoreCase("exit")) {
            // Get input from the user
            action = Console.getString("Enter a command: ");
            Console.displayNewLine();

            action = action.trim();

            if (action.equalsIgnoreCase("list")) {
                displayAll();
            } else if (action.equalsIgnoreCase("search")) {
                search();
            } else if (action.equalsIgnoreCase("filter")) {
                filterByGender();
                //filterNullEmails();
            } else if (action.equalsIgnoreCase("add")) {
                addStudent();
            } else if (action.equalsIgnoreCase("update") || action.equalsIgnoreCase("edit")) {
                updateStudent();
            } else if (action.equalsIgnoreCase("delete") || action.equalsIgnoreCase("del")) {
                deleteStudent();
            } else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu")) {
                menu();
            } else if (action.equalsIgnoreCase("exit")) {
                Console.display("Bye!");
            } else {
                Console.display("Invalid command choice");
            }
        }

    }

    public static void menu() {
        Console.display("----------- MAIN MENU -----------");
        Console.display("list   - Display all students");
        Console.display("search - Search a Student");
        Console.display("filter - Filter students by gender");
        Console.display("add    - Add a student");
        Console.display("update - Edit a student");
        Console.display("delete - Delete a student");
        Console.display("help   - Show this menu");
        Console.display("exit   - Exit the application");
    }

    public static void displayAll() {
        Console.display("---------- LIST OF ALL STUDENTS ----------");
        List<Student> students = null;
        try {
            students = StudentDB.getAll();
        } catch (DBException e) {
            System.err.println(e.toString());
        }
        students.forEach(System.out::println);
         // Count how many students
        long studentsCount = students.stream()
                .count();
        Console.display(studentsCount + " students found!");
        Console.displayNewLine();
    }

    public static void search() {
        Console.display("---------- SEARCH A STUDENT ----------");
        String id = Console.getString("Enter student id: ");
        Student s = null;
        try {
            s = StudentDB.get(id);
        } catch (DBException ex) {
            Logger.getLogger(StudentMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (s != null) {
            System.out.println(s.toString());
        } else {
            Console.display("No student was found with this id.");
        }
    }

    public static void addStudent() {
        Console.display("---------- ADD NEW STUDENT ----------");
        String id = Console.getString("Enter student Id: ");
        String fname = Console.getString("Enter first name: ");
        String lname = Console.getString("Enter last name: ");
        String gender = Console.getString("Enter your gender: ");
        // Convert gender to GenderType enumeration
        GenderType sex = GenderType.valueOf(gender.toUpperCase());
        LocalDate dob = Console.getDate("Enter your birth date [yyyy-mm-dd]: ");
        double gpa = Console.getDouble("Enter GPA: ", 0.00, 5.01);
        String email = Console.getString("Enter email: ");
        String phone = Console.getString("Enter phone number: ");

        Student s = new Student(id.toUpperCase(), fname, lname, sex, dob, gpa, email, phone);

        try {
            boolean status = StudentDB.add(s);
            if (status == true) {
                Console.display(s.getfName() + " " + s.getlName() + " was added to the database");
                Console.displayNewLine();
            }
        } catch (DBException ex) {
            Logger.getLogger(StudentMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateStudent() {
        Console.display("---------- UPDATE STUDENT ----------");
        String id = Console.getString("Enter student id: ");
        Student s = null;
        try {
            s = StudentDB.get(id);
        } catch (DBException ex) {
            Logger.getLogger(StudentMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (s != null) {
            // Get user inputs
            String fname = Console.getString("Enter first name: ");
            String lname = Console.getString("Enter last name: ");
            String gender = Console.getString("Enter your gender: ");
            GenderType sex = GenderType.valueOf(gender.toUpperCase());
            LocalDate dob = Console.getDate("Enter your birth date [yyyy-mm-dd]: ");
            double gpa = Console.getDouble("Enter GPA: ", 0.00, 5.01);
            String email = Console.getString("Enter email: ");
            String phone = Console.getString("Enter phone number: ");

            s.setfName(fname);
            s.setlName(lname);
            s.setGender(sex);
            s.setBirthDate(dob);
            s.setGpa(gpa);
            s.setEmail(email);
            s.setPhone(phone);

            try {
                boolean status = StudentDB.update(s);
                if (status == true) {
                    Console.display(s.getfName() + " " + s.getlName() + " was updated.");
                }
            } catch (DBException ex) {
                Logger.getLogger(StudentMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("No student found with this Id: " + id);
        }
    }

    public static void deleteStudent() {
        Console.display("---------- DELETE STUDENT ----------");
        String id = Console.getString("Enter student id: ");
        Student s = null;
        try {
            s = StudentDB.get(id);
        } catch (DBException ex) {
            Logger.getLogger(StudentMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (s != null) {
            String ans = Console.getString("Are you sure you want delete" + s.getfName() + " " + s.getlName() + "(yes/no)?: ");
            if (ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")) {
                try {
                    boolean status = StudentDB.delete(s);
                    if (status == true) {
                        Console.display(s.getfName() + " " + s.getlName() + " was deleted.");
                    }
                } catch (DBException ex) {
                    Logger.getLogger(StudentMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("No student found with this Id: " + id);
        }
    }

    public static void filterByGender() {
        Console.display("---------- FILTER BY GENDER ----------");
        
        // Get gender from user
        String gender = Console.getString("Enter gender[male/female/other]: ");

       // Get the list of all students from the database
        List<Student> allStudents = null;
        try {
            allStudents = StudentDB.getAll();
        } catch (DBException ex) {
            Logger.getLogger(StudentMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Get the name of given gender students
        Stream<String> listByGender = allStudents.stream()
                .filter(s -> s.getGender().equals(GenderType.valueOf(gender.toUpperCase())))
                .map(name -> name.toString())
                .sorted()
                .distinct();
        
        // Count how many of this gender
        long listByGenderCount = allStudents.stream()
                .filter(s -> s.getGender().equals(GenderType.valueOf(gender.toUpperCase())))
                .count();

        Console.display("---------- LIST OF " + gender.toUpperCase() + " STUDENTS ----------");
        listByGender.forEach(System.out::println);
        Console.display(listByGenderCount + " " + gender + " students found!");
        Console.displayNewLine();
    }

    public static void filterNullEmails() {
        List<Student> allStudents = null;
        try {
            allStudents = StudentDB.getAll();
        } catch (DBException ex) {
            Logger.getLogger(StudentMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<String> nullEmailList = allStudents.stream()
                .filter(s -> s.getEmail().equalsIgnoreCase("null") || s.getPhone().equalsIgnoreCase("null"))
                .map(name -> name.toString())
                .sorted()
                .collect(Collectors.toList());

        Console.display("---------- LIST OF STUDENTS WITHOUT EMAILS ----------");
        nullEmailList.forEach(System.out::println);
        Console.displayNewLine();
        
    }
}
