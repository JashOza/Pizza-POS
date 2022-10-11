package com.example.pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "root";
    private static String password = "oza2108@";
    private static String connectUrl = "jdbc:mysql://127.0.0.1:3306/LAB4";


    public static ArrayList<Topping> getToppingsFromDB(){
        ArrayList<Topping> toppings = new ArrayList<>();
        String sql = "select * from topping";

        //  the try() is called "try with resources".Anything opened in it will be automatically closed when the  try block is done.
        try(
                // 1) connect to database
                Connection con = DriverManager.getConnection(connectUrl,user,password);

                //2) create a statement
                Statement statement = con.createStatement();

                // 3) use the statement to run the sql query commands
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            //4) loop to create topping objects
            while(resultSet.next()){
                int toppingID = resultSet.getInt("toppingID");
                String name = resultSet.getString("toppingName");
                String category  = resultSet.getString("category");
                Topping topping = new Topping(toppingID,    name,category);
                toppings.add(topping);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  toppings;
    }

}
