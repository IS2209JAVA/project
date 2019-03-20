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
   
   public DataAccess(){
       try
       {
           this.conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MENU");
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
       mealInput.setID(0); //Id is set to 0 for protection
       this.storedMeals.add(mealInput);
       this.saveMealsToStorage(); //persist changes to database    
   }//end create
   
   public ArrayList<Meal> retrieve(){
       return this.storedMeals;
   }//end retrieve
   
   public void update(Meal mealInput){
       for(int i = 0; i < this.storedMeals.size(); i++){
           if(this.storedMeals.get(i).getID() == mealInput.getID()){
               this.storedMeals.set(i, mealInput);
               break;
           }//end if
       }//end for
       
       this.saveMealsToStorage();//Presist changes to database
   }//End update
   
   public void delete(int id){
       for(int i = 0; i < this.storedMeals.size(); i++){
           if(this.storedMeals.get(i).getID() == id){
               this.storedMeals.remove(i);
           }//end if
       }//end for
       this.saveMealsToStorage();//Persist changes to db
   }//end delete method
}//end class