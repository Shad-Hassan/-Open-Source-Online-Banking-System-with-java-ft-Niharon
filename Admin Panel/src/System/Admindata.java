package System;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Hashtable;

public class Admindata {
    private static String username,password;
    Hashtable<String,AccountList> aclist=new Hashtable<String,AccountList>();

    double getAvailableBalance(){
        double totalAvailable_Balance=0;
        Statement st=DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("select Available_Balance FROM accountinfo;");
            while (res.next()){
                totalAvailable_Balance=totalAvailable_Balance+Double.parseDouble(res.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return totalAvailable_Balance;
    }

    double getDeposit(){
        double Deposit=0;
        Statement st=DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("select Deposit FROM accountinfo;");
            while (res.next()){
                Deposit=Deposit+Double.parseDouble(res.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Deposit;
    }

    double getWithdraw(){
        double Withdraw=0;
        Statement st=DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("select Deposit FROM accountinfo;");
            while (res.next()){
                Withdraw=Withdraw+Double.parseDouble(res.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Withdraw;
    }


    double getCurrentBalance(){
        double Balance=0;
        Statement st=DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("select Current_Balance FROM accountinfo;");
            while (res.next()){
                Balance=Balance+Double.parseDouble(res.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Balance;
    }

    int getNumofAC(){
        int num=0;
        Statement st=DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("select AcNo FROM accountinfo;");
            while (res.next()){
                num=num+1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    void getAccountinfoList(){
        Statement st=DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("select * FROM accountinfo;");
            while (res.next()){
                for (int i=1;i<=11;i++){
                    aclist.put(res.getString(1),new AccountList(
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5),
                            res.getString(6),
                            res.getString(7),
                            res.getString(8),
                            res.getString(9),
                            res.getString(10),
                            res.getString(11)));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void getAdmininfo(String username){
        Statement st=DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("SELECT * FROM Admin WHERE username='"+username+"'");
            while (res.next()){
                for (int i=1;i<=2;i++) {
                    switch(i){
                        case 1:
                            setUsername(res.getString(i));
                            break;
                        case 2:
                            setPassword(res.getString(i));
                            break;
                        default:
                            System.out.println("Data Read Error");
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static String Strformat(String... str){
        String s="";
        for (String data:str){
            s=s+data+"   ";
        }
        s=s+"\n";
        return s;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String user) {
        username = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String pass) {
        password = pass;
    }
}
