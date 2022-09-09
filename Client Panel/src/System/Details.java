package System;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Details {

    @FXML
    private Label acno;

    @FXML
    private TextArea historyfield;

    @FXML
    private Label name;

    @FXML
    private Label email;

    @FXML
    private Label avbal;

    @FXML
    private Label opening_date;

    @FXML
    private Label lasttrans;

    @FXML
    private Label email2;

    @FXML
    private Label id;

    @FXML
    private Label fn;

    @FXML
    private Label ln;

    @FXML
    private Label dob;

    @FXML
    private Label phn;

    @FXML
    private Label pp;

    void setDetails(){
        AccountData accountData=new AccountData();
        accountData.getAccountinfo(AccountData.getAcNo());
        CustomerData customerData=new CustomerData();
        customerData.getCustomerinfo(AccountData.getAcNo());
        acno.setText(accountData.getAcNo());
        name.setText(accountData.getTitle());
        email.setText(accountData.getEmail());
        avbal.setText(AccountData.getAvailable_Balance());
        opening_date.setText(accountData.getOpening_date());
        lasttrans.setText(accountData.getLast_Trans());
        email2.setText(accountData.getEmail());
        fn.setText(customerData.getFirst_name());
        ln.setText(customerData.getLast_name());
        dob.setText(customerData.getDob());
        phn.setText(customerData.getPhone());
        id.setText(customerData.getIDnum());
        phn.setText(customerData.getPassport());
        accountData.getTranshistory(AccountData.getAcNo());
        String str="";
        for(int i=0;i<accountData.index;i++){
            str=str+accountData.transhistory[i]+"\n";
            historyfield.setText(str);
        }

    }

}
