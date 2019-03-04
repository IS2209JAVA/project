/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Ciara
 */
public class Options extends Application{
        
   
    public void start(Stage SecondryStage)  {
    
    
         //define our controls and some of their properities
         //Button for breakfast
       
        Button setMenu = new Button();
        setMenu.setText("Set Menu"); 
        //btnBreakfast.setText("Breakfast");
        setMenu.setStyle("-fx-font: 22 arial; -fx-base: #edc7b7;");

         //Button for Dinner
      Button viewMenu = new Button();
       viewMenu.setText("View Menu"); 
        //btnDinner.setText("Dinner");
        viewMenu.setStyle("-fx-font: 22 arial; -fx-base: #edc7b7;");
        
        
        

       setMenu.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                
               //button code
                
                
            }
        });
        
        
        

        
        
         viewMenu.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                
               
                //button code
                
                
                
            }
        });
        
         
        //use a VBOX pane and add our controls to its list of children
        VBox root = new VBox();
         root.setId("pane");
        root.getChildren().add(setMenu);
        root.getChildren().add(viewMenu);

              
        //GridePane for main screen menu
        GridPane grid = new GridPane(); //Creates our gridpane
        grid.setId("pane");
        grid.setAlignment(Pos.CENTER); //Align everything to the center of our gridpane     
        grid.setVgap(10); // the Vertical gap between the grid rows
        
        
    
        grid.add(setMenu, 1, 2);
        grid.add(viewMenu, 1, 3);
      Scene scene = new Scene(grid, 600, 650);
      scene.getStylesheets().addAll(this.getClass().getResource("MainCSS.css").toExternalForm());
     
    
    
      
      
      
  

        SecondryStage.setTitle("Options!");
        SecondryStage.setScene(scene);
        SecondryStage.show();

    }
     
    public static void main(String[] args) {
        launch(args);
    }
    


}

