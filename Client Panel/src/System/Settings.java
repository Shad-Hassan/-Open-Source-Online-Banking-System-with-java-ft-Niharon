package System;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.sql.SQLException;
import java.sql.Statement;

public class Settings {

    @FXML
    private PasswordField oldpass;

    @FXML
    private PasswordField newpass;

    @FXML
    private PasswordField confpass;

    @FXML
    private Button changebutton;

    @FXML
    private Label passmes;

    @FXML
    void change(ActionEvent event) {
        if(oldpass.getText().equals(LoginData.getPassword()) && newpass.getText().equals(confpass.getText())){
        Statement statement=DatabaseConnection.Connection();
        String update="Update logininfo SET password='"+newpass.getText()+"' WHERE AcNo='"+AccountData.getAcNo()+"'";
            try {
                statement.executeUpdate(update);
                passmes.setText("Password Updated");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                passmes.setText("Failed");
            }

        }else if(oldpass.getText().compareTo(LoginData.getPassword())!=0) {
            passmes.setText("Enter correct password");
        }else{
            passmes.setText("Password doesn't match");
        }
    }
}