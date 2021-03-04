package com.sulbasoft.ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author M. S. Ali (CCS)
 */
public class Console {

    private static final Scanner sc = new Scanner(System.in);

    public static void displayNewLine() {
        System.out.println();
    }

    public static void display(String string) {
        System.out.println(string);
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();        // read the whole line
        return s;
    }

    public static LocalDate getDate(String prompt) {
        boolean isValid = false;
        LocalDate date = null;
        while (isValid == false) {
            System.out.print(prompt);
            try {
                date = LocalDate.parse(sc.next());
                isValid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error! Invalid date value. Try again.");
            }
        }
        return date;
    }

    public static int getInt(String prompt) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            try {
                i = Integer.parseInt(sc.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid integer value. Try again.");
            }
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(prompt);
            if (i <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min);
            } else if (i >= max) {
                System.out.println(
                        "Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(String prompt) {
        double d = 0;
        while (true) {
            System.out.print(prompt);
            try {
                d = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
        }
        return d;
    }

    public static double getDouble(String prompt,
            double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(prompt);
            if (d <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min);
            } else if (d >= max) {
                System.out.println(
                        "Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return d;
    }
}
