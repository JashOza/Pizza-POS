package com.example.pizza;

import java.util.*;

public class Pizza {
   
    private String size , dough , crustStyle;
    private ArrayList<String> toppings = new ArrayList<String>();
    private  boolean delivery;
    private double price;
    List<String> validSize = Arrays.asList("small","medium","large","xl");
    List<String> sauce = Arrays.asList("Marinara","Pesto","Garlic");
    public Pizza(){
    };
    public Pizza(String size, String dough, String crustStyle, ArrayList<String> toppings, boolean delivery, double price) {
        this.size = size;
        this.dough = dough;
        this.crustStyle = crustStyle;
        this.toppings = toppings;
        this.delivery = delivery;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    /**
     * Validate size i.e small , medium or large
     * @param size
     */
    public void setSize(String size) {
        size = size.toLowerCase().trim();

        if(validSize.contains(size))
            this.size = size;
        else
            throw new IllegalArgumentException("Valid size are :" + validSize);
    }

    public static  TreeSet<String> getMeatToppingsOptions(){
        List<String> toppings = Arrays.asList("Bacon","Sausage","Beef Crumble","Ham","Salami");
        TreeSet<String> toppingsSet = new TreeSet<>();
        toppingsSet.addAll(toppings);
        return toppingsSet;
    }
// Changes showing in GitHub-Jash Oza
    public String getDough() {
        return dough;
    }

    public void setDough(String dough){
        this.dough = dough;
    }

    public String getCrustStyle() {
        return crustStyle;
    }

    public void setCrustStyle(String crustStyle) {
        this.crustStyle = crustStyle;
    }


    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
