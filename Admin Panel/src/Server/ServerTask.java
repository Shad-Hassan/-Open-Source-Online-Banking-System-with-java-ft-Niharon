package Server;

import java.sql.SQLException;
import java.sql.Statement;

public class ServerTask {
    static void TransferTask(String from,String to,String amount, Statement statement,NetworkConnection n){
        String quaryfrom="UPDATE Accountinfo SET Current_Balance=Current_Balance-"+amount+",Available_Balance=Available_Balance-"+amount+",Withdraw=Withdraw+"+amount+" WHERE AcNo=\""+from+"\";";
        String quaryto="UPDATE Accountinfo SET Current_Balance=Current_Balance+"+amount+",Available_Balance=Available_Balance+"+amount+",Deposit=Deposit+"+amount+" WHERE AcNo=\""+to+"\";";
        String details="Money Transfered from "+from+" To "+to+" Amount= "+amount;
        String trans="INSERT Transhistory Value("+from+",'"+details+"' );";
        try {
            System.out.println(quaryfrom);
            statement.executeUpdate(quaryfrom);
            statement.executeUpdate(quaryto);
            statement.executeUpdate(trans);
            n.write("Successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static void Add(String Acno, String amount, Statement statement,NetworkConnection n){
        String quary="UPDATE Accountinfo SET Current_Balance=Current_Balance+"+amount+",Available_Balance=Available_Balance+"+amount+",Deposit=Deposit+"+amount+" WHERE AcNo=\""+Acno+"\";";
        String details="Money Added "+amount;
        String trans="INSERT Transhistory Value("+Acno+",'"+details+"' );";
        try {
            statement.executeUpdate(quary);
            statement.executeUpdate(trans);
            n.write("Successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static void Withdraw(String Acno, String amount, Statement statement,NetworkConnection n){
        String quary="UPDATE Accountinfo SET Current_Balance=Current_Balance-"+amount+",Available_Balance=Available_Balance+"+amount+",Withdraw=Withdraw+"+amount+" WHERE AcNo=\""+Acno+"\";";
        String details="Money Withdraw "+amount;
        String trans="INSERT Transhistory Value("+Acno+",'"+details+"' );";
        try {
            statement.executeUpdate(quary);
            statement.executeUpdate(trans);
            n.write("Successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static void WithdrawAll(String amount, Statement statement,NetworkConnection n){
        String quary="UPDATE Accountinfo SET Current_Balance=Current_Balance-"+amount+",Available_Balance=Available_Balance+"+amount;
        try {
            statement.executeUpdate(quary);
            n.write("Successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
