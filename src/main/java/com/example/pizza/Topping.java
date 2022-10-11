package com.example.pizza;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Topping {
    private int toppingID;
    private String name,category;

    public Topping(int toppingID, String name, String category) {
        this.toppingID = toppingID;
        this.name = name;
        this.category = category;
    }

    public int getToppingID() {
        return toppingID;
    }

    public void setToppingID(int toppingID) {
        if(toppingID > 0 ){
            this.toppingID = toppingID;
        }else{
            throw new IllegalArgumentException("Invalid id number");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        if(!name.isBlank()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("name cannot be blank");
        }

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        List categories = Arrays.asList("dairy","veggie","meat");
        if(categories.contains(category)){
            this.category = category;
        }else{
            throw new IllegalArgumentException("Toppings must be dairy ,  or meat");
        }
    }

    public String toString(){
        return name;
    }
}
