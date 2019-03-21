/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peristance;
import businessLogic.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ciano
 */
public class DataAccess {
    
   Connection conn;
   ArrayList<Meal> storedMeals;
   
   public  DataAccess(){
       try
       {
           this.conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MENU;user=root;password=root;");
       }
       catch(SQLException ex){
           System.out.println("Database Connection Errror " + ex.getMessage());
       }//end try catch
       
       this.storedMeals = new ArrayList<Meal>();
       this.loadMealsFromStorage();
   }//end constructor
   
   //Load meals from database and creates an arrayList of object from result set
   private void loadMealsFromStorage(){
       Meal meal = null;
       
       try
       {
           //Create Statement to retrieev records
           Statement sqlMeals = this.conn.createStatement();
           ResultSet rsMeals = sqlMeals.executeQuery("SELECT * FROM MEAL");
          
           while(rsMeals.next()){
               meal = new Meal();
               meal.setID(rsMeals.getInt("MEALID"));
               meal.setMealName(rsMeals.getString("TITLE"));
               meal.setContents(rsMeals.getString("CONTENTS"));
               meal.setContainsNuts(rsMeals.getBoolean("CONTAINSNUTS"));
               meal.setVegetarain(rsMeals.getBoolean("VEGETARIAN"));
               meal.setVegan(rsMeals.getBoolean("VEGAN"));
               meal.setGlutenFree(rsMeals.getBoolean("GLUTENFREE"));
               meal.setPrice(rsMeals.getFloat("PRICE"));
               meal.setCalories(rsMeals.getInt("CALORIES"));
               meal.setCategory(rsMeals.getString("CATEGORY"));
               
               this.create(meal);
           }//end while              
       }catch(SQLException ex){
            System.out.println("Error loading meals");
       }//end try catch
   }//end method
   
   private void saveMealsToStorage(){
       try
       {
           Statement sql = this.conn.createStatement();
           Meal currentMeal = null;
           
           for(int i = 0; i < this.storedMeals.size(); i++){
               currentMeal = this.storedMeals.get(i);
               
               if(currentMeal.getID() == 0){
               sql.executeUpdate("INSERT INTO MEAL (TITLE, CONTENTS, CONTAINSNUTS, VEGETARIAN, VEGAN, GLUTENFREE, PRICE, CALORIES, CATEGORY) VALUE'"
                        + currentMeal.getMealName() + "', '"
                        + currentMeal.getContents() + "', '"
                        + currentMeal.getContainsNuts() + "', '"
                        + currentMeal.getVegetarian() + "', '"
                        + currentMeal.getVegan() + "', '"
                        + currentMeal.getGlutenFree() + "', '"
                        + currentMeal.getPrice() + "', '"
                        + currentMeal.getCalories() + "', '"
                        + currentMeal.getPrice() + "', '"
                        + currentMeal.getCategory() + "'"
                        );
           }else{
                   sql.executeUpdate("UPDATE MEAL SET TITLE = '" 
                        + currentMeal.getMealName() + ", CONTENTS='"
                        + currentMeal.getContents() + ", CONTAINSNUTS='"
                        + currentMeal.getContainsNuts() + ", VEGETARIAN='"
                        + currentMeal.getVegetarian() + ", VEGAN"
                        + currentMeal.getVegan() + ", GLUTENFREE='"
                        + currentMeal.getGlutenFree() + ", PRICE"
                        + currentMeal.getPrice() + ", CALORIES"
                        + currentMeal.getCalories() + "' CATEGORY"
                        + currentMeal.getCategory()
                        + "' WHERE ID=" + currentMeal.getID());
           }//end if             
       }//end for
       }//end try
       catch(SQLException ex){
           System.out.println("Error saving meals to storage");
       }//end try catch
    }//end saveMealsToStorage method
   
   
   
   //CRUD OPERATIONS
   public void create(Meal mealInput){
       if (mealInput.getID() < 0){ //assumes db auto-increments
           try{
                          
               String sqlInsert = "INSERT INTO MEAL (TITLE, CONTENTS, CONTAINSNUTS, VEGETARIAN, VEGAN, GLUTENFREE, PRICE, CALORIES, CATEGORY) VALUEs ('"
                        + mealInput.getMealName() + "', '"
                        + mealInput.getContents() + "', '"
                        + mealInput.getContainsNuts() + "', '"
                        + mealInput.getVegetarian() + "', '"
                        + mealInput.getVegan() + "', '"
                        + mealInput.getGlutenFree() + "', '"
                        + mealInput.getPrice() + "', '"
                        + mealInput.getCalories() + "', '"
                        + mealInput.getPrice() + "', '"
                        + mealInput.getCategory() + "')";
               
               Statement sqlStmt = this.conn.createStatement();
               sqlStmt.executeUpdate(sqlInsert);
               
           }catch(SQLException ex){
                    System.out.println(ex.toString());
           }//try catch
       }//end if     
   }//end create
   
   public ArrayList<Meal> retrieve(){
      ArrayList<Meal> list = new ArrayList<Meal>();
      
      try{
          //String database ="jdbc:derby://localhost:1527/MENU;user=root;password=root;";
          //Connection conn = DriverManager.getConnection(database);
          
          //String sql = "SELECT * FROM MEAL";
          
          
        
          Statement sqlMeals = this.conn.createStatement();
          ResultSet rsMeals = sqlMeals.executeQuery("SELECT * FROM MEAL");
          
          Meal currentMeal = null;
          
           while(rsMeals.next()){
               currentMeal = new Meal();
               currentMeal.setID(rsMeals.getInt("MEALID"));
               currentMeal.setMealName(rsMeals.getString("TITLE"));
               currentMeal.setContents(rsMeals.getString("CONTENTS"));
               currentMeal.setContainsNuts(rsMeals.getBoolean("CONTAINSNUTS"));
               currentMeal.setVegetarain(rsMeals.getBoolean("VEGETARIAN"));
               currentMeal.setVegan(rsMeals.getBoolean("VEGAN"));
               currentMeal.setGlutenFree(rsMeals.getBoolean("GLUTENFREE"));
               currentMeal.setPrice(rsMeals.getFloat("PRICE"));
               currentMeal.setCalories(rsMeals.getInt("CALORIES"));
               currentMeal.setCategory(rsMeals.getString("CATEGORY"));
               
               list.add(currentMeal);
           }//end while
           conn.close();
      }catch(SQLException ex){
           System.out.println(ex.toString());
      }
      return list;
   }//end retrieve
   
   public void update(Meal mealInput){
      try{
       Statement sqlUpdateStmt = this.conn.createStatement();
       sqlUpdateStmt.executeUpdate("UPDATE MEAL SET TITLE = '" 
                        + mealInput.getMealName() + ", CONTENTS='"
                        + mealInput.getContents() + ", CONTAINSNUTS='"
                        + mealInput.getContainsNuts() + ", VEGETARIAN='"
                        + mealInput.getVegetarian() + ", VEGAN"
                        + mealInput.getVegan() + ", GLUTENFREE='"
                        + mealInput.getGlutenFree() + ", PRICE"
                        + mealInput.getPrice() + ", CALORIES"
                        + mealInput.getCalories() + "' CATEGORY"
                        + mealInput.getCategory()
                        + "' WHERE ID=" + mealInput.getID());
       conn.close();
       }catch(SQLException ex){
           System.out.println(ex.toString());
       }
   }//End update
   
   public void delete(int id){
       try{
       Statement sqlDeleteStmt = this.conn.createStatement();
       sqlDeleteStmt.executeUpdate("DELETE FROM MEAL WHERE ID = " + id);
       conn.close();
       }catch(SQLException ex){
           System.out.println(ex.toString());
       }
   }//end delete method
}//end class