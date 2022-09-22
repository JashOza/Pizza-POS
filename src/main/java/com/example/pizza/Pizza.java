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
    public Pizza(String size, ArrayList<String> toppings ,String dough, String crustStyle,String sauce, boolean delivery) {
        this.size = size;
        this.dough = dough;
        this.crustStyle = crustStyle;
        this.toppings = toppings;
        this.delivery = delivery;
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

    public TreeMap<String,Double> getPricesBySiza(){
        TreeMap<String,Double> sizeAndPrices = new TreeMap<>();
        sizeAndPrices.put("small",8.99);
        sizeAndPrices.put("medium",11.99);
        sizeAndPrices.put("large",16.99);
        sizeAndPrices.put("xl",22.99);
        return sizeAndPrices;
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
        double price = 0;
        //add cost to pizza size
        price += getPricesBySiza().get(size)            ;
        //add the toppings(3 free and $1.15 for each topping)
        if(toppings.size() > 3){
            price += (toppings.size()-3)*1.15;
        }
        /// delivery
        if(delivery){
            price += 5;
        }
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
