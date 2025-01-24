package bank.management.system;

import java.sql.*;

public class conn {
    
    // Connection object
    public Connection con;
    // Statement object
    public Statement stmt;
    
    public conn() {
        try {
            // Establish connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankmanagementsystem", "root", "root");
            System.out.println("Database connection established successfully!");
            
            // Create a statement
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

