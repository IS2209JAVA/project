/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

/**
 *
 * @author ciano
 */
public class Meal {
    //Declare properties
    private int id, calories;
    private String mealName, contents, category;
    private Boolean containsNuts, vegetarian, vegan, glutenFree;
    private float price;
    
    /*-------Create setter and getters----------*/
    //ID setter and getter
    public void setID(int id){
        if (this.id == 0){
            this.id = id;
        }
    }
    
    public int getId(){
        return id;
    }
    
    //Calories setter and getter
    public void setCalories(int calories){
       if(calories > 0){
           this.calories = calories;
       }
    }
    
    public int getCalories(){
        return calories;
    }
    
    //mealName setter and getters
    public void setMealName(String mealName){
        this.mealName = mealName;
    }
    
    public String getMealName(){
        return mealName;
    }
    
    //Contents setter and getter
    public void setContents(String contents){
        this.contents = contents;
    }
    
    public String getContents(){
        return contents;
    }
    
    //Category setter and getter
    public void setCategory(String category){
        this.category = category;
    }
    
    public String getCategory(){
        return category;
    }
    
    //containsNuts Setters and Getters
    public void setContainsNuts(Boolean containsNuts){
        this.containsNuts = containsNuts;
    }
    
    public Boolean getContainsNuts(){
        return containsNuts;
    }
    
    //vegatrain setters and getters
    public void setVegetarain(Boolean vegetarain){
        this.vegetarian = vegetarian;
    }
    
    public Boolean getVegetarian(){
        return vegetarian;
    }
    
    //vegan setter and getters
    public void setVegan(Boolean vegan){
        this.vegan = vegan;
    }
    
    public Boolean getVegan(){
        return vegan;
    }
    
    //glutenFree setters and getters
    public void setGlutenFree(Boolean glutenFree){
        this.glutenFree = glutenFree;
    }
    
    public Boolean getGlutenFree(){
        return glutenFree;
    }
    
    //Price setters and getters
    public void setPrice(float price){
        if(price > 0.0){
            this.price = price;
        }
    }  
    
    public float getPrice(){
        return price;
    }
    
    /*---Constructor---*/
    public Meal(){
        id = 0;
        calories = -1;
        mealName = "";
        contents = "";
        category = "";
        containsNuts = false;
        vegetarian = false;
        vegan = false;
        glutenFree = false;
        price = -1.0F;        
    }
    
    public Meal(int id, int calories, String mealName, String contents, String category,
            Boolean containsNuts, Boolean vegetarian, Boolean vegan, Boolean glutenFree, Float price){
        
        //Ensuring no blank item
        if(price > 0.0 && id != 0 && !mealName.equals("") && !contents.equals("") && !category.equals("")){
            this.id = id;
            this.calories = calories;
            this.category = category;
            this.mealName = mealName;
            this.contents = contents;
            this.containsNuts = containsNuts;
            this.vegetarian = vegetarian;;
            this.vegan = vegan;
            this.glutenFree = glutenFree;
            this.price = price;                    
        }
    }
    
    /*-----Class Methods-----*/
}
