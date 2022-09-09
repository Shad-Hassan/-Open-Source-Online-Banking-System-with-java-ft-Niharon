package System;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Cards {

    @FXML
    private Label lname;

    @FXML
    private Label lnum;

    @FXML
    private Label ltype;

    @FXML
    private Label lab10;

    @FXML
    private Label lab11;

    @FXML
    private Label lab16;

    @FXML
    private Label lab13;

    @FXML
    private Label lab14;

    @FXML
    private Label lab15;

    @FXML
    private Label lab12;

    @FXML
    private Label lab17;

    @FXML
    private Label lab18;

    @FXML
    private Label lab19;

    @FXML
    private Label lab20;


    public void setCardData(){
        lname.setText(CardData.getCardname());
        lnum.setText(CardData.getCardNumber());
        ltype.setText(CardData.getCardtype());
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
    }

}

