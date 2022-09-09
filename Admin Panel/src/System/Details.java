package System;

import javafx.fxml.FXML;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.awt.*;
import java.util.Enumeration;

public class Details {

    @FXML
    private VBox aclistbox;

    @FXML
    private Label lab10;

    @FXML
    private Label lab11;

    @FXML
    private Label lab12;

    @FXML
    private Label lab13;

    @FXML
    private Label lab14;

    @FXML
    private Label lab15;

    @FXML
    private Label lacstatus;

    @FXML
    private Label lwithdraw;

    @FXML
    private Label ldeposit;

    @FXML
    private Label laco;

    @FXML
    private Label lab101;

    @FXML
    private Label lab111;

    @FXML
    private Label lab121;

    @FXML
    private Label lab131;

    @FXML
    private Label lab141;

    @FXML
    private Label lab151;

    @FXML
    private Label lab16;

    @FXML
    private Label lab17;

    @FXML
    private Label lab18;

    @FXML
    private Label lab19;

    @FXML
    private Label lab20;

    @FXML
    private Label email2;

    @FXML
    private Label fn;

    @FXML
    private Label ln;

    @FXML
    private Label dob;

    @FXML
    private Label phn;

    @FXML
    private Label id;

    @FXML
    private Label pp;

    void setSearchData(String ACNO){
        AccountData accountData=new AccountData();
        accountData.getAccountinfo(ACNO);
        CardData cardData=new CardData();
        cardData.getCardinfo(ACNO);
        CustomerData customerData=new CustomerData();
        customerData.getCustomerinfo(ACNO);
        laco.setText("AC No : "+AccountData.getAcNo());
        ldeposit.setText(AccountData.getDeposit()+"$");
        lwithdraw.setText(AccountData.getWithdraw()+"$");
        lab10.setText(AccountData.getAcNo());
        lab11.setText(AccountData.getTitle());
        lab12.setText(AccountData.getOpening_date());
        lab13.setText(AccountData.getCurrent_Balance());
        lab14.setText(AccountData.getAvailable_Balance());
        lab15.setText(AccountData.getLast_Trans());
        lacstatus.setText(AccountData.getACstatus());
        lab10.setText(CardData.getCardname());
        lab11.setText(CardData.getCardNumber());
        lab12.setText(CardData.getCvc());
        lab13.setText(AccountData.getAvailable_Balance());
        lab14.setText(CardData.getIssue());
        lab15.setText(CardData.getExpired());
        lab16.setText(CardData.getCardtype());
        lab18.setText(CardData.getCredit());
        lab19.setText(CardData.getMaxlimit());
        lab20.setText(CardData.getCardstatus());
        email2.setText(accountData.getEmail());
        fn.setText(customerData.getFirst_name());
        ln.setText(customerData.getLast_name());
        dob.setText(customerData.getDob());
        phn.setText(customerData.getPhone());
        id.setText(customerData.getIDnum());
        phn.setText(customerData.getPassport());

    }

    void setaclist(){
        Admindata a=new Admindata();
        a.getAccountinfoList();
        Pane pane[]=new Pane[100];
        Label label[]=new Label[100];
        Enumeration e=a.aclist.keys();
        String str;
        int i=0;
        double aclistboxminheight=0;
        while (e.hasMoreElements()){
            pane[i]=new Pane();
            label[i]=new Label();
            aclistbox.setMinHeight(aclistboxminheight);
            pane[i].setMinSize(183,32);
            pane[i].setMaxSize(183,32);
            label[i].setText( "  "+e.nextElement());
            label[i].setMinSize(183,32);
            label[i].setMaxSize(183,32);
            label[i].setFont(Font.font(16));
            label[i].setContentDisplay(ContentDisplay.CENTER);
            pane[i].getChildren().add(label[i]);
            aclistbox.getChildren().add(pane[i]);
            i++;

        }
    }

}

