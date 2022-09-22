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
    private TextField randomTextField;

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

        // allow 1 at a time
        doughToggleGroup = new ToggleGroup();
        regDoughRadioButton.setToggleGroup(doughToggleGroup);
        wholeWheatRadioButton.setToggleGroup(doughToggleGroup);

        crustStyleToggleGroup = new ToggleGroup();
        regularCrustRadioButton.setToggleGroup(crustStyleToggleGroup);
        thinCrustRadioButton.setToggleGroup(crustStyleToggleGroup);
        deepDishRadioButton.setToggleGroup(crustStyleToggleGroup);

        randomTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try{
                Integer.parseInt(newValue);
            }
            catch(Exception e)
            {
                randomTextField.setText(oldValue);
            }
        });
    }




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
        //see which radio button was selected
        RadioButton doughRBSelected =   (RadioButton) doughToggleGroup.getSelectedToggle();
        RadioButton crustRBSelected = (RadioButton) crustStyleToggleGroup.getSelectedToggle();

        Pizza newPizza = new Pizza(pizzaSizeComboBox.getValue(),topping,doughRBSelected.getText(),crustRBSelected.getText(),sauceComboBox.getValue(), deliveryCheckBox.isSelected());
        costPizzaLabel.setText(String.format("$ %.2f",newPizza.getPrice()));
        double tax = newPizza.getPrice()*0.13;
        taxLabel.setText(String.format("%.2f",tax));
        double total = tax + newPizza.getPrice();
        totalLabel.setText(String.format("%.2f",total));



    }
}
