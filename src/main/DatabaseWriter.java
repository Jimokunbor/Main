/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DatabaseWriter interface provides a method for writing user information to the database.
 * @author jimok
 */
public interface DatabaseWriter {
    /**
     * Writes user information to the database.
     *
     * @param connection Connection object representing the database connection.
     * @param user User object containing user information.
     * @throws SQLException if a database access error occurs.
     */
    void writeUserToDatabase(Connection connection, User user) throws SQLException;
}
