package System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    // FIX: Changed 'localhost' to '127.0.0.1' to force TCP/IP connection
    static String url="jdbc:mysql://127.0.0.1:3306/bank";

    // Using the new dedicated user
    static String username="bankerSajid";

    // Using the password you created for that user
    static String pass="MS18QV(.3Cf@Ltzd";

    static Statement statement;
    static Statement Connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            // This line uses the corrected url, username, and password
            Connection con= DriverManager.getConnection(url,username,pass);
            statement=con.createStatement();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Failed to connect with bankerSajid. Check XAMPP.");
        }
        return statement;
    }
}