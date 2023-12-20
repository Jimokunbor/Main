/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DatabaseManager class provides methods for authenticating users.
 * @author jimok
 */
public class DatabaseManager implements DatabaseConnection {
    /**
     * Authenticates a user based on username, password, and user type.
     *
     * @param connection Database connection.
     * @param username   User's username.
     * @param password   User's password.
     * @param userType   User's type (ADMIN or REGULAR).
     * @return True if authentication is successful, false otherwise.
     * @throws SQLException if a database access error occurs.
     */
    public static boolean authenticateUser(Connection connection, String username, String password, UserType userType) throws SQLException {
        String query;
        if (userType == UserType.ADMIN) {
            query = "SELECT * FROM Users WHERE username = ? AND password = ? AND userType = 'Admin'";
        } else if (userType == UserType.REGULAR) {
            query = "SELECT * FROM Users WHERE username = ? AND password = ? AND userType = 'RegularUser'";
        } else {
            return false; // Invalid user type
        }

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
}
