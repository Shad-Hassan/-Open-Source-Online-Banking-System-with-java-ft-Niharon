package System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    // FIX 1: Changed 'localhost' to '127.0.0.1' for stable TCP/IP connection.
    static String url="jdbc:mysql://127.0.0.1:3306/bank";

    // FIX 2: Using the dedicated user created in phpMyAdmin.
    static String username="bankerSajid";

    // FIX 3: Using the password created for that user.
    static String pass="MS18QV(.3Cf@Ltzd";

    static Statement statement;

    public static Statement Connection(){ // Changed to public static for consistency
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Connection con= DriverManager.getConnection(url,username,pass);
            statement=con.createStatement();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Client Database Connection Failed. Verify XAMPP and credentials.");
        }
        return statement;
    }
}