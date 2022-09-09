package System;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Transaction implements Initializable {

    @FXML
    private TextField transtoAC;

    @FXML
    private PasswordField TransPin;

    @FXML
    private Button transbutton;

    @FXML
    private TextField transAmount;

    @FXML
    private ChoiceBox<String> cardtypechoicebox;
    String card[]={"Visa Card","Master Card"};

    @FXML
    private TextField aCardNo;

    @FXML
    private TextField aExdate;

    @FXML
    private TextField aExyear;

    @FXML
    private TextField acvc;

    @FXML
    private TextField aBillingAdress;

    @FXML
    private TextField aamount;

    @FXML
    private PasswordField apss;

    @FXML
    private Button addMoney;

    @FXML
    private Label DisplayMessage;

    @FXML
    void add(ActionEvent event) {
        String cardno=aCardNo.getText();
        String cardtyp=cardtypechoicebox.getValue();
        String ccvc=acvc.getText();
        String expmon=aExdate.getText();
        String exyear=aExyear.getText();
        String billaddress=aBillingAdress.getText();
        String addamount=aamount.getText();
        String pass=apss.getText();
        if(1==1 /*Condition here*/){
            ClientConection clientConection=new ClientConection();
            try {
                NetworkConnection networkConnection=new NetworkConnection(clientConection.getServerSocket());
                String cmd="Add@"+AccountData.getAcNo()+"@"+cardtyp+"@"+cardno+"@"+expmon+"/"+exyear+"@"+billaddress+"@"+addamount;
                networkConnection.write(cmd);
                String r=(String) networkConnection.read();
                System.out.println(r);
                if (r.equals("Successful")){
                    DisplayMessage.setText("Successfully Money Added.");
                }
                clientConection.CloseConection();

            } catch (IOException e) {
                DisplayMessage.setText("Server Connection Error . Check your Internet Connection.");
                e.printStackTrace();
            }
        }else {
            DisplayMessage.setText("Please Enter Correct Information.");
        }
    }

    @FXML
    void transfer(ActionEvent event) {
        String toAC = transtoAC.getText();
        String amount = transAmount.getText();
        double toamount=0;
        try {
            toamount = Double.parseDouble(amount);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(toAC.equals("")|| amount.equals("")||TransPin.getText().equals("")){
                DisplayMessage.setText("Please Enter all Required Information");
        }else if( TransPin.getText().equals(LoginData.getPassword())  && Double.parseDouble(AccountData.getAvailable_Balance())>toamount){
             ClientConection clientConection=new ClientConection();
            try {

                NetworkConnection networkConnection=new NetworkConnection(clientConection.getServerSocket());
                String cmd="Transfer@"+AccountData.getAcNo()+"@"+toAC+"@"+amount;
                networkConnection.write(cmd);
                String r=(String) networkConnection.read();
                System.out.println(r);
                if (r.equals("Successful")){
                    DisplayMessage.setText("Transfer Successful.");
                }
                clientConection.CloseConection();

            } catch (IOException e) {
                DisplayMessage.setText("Server Connection Error . Check your Internet Connection.");
                e.printStackTrace();
            }
        }else {
            DisplayMessage.setText("Please Enter Correct Information.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cardtypechoicebox.getItems().addAll(card);
        cardtypechoicebox.getSelectionModel().selectFirst();
    }
}