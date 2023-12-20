/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *DatabaseConnection interface provides methods for connecting to a MySQL database.
 * @author jimok
 */
public interface DatabaseConnection {
    // JDBC connection URL
    String jdbcUrl = "jdbc:mysql://localhost:3306/ooc2023";
    // Database username
    String dbUser = "ooc2023";
    // Database password
    String dbPassword = "ooc2023";

    /**
     * Establishes a connection to the MySQL database.
     *
     * @return Connection object representing the database connection.
     * @throws SQLException if a database access error occurs.
     */
    default Connection connect() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
    }
}
    

