package System;

import com.sun.javafx.scene.control.skin.resources.ControlResources;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sign_in {

    @FXML
    private Label infolab;

    @FXML
    private TextField userf;

    @FXML
    private Button login;

    @FXML
    private PasswordField passf;

    @FXML
    private Button show;

    @FXML
    private Label about;

    @FXML
    private Label help;

    @FXML
    private Label forget;

    Date dateNow = new Date( );
    SimpleDateFormat date = new SimpleDateFormat ("E dd.MM.yyyy");
    SimpleDateFormat dateTime = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
    String formateddate=date.format(dateNow);
    String formateddateTime=dateTime.format(dateNow);
    Admindata admindata=new Admindata();


    @FXML
    void loginac(ActionEvent event) throws IOException {
        String email=userf.getText();
        String pass=passf.getText();
        admindata.getAdmininfo(email);
        if(email.equals("") || pass.equals("")){
            infolab.setText("Enter Email and Password");
        }else if(email.equalsIgnoreCase(Admindata.getUsername()) && pass.equals(Admindata.getPassword())){
            //Parent root = FXMLLoader.load(getClass().getResource("FXML/Controller.fxml"));
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/Controller.fxml"));
            Parent root=loader.load();
            Controller controller=loader.getController();

            controller.setDate(formateddate);
            //String AC=loginData.getACNo();
            //AccountData accountData=new AccountData();
            //accountData.getAccountinfo(AC);
            //CardData cardData=new CardData();
            //cardData.getCardinfo(AC);
            controller.setDashboardData();

            Stage stage=(Stage)login.getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(root,1063,600));
            stage.setTitle("Admin Panel");
            stage.centerOnScreen();
        }else {
            infolab.setText("Email or Password is Incorrect");
        }

    }

    String s;
    @FXML
    void showp(MouseEvent event) {
        s=passf.getText();
        passf.setText("");
        passf.setPromptText(s);
    }
    @FXML
    void showr(MouseEvent event) {
        passf.setText(s);
    }

    @FXML
    void aboutac(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/About_us.fxml"));
        Stage stage=new Stage();//(Stage)about.getScene().getWindow();
        stage.setScene(new Scene(root,600,400));
        stage.setTitle("About us");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void for_ac(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Forget.fxml"));
        Stage stage=new Stage();
        stage.setScene(new Scene(root,600,400));
        stage.setTitle("Forget Password");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void help_ac(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Help.fxml"));
        Stage stage=new Stage();
        stage.setScene(new Scene(root,600,400));
        stage.setTitle("Forget Password");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
}