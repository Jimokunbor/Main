/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class representing an admin user with specific menu options.
 * @author jimok
 */
public class AdminUser extends User {
    public AdminUser(String username, String password, String name, String surname) {
        super(username, password, name, surname);
    }

    @Override
    public void displayMenu(Scanner scanner, Connection connection) throws SQLException {
        int choice;
        do {
            System.out.println("Admin User Menu:");
            System.out.println("1. Modify Profile");
            System.out.println("2. List All Users");
            System.out.println("3. Remove User");
            System.out.println("4. Review Operations");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    // Implement menu options...
                    case 1:
                        System.out.println("Modify Profile");
                        break;
                    case 2:
                        System.out.println("List All Users");
                        break;
                    case 3:
                        System.out.println("Remove User");
                        break;
                    case 4:
                        System.out.println("Review Operations");
                        break;
                    case 5:
                        System.out.println("Exiting Admin User Menu");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                choice = 0; // Reset choice to continue the loop
            }
        } while (choice != 5);
    }
}
