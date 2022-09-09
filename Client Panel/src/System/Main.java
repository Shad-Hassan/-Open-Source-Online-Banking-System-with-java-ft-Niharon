package System;
import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Sign_in.fxml"));
        primaryStage.setTitle("Sign in");
        primaryStage.setScene(new Scene(root, 750, 580));
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }


    public static void main(String[] args) {
        launch(args);
    }
}