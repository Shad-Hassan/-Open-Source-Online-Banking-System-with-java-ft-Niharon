package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    static String url="jdbc:mysql://localhost:3306/bank";
    static String username="root";
    static String pass="admin";
    static Statement statement;
     static Statement Connection(){
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
        }
        return statement;
    }
}
