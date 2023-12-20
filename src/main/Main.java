/*
 * Screencast link: c:/Users/jimok/Videos/Debut/2023-12-20_05-15-31 - jimok.mp4
 *GitHub link: https://github.com/Jimokunbor/Main
 * Group Member 1 Name: Okunbor James Ehigiamusoe
 * Group Member 1 Student Number: 2022473
 * Group Member 2 Name: Gustavo Almeida
 * Group Member 2 Student Number: 2022553
 * Task completed by two
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author jimok
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // File: Main.java
         
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "password")) {
            System.out.println("Connected to MySQL server");

            createDatabase(connection, "ooc2023");
            connection.setCatalog("ooc2023");

            createUsersTable(connection);

            User currentUser = authenticateUser(scanner, connection);

            if (currentUser != null) {
                currentUser.displayMenu(scanner, connection);
            } else {
                System.out.println("Invalid credentials. Exiting program.");
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void createDatabase(Connection connection, String databaseName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
            System.out.println("Database '" + databaseName + "' created or already exists");
        }
    }

    private static void createUsersTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Users ("
                + "userID INT AUTO_INCREMENT PRIMARY KEY,"
                + "username VARCHAR(255) NOT NULL,"
                + "password VARCHAR(255) NOT NULL,"
                + "name VARCHAR(255) NOT NULL,"
                + "surname VARCHAR(255) NOT NULL,"
                + "userType VARCHAR(50) NOT NULL"
                + ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Users table created or already exists");
        }
    }

    private static User authenticateUser(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (DatabaseManager.authenticateUser(connection, username, password, UserType.ADMIN)) {
            AdminUser adminUser = new AdminUser(username, password, "AdminName", "AdminSurname");
            writeUserToDatabase(connection, adminUser);
            return adminUser;
        } else if (DatabaseManager.authenticateUser(connection, username, password, UserType.REGULAR)) {
            RegularUser regularUser = new RegularUser(username, password, "RegularName", "RegularSurname");
            writeUserToDatabase(connection, regularUser);
            return regularUser;
        }

        return null;
    }

    private static void writeUserToDatabase(Connection connection, User user) throws SQLException {
        String insertUserSQL = "INSERT INTO Users (username, password, name, surname, userType) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertUserSQL)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user instanceof AdminUser ? "Admin" : "RegularUser");

            statement.executeUpdate();
            System.out.println("User '" + user.getUsername() + "' inserted into the database");
        }
    }
}