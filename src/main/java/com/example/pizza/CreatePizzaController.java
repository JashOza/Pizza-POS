package com.example.pizza;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class CreatePizzaController implements Initializable {

    Pizza pizza = new Pizza();
    @FXML
    private CheckBox baconCheckBox;

    @FXML
    private CheckBox cornCheckBox;

    @FXML
    private Label costPizzaLabel;

    @FXML
    private RadioButton deepDishRadioButton;

    @FXML
    private CheckBox deliveryCheckBox;

    @FXML
    private CheckBox greenPepperCheckBox;

    @FXML
    private CheckBox jalapenoCheckBox;

    @FXML
    private CheckBox mushroomsCheckBox;

    @FXML
    private CheckBox olivesCheckBox;

    @FXML
    private CheckBox onionCheckBox;

    @FXML
    private CheckBox pepperoniCheckBox;

    @FXML
    private CheckBox pineappleCheckBox;

    @FXML
    private ComboBox<String> pizzaSizeComboBox;

    @FXML
    private CheckBox redPepperCheckBox;

    @FXML
    private RadioButton regDoughRadioButton;

    @FXML
    private RadioButton regularCrustRadioButton;

    @FXML
    private ComboBox<String> sauceComboBox;

    @FXML
    private CheckBox sausageCheckBox;

    @FXML
    private Label taxLabel;

    @FXML
    private RadioButton thinCrustRadioButton;

    @FXML
    private Label totalLabel;

    @FXML
    private RadioButton wholeWheatRadioButton;

    @FXML
    private VBox meatVbox;

    @FXML
    private VBox veggiesVbox;
    @FXML
    private Button submitButton;

    private  ToggleGroup doughToggleGroup, crustStyleToggleGroup;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaSizeComboBox.getItems().addAll(pizza.validSize);
        sauceComboBox.getItems().addAll(pizza.sauce);
        TreeSet<String> meats  = pizza.getMeatToppingsOptions();
        for(String meat : meats){
            meatVbox.getChildren().add(new CheckBox(meat));
        }

        doughToggleGroup = new ToggleGroup();
        regDoughRadioButton.setToggleGroup(doughToggleGroup);
        wholeWheatRadioButton.setToggleGroup(doughToggleGroup);

        crustStyleToggleGroup = new ToggleGroup();
        regularCrustRadioButton.setToggleGroup(crustStyleToggleGroup);
        thinCrustRadioButton.setToggleGroup(crustStyleToggleGroup);
        deepDishRadioButton.setToggleGroup(crustStyleToggleGroup);
    }

        // allow 1 at a time


    @FXML
    private void cretePizza(){
        ArrayList<String> topping = new ArrayList<>();
        for(Node node : veggiesVbox.getChildren()){
            // this will cast our node to checkBox
            CheckBox checkBox = (CheckBox) node;
            if(checkBox.isSelected()){
                topping.add(checkBox.getText());
            }
        }
    }
}
