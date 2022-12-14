package com.example.pizza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-pizza-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Indian Engineer's Pizza");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ArrayList<Topping> toppings = DBUtility.getToppingsFromDB();
        launch();

    }
}