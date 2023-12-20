/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Abstract class representing a user with common attributes and methods.
 * @author jimok
 */
public abstract class User implements DatabaseConnection {
     private int userID;
    private String username;
    private String password;
    private String name;
    private String surname;

    /**
     * Constructor to initialize user attributes.
     *
     * @param username User's username.
     * @param password User's password.
     * @param name     User's name.
     * @param surname  User's surname.
     */
    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    // Getters and setters for user attributes...

    /**
     * Gets the database connection.
     *
     * @return Connection object representing the database connection.
     * @throws SQLException if a database access error occurs.
     */
    protected Connection getDatabaseConnection() throws SQLException {
        return connect();
    }

    /**
     * Abstract method to display the user menu.
     *
     * @param scanner   Scanner object for user input.
     * @param connection Connection object representing the database connection.
     * @throws SQLException if a database access error occurs.
     */
    public abstract void displayMenu(Scanner scanner, Connection connection) throws SQLException;

    String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getSurname() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}