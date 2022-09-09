package System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.Statement;

public class Addnew {

    @FXML
    private TextField firstnamef;

    @FXML
    private TextField lastnamef;

    @FXML
    private TextField newacnum;

    @FXML
    private TextField titlef;

    @FXML
    private TextField balancef;

    @FXML
    private TextField openingdatef;

    @FXML
    private TextField emailf;

    @FXML
    private TextField passf;

    @FXML
    private TextField confpassf;

    @FXML
    private TextField dobf;

    @FXML
    private TextField idnumf;

    @FXML
    private TextField passnumf;

    @FXML
    private Button confirm;

    @FXML
    private TextField cfacno;

    @FXML
    private TextField cfcardnamef;

    @FXML
    private TextField cfcardnumf;

    @FXML
    private TextField cfcvc;

    @FXML
    private TextField cfcreditf;

    @FXML
    private TextField cfissue;

    @FXML
    private TextField cfexpire;

    @FXML
    private TextField cfcardtype;

    @FXML
    private TextField cfmaxlim;

    @FXML
    private TextField cfpass;

    @FXML
    private TextField cfconpass;

    @FXML
    private Button cardaddctn;

    @FXML
    private TextField phnf;

    @FXML
    private Label msg1;

    @FXML
    private Label msg2;

    @FXML
    void addcard(ActionEvent event) {
        String acno,cardno,cardname,cvc,issu,expire,credit,cardtype,maxlimit,pin,confpin;
        acno=cfacno.getText();
        cardno=cfcardnumf.getText();
        cardname=cfcardnamef.getText();
        cvc=cfcvc.getText();
        credit=cfcreditf.getText();
        issu=cfissue.getText();
        expire=cfexpire.getText();
        cardtype=cfcardtype.getText();
        maxlimit=cfmaxlim.getText();
        pin=cfpass.getText();
        confpin=cfconpass.getText();
        String cardinfo="INSERT cardinfo Value('"+acno+"',"+cardno+",'"+cardname+"','"+cardtype+"','"+pin+"','"+
                cvc+"','"+issu+"','"+expire+"',0.00,"+credit+","+maxlimit+",'Active');";
        if(pin.equals(confpin)){
            Statement statement=DatabaseConnection.Connection();
            try {
                statement.executeUpdate(cardinfo);
                msg2.setText("Card successfully Added.");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }else {
            msg2.setText("Pin doesn't match. Unsuccessful");
        }

    }

    @FXML
    void confirmopen(ActionEvent event) {
        String firstname,lastname,phn,newacno,title,balance,avail_balance,openingdate,email,pass,confpass,birthdate, idnum,passportnum;
        firstname=firstnamef.getText();
        lastname=lastnamef.getText();
        newacno=newacnum.getText();
        title=titlef.getText();
        balance=balancef.getText();
        avail_balance=String.valueOf(Double.parseDouble(balance)-500);
        openingdate=openingdatef.getText();
        email=emailf.getText();
        birthdate=dobf.getText();
        idnum=idnumf.getText();
        passportnum=passf.getText();
        pass=passf.getText();
        phn=phnf.getText();
        confpass=confpassf.getText();
        String accountinfo="INSERT Accountinfo Value ('"+newacno+"','"+email+"','"+title+"','"+balance+"','"+avail_balance+"','"+
                openingdate+"','None','0.00','0.00','00000','Active');";
        String customer="INSERT customer VALUE('"+newacno+"','"+email+"','"+firstname+"','"+lastname+"','"+birthdate+"','"+phn+"','"+idnum+"','"+
                passportnum+"');";
        String logiinfo="INSERT logininfo VAlue('"+email+"','"+pass+"','"+title+"','"+newacno+"');";
        if(pass.equals(confpass)){
            Statement st=DatabaseConnection.Connection();
            try {
                st.executeUpdate(accountinfo);
                st.executeUpdate(customer);
                st.executeUpdate(logiinfo);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                msg1.setText("Databse Connection Error");
            }
            msg1.setText("Successfully Account Created.");
        }else {
            msg1.setText("Password Doesn't Match");
        }

    }

}
