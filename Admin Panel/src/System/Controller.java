package System;

import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.Icon;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Controller{

    @FXML
    private ImageView searchbtn;

    @FXML
    private ImageView transicon;

    @FXML
    private ImageView detailicon;

    @FXML
    private ImageView cardicon;

    @FXML
    private ImageView setticon;

    @FXML
    private ImageView abouticon;

    @FXML
    private ImageView exiticon;

    @FXML
    private ImageView menu;

    @FXML
    private BorderPane sidebar;

    @FXML
    private BorderPane view;

    @FXML
    private Label cards;

    @FXML
    private Label details;

    @FXML
    private Label settings;

    @FXML
    private Label exit;

    @FXML
    private Label transaction;

    @FXML
    private Label dashboard;

    @FXML
    private Label aboutus;

    @FXML
    private TextField srchbox;

    @FXML
    private Icon srchbtn;

    @FXML
    private Icon message;

    @FXML
    private Icon notification;

    @FXML
    private Avatar avater;

    @FXML
    private Label title;

    @FXML
    private AnchorPane balance_pane;

    @FXML
    private Label lAcno;

    @FXML
    private Label balance;

    @FXML
    private Label lwithdraw;

    @FXML
    private Label ldeposit;

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
    public Label dateview;

    @FXML
    private Label lcnum;

    @FXML
    private Label lcname;

    @FXML
    private Label lctype;

    @FXML
    private ImageView dashicon;

    @FXML
    void searchaction(MouseEvent event) throws Exception {
        if(srchbox.getText().equals("")){
            System.out.println("Enter AC No");
        }else {
            String ACNIO=srchbox.getText();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/Details.fxml"));
            Parent root=loader.load();
            Details details=loader.getController();
            details.setaclist();
            details.setSearchData(ACNIO);
            BorderPane p=(BorderPane)root;
            view.setCenter(p);
        }
    }

    void Dashboard() throws IOException {
        title.setText("Dashboard");
        //Parent root = FXMLLoader.load(getClass().getResource("FXML/Dashboard.fxml"));
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/Dashboard.fxml"));
        Parent root=loader.load();
        Dashboard dashboard=loader.getController();
        dashboard.setDashboardViewData();
        BorderPane p= (BorderPane) root;
        view.setCenter(p);
    }
    void Trans() throws IOException {
        title.setText("Transaction");
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Transaction.fxml"));
        BorderPane p= (BorderPane) root;
        view.setCenter(p);
    }
    void Card() throws IOException {
        title.setText("New Account");
        //Parent root = FXMLLoader.load(getClass().getResource("FXML/Cards.fxml"));
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/Addnew.fxml"));
        Parent root=loader.load();
        Addnew addnew=loader.getController();
        //cards.setCardData();
        BorderPane p= (BorderPane) root;
        view.setCenter(p);
    }
    void Details() throws IOException {
        title.setText("Details");
        //Parent root = FXMLLoader.load(getClass().getResource("FXML/Details.fxml"));
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/Details.fxml"));
        Parent root=loader.load();
        Details details=loader.getController();
        details.setaclist();
        BorderPane p=(BorderPane)root;
        view.setCenter(p);

    }
    void Settings() throws IOException {
        title.setText("Settings");
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Settings.fxml"));
        BorderPane p= (BorderPane) root;
        view.setCenter(p);
    }
    void About() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/About_us.fxml"));
        Stage stage=new Stage();//(Stage)aboutus.getScene().getWindow();
        stage.setScene(new Scene(root,600,400));
        stage.setTitle("About us");
        stage.centerOnScreen();
        stage.show();
    }
    void Exit(){
        System.exit(0);
    }

    @FXML
    void abou_ac(MouseEvent event) throws IOException {
        About();
    }

    @FXML
    void cards_ac(MouseEvent event) throws IOException {
        Card();
    }

    @FXML
    void dash_ac(MouseEvent event) throws IOException {
        Dashboard();
    }
    @FXML
    void sett_ac(MouseEvent event) throws IOException {
        Settings();
    }

    @FXML
    void trans_ac(MouseEvent event) throws IOException {
        Trans();
    }

    @FXML
    void detail_ac(MouseEvent event) throws IOException {
        Details();
    }

    @FXML
    void exit_ac(MouseEvent event) {
        Exit();
    }

    int click=0;
    @FXML
    void menu_ac(MouseEvent event) {
        if(click==1){
            dashboard.setVisible(false);
            transaction.setVisible(false);
            cards.setVisible(false);
            details.setVisible(false);
            settings.setVisible(false);
            exit.setVisible(false);
            aboutus.setVisible(false);
            sidebar.setPrefWidth(56);
            balance_pane.setPrefWidth(345);
            click=0;
        }else {
            dashboard.setVisible(true);
            transaction.setVisible(true);
            cards.setVisible(true);
            details.setVisible(true);
            settings.setVisible(true);
            exit.setVisible(true);
            aboutus.setVisible(true);
            sidebar.setPrefWidth(170);
            balance_pane.setPrefWidth(257);
            click=1;
        }
    }

    @FXML
    void dashmc(MouseEvent event) throws IOException {
        Dashboard();
    }
    @FXML
    void transmc(MouseEvent event) throws IOException {
        Trans();
    }

    @FXML
    void cardmc(MouseEvent event) throws IOException {
        Card();
    }
    @FXML
    void detailmc(MouseEvent event) throws IOException {
        Details();
    }

    @FXML
    void settmc(MouseEvent event) throws IOException {
        Settings();
    }
    @FXML
    void aboutmc(MouseEvent event) throws IOException {
        About();
    }
    @FXML
    void exitmc(MouseEvent event) {
        Exit();
    }


    public void setDate(String str){
        dateview.setText(str);
    }
    public void setDashboardData(){

        /*lAcno.setText("AC No : "+AccountData.getAcNo());
        balance.setText(AccountData.getAvailable_Balance());
        ldeposit.setText(AccountData.getDeposit()+"$");
        lwithdraw.setText(AccountData.getWithdraw()+"$");
        lab10.setText(AccountData.getAcNo());
        lab11.setText(AccountData.getTitle());
        lab12.setText(AccountData.getOpening_date());
        lab13.setText(AccountData.getCurrent_Balance());
        lab14.setText(AccountData.getAvailable_Balance());
        lab15.setText(AccountData.getLast_Trans());
        lacstatus.setText(AccountData.getACstatus());
        lcname.setText(CardData.getCardname());
        lcnum.setText(CardData.getCardNumber());
        lctype.setText(CardData.getCardtype());*/
        Admindata admindata=new Admindata();
        String ab=String.format("%.2f",admindata.getAvailableBalance());
        String cb=String.format("%.2f",admindata.getCurrentBalance());
        balance.setText(ab);
        lab10.setText(admindata.getNumofAC()+"");
        lab13.setText(cb + " $");
        lab14.setText(ab+ " $");
        String d =admindata.getDeposit()+" $";
        String w =admindata.getWithdraw()+" $";
        ldeposit.setText(d);
        lwithdraw.setText(w);

    }

}