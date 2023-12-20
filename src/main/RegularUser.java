/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Class representing a regular user with specific menu options.
 * @author jimok
 */
public class RegularUser extends User {
    public RegularUser(String username, String password, String name, String surname) {
        super(username, password, name, surname);
    }

    @Override
    public void displayMenu(Scanner scanner, Connection connection) throws SQLException {
        int choice;
        do {
            System.out.println("Regular User Menu:");
            System.out.println("1. Modify Profile");
            System.out.println("2. Calculate Tax");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                // Implement menu options...
                case 1:
                    System.out.println("Modify Profile");
                    break;
                case 2:
                    System.out.println("Calculate Tax");
                    break;
                case 3:
                    System.out.println("Exiting Regular User Menu");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 3);
    }
}