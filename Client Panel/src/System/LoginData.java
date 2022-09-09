package System;


import java.sql.*;

public class LoginData {
    private String email,username,ACNo;
    private static String password;

    void getlogininfo(String email){
        Statement st= DatabaseConnection.Connection();
        try {
            ResultSet res=st.executeQuery("SELECT * FROM logininfo WHERE email=\""+email+"\"");
            while (res.next()){
                for (int i=1;i<=4;i++) {
                    switch(i){
                        case 1:
                            setEmail(res.getString(i));
                            break;
                        case 2:
                            setPassword(res.getString(i));
                            break;
                        case 3:
                            setUsername(res.getString(i));
                            break;
                        case 4:
                            setACNo(res.getString(i));
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getACNo() {
        return ACNo;
    }
    public void setACNo(String ACNo) {
        this.ACNo = ACNo;
    }
}
