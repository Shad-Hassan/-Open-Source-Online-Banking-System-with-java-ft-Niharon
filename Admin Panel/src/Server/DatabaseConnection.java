package Server; // Ensure the correct package name

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    // Using the stable IP address from the System package file
    static String url="jdbc:mysql://127.0.0.1:3306/bank";

    // Using the dedicated user created in phpMyAdmin
    static String username="bankerSajid";

    // Using the password created for that user
    static String pass="MS18QV(.3Cf@Ltzd";

    static Statement statement;

    public static Statement Connection(){ // Added 'public static' for consistency
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
            System.err.println("Database Connection Failed. Please verify user 'bankerSajid' and its password in phpMyAdmin.");
        }
        return statement;
    }
}