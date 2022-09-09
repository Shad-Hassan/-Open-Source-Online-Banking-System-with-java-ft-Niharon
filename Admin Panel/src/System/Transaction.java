package System;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Transaction implements Initializable {

    @FXML
    private TextField transtoAC;

    @FXML
    private Button transbutton;

    @FXML
    private TextField transAmount;

    @FXML
    private TextField dwac;

    @FXML
    private TextField dwamount;

    @FXML
    private Button depbtn;

    @FXML
    private Button withbtn;


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
    private Button addMoney;

    @FXML
    private Label DisplayMessage;

    @FXML
    void depositac(ActionEvent event) {
        String acnum=dwac.getText();
        String amount=dwamount.getText();
        if(1==1/*Condition here*/){
            String cmd="Deposit@"+acnum+"@"+amount;
            ClientConection clientConection=new ClientConection();
            try {
                NetworkConnection networkConnection=new NetworkConnection(clientConection.getServerSocket());
                networkConnection.write(cmd);
                String r=(String) networkConnection.read();
                System.out.println(r);
                if (r.equals("Successful")){
                    DisplayMessage.setText("Deposit Successful.");
                }
                clientConection.CloseConection();

            } catch (IOException e) {
                DisplayMessage.setText("Server Connection Error . Check your Internet Connection.");
                e.printStackTrace();
            }
        }else{
        DisplayMessage.setText("Please Enter Correct Information.");
        }
    }

    @FXML
    void withdrawac(ActionEvent event) {
        String acnum=dwac.getText();
        String amount=dwamount.getText();
        if(1==1/*Condition here*/){
            String cmd="Withdraw@"+acnum+"@"+amount;
            ClientConection clientConection=new ClientConection();
            try {
                NetworkConnection networkConnection=new NetworkConnection(clientConection.getServerSocket());
                networkConnection.write(cmd);
                String r=(String) networkConnection.read();
                System.out.println(r);
                if (r.equals("Successful")){
                    DisplayMessage.setText("Withdraw Successful.");
                }
                clientConection.CloseConection();

            } catch (IOException e) {
                DisplayMessage.setText("Server Connection Error . Check your Internet Connection.");
                e.printStackTrace();
            }
        }else{
            DisplayMessage.setText("Please Enter Correct Information.");
        }
    }


    @FXML
    void add(ActionEvent event) {
        String cardno=aCardNo.getText();
        String cardtyp=cardtypechoicebox.getValue();
        String ccvc=acvc.getText();
        String expmon=aExdate.getText();
        String exyear=aExyear.getText();
        String billaddress=aBillingAdress.getText();
        String addamount=aamount.getText();
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
        if(toAC.equals("")|| amount.equals("")){
                DisplayMessage.setText("Please Enter all Required Information");
        }else if(Double.parseDouble(AccountData.getAvailable_Balance())>toamount){
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