package System;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CardData {
    private static String AcNo,CardNumber,cardname,cardtype,pin,cvc,Issue,Expired,Bill,credit,Maxlimit
            ,cardstatus;


    void getCardinfo(String AC){
        Statement st=DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("SELECT * FROM Cardinfo WHERE AcNo=\""+AC+"\"");
            while (res.next()){
                for (int i=1;i<=12;i++) {
                    switch(i){
                        case 1:
                            setAcNo(res.getString(i));
                            break;
                        case 2:
                            setCardNumber(res.getString(i));
                            break;
                        case 3:
                            setCardname(res.getString(i));
                            break;
                        case 4:
                            setCardtype(res.getString(i));
                            break;
                        case 5:
                            setPin(res.getString(i));
                            break;
                        case 6:
                            setCvc(res.getString(i));
                            break;
                        case 7:
                            setIssue(res.getString(i));
                            break;
                        case 8:
                            setExpired(res.getString(i));
                            break;
                        case 9:
                            setBill(res.getString(i));
                            break;
                        case 10:
                            setCredit(res.getString(i));
                            break;
                        case 11:
                            setMaxlimit(res.getString(i));
                            break;
                        case 12:
                            setCardstatus(res.getString(i));
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

    public static String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public static String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public static String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public static String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public static String getCvc() {
        return cvc;
    }

    public void setCvc(String otp) {
        this.cvc = otp;
    }

    public static String getIssue() {
        return Issue;
    }

    public void setIssue(String issue) {
        Issue = issue;
    }

    public static String getExpired() {
        return Expired;
    }

    public void setExpired(String expired) {
        Expired = expired;
    }

    public static String getBill() {
        return Bill;
    }

    public void setBill(String bill) {
        Bill = bill;
    }

    public static String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public static String getMaxlimit() {
        return Maxlimit;
    }

    public void setMaxlimit(String maxlimit) {
        Maxlimit = maxlimit;
    }

    public static String getCardstatus() {
        return cardstatus;
    }

    public void setCardstatus(String cardstatus) {
        this.cardstatus = cardstatus;
    }
}
