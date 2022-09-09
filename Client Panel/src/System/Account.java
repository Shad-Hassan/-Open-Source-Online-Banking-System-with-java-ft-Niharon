package System;

import com.mysql.cj.xdevapi.Result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
    String Acnumber;

    public Account(String acnumber) {
        Acnumber = acnumber;
    }
    public double deposit(double balance,double amount){
        return balance-amount;
    }
    public  double withdraw(double balance,double amount){
        return balance-amount;
    }
    public static void transferDatabaseUpdate(String AC,double updatedCb,double updatedAb) throws Exception{
        Statement statement=DatabaseConnection.Connection();
        String quary="Update Accountinfo SET Available_Balance='"+updatedAb+"',Current_Balance='"+updatedCb+
                "' WHERE AcNo='"+AC+"';";
        statement.executeQuery(quary);
    }
    public double Admin_Toatal(DatabaseConnection databaseConnection,String str) throws SQLException {
        Statement statement=databaseConnection.Connection();
        ResultSet resultSet=statement.executeQuery(str);
        double res=0;
        while (resultSet.next()){
            res=res+ Double.parseDouble(resultSet.getString(1));
        }
        return res;
    }
    public void update(DatabaseConnection databaseConnection,String str) throws SQLException {
        Statement statement=databaseConnection.Connection();
        ResultSet resultSet=statement.executeQuery(str);
    }


}
