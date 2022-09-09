package System;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerData {
    private String ACno,email,first_name ,last_name,dob,phone ,IDnum ,passport;


    void getCustomerinfo(String AC){
        Statement st=DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("SELECT * FROM Customer WHERE AcNo=\""+AC+"\"");
            while (res.next()){
                for (int i=1;i<=8;i++) {
                    switch(i){
                        case 1:
                            setACno(res.getString(i));
                            break;
                        case 2:
                            setEmail(res.getString(i));
                            break;
                        case 3:
                            setFirst_name(res.getString(i));
                            break;
                        case 4:
                            setLast_name(res.getString(i));
                            break;
                        case 5:
                            setDob(res.getString(i));
                            break;
                        case 6:
                            setPhone(res.getString(i));
                            break;
                        case 7:
                            setIDnum(res.getString(i));
                            break;
                        case 8:
                            setPassport(res.getString(i));
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

    public String getACno() {
        return ACno;
    }

    public void setACno(String ACno) {
        this.ACno = ACno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIDnum() {
        return IDnum;
    }

    public void setIDnum(String IDnum) {
        this.IDnum = IDnum;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
