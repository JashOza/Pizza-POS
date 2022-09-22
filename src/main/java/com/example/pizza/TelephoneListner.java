package com.example.pizza;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TelephoneListner  implements ChangeListener<String> {
    @Override
    public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
        try{
            Integer.parseInt(oldValue);
        }catch (Exception e){
            System.out.println("Old value : " + oldValue + " New Value : "  + newValue);
        }
    }
}
