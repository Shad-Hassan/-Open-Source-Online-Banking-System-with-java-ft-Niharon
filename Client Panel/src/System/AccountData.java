package System;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountData {
   private static String AcNo, email,Title,Current_Balance,Available_Balance,Opening_date,
            Last_Trans,Deposit,withdraw,CardNumber,ACstatus;
    String transhistory[]=new String[100];
    int index;

   void getTranshistory(String AC){
       Statement st= DatabaseConnection.Connection();
       try {
           ResultSet res=st.executeQuery("SELECT Details FROM Transhistory WHERE AcNo=\""+AC+"\";");
           index=0;
           while (res.next()) {
                transhistory[index]=res.getString(1);
                index++;
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }

    void getAccountinfo(String AC){
        Statement st= DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("SELECT * FROM Accountinfo WHERE AcNo=\""+AC+"\";");
            while (res.next()){
                for (int i=1;i<=11;i++) {
                    switch(i){

                        case 1:
                            setAcNo(res.getString(i));
                            break;
                        case 2:
                            setEmail(res.getString(i));
                            break;
                        case 3:
                            setTitle(res.getString(i));
                            break;
                        case 4:
                            double d=Double.parseDouble(res.getString(i));
                            String str=String.format("%.2f",d);
                            setCurrent_Balance(str);
                            break;
                        case 5:
                            double d2=Double.parseDouble(res.getString(i));
                            String str2=String.format("%.2f",d2);
                            setAvailable_Balance(str2);
                            break;
                        case 6:
                            setOpening_date(res.getString(i));
                            break;
                        case 7:
                            setLast_Trans(res.getString(i));
                            break;
                        case 8:
                            setDeposit(res.getString(i));
                            break;
                        case 9:
                            setWithdraw(res.getString(i));
                            break;
                        case 10:
                            setCardNumber(res.getString(i));
                            break;
                        case 11:
                            setACstatus(res.getString(i));
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


    public static String getAcNo() {
        return AcNo;
    }

    public void setAcNo(String acNo) {
        AcNo = acNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public static String getCurrent_Balance() {
        return Current_Balance;
    }

    public static void setCurrent_Balance(String current_Balance) {
        Current_Balance = current_Balance;
    }

    public static String getAvailable_Balance() {
        return Available_Balance;
    }

    public static void setAvailable_Balance(String available_Balance) {
        Available_Balance = available_Balance;
    }

    public static String getOpening_date() {
        return Opening_date;
    }

    public void setOpening_date(String opening_date) {
        Opening_date = opening_date;
    }

    public static String getLast_Trans() {
        return Last_Trans;
    }

    public void setLast_Trans(String last_Trans) {
        Last_Trans = last_Trans;
    }

    public static String getDeposit() {
        return Deposit;
    }

    public void setDeposit(String deposit) {
        Deposit = deposit;
    }

    public static String getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(String withdraw) {
        this.withdraw = withdraw;
    }

    public static String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public static String getACstatus() {
        return ACstatus;
    }

    public void setACstatus(String ACstatus) {
        this.ACstatus = ACstatus;
    }
}
