/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import UI.SetMenu;
import UI.AllMenu;
/**
 *
 * @author asus
 */
public class Option {
    public static void start() {
        //define our controls and some of their properities
        //Button for breakfast
       
        Button setMenu = new Button();
        setMenu.setText("Set Menu"); 
        //btnBreakfast.setText("Breakfast");
        setMenu.setStyle("-fx-font: 22 arial; -fx-base: #edc7b7;");

         //Button for Dinner
        Button allMenu = new Button();
        allMenu.setText("All Menu"); 
        //btnDinner.setText("Dinner");
        allMenu.setStyle("-fx-font: 22 arial; -fx-base: #edc7b7;");
        
        
         
        //use a VBOX pane and add our controls to its list of children
        VBox root = new VBox();
        root.setId("pane");
        root.getChildren().add(setMenu);
        root.getChildren().add(allMenu);

              
        //GridePane for main screen menu
        GridPane grid = new GridPane(); //Creates our gridpane
        grid.setId("pane");
        grid.setAlignment(Pos.CENTER); //Align everything to the center of our gridpane     
        grid.setVgap(10); // the Vertical gap between the grid rows
        
        
    
        grid.add(setMenu, 1, 2);
        grid.add(allMenu, 1, 3);
        Scene scene = new Scene(grid, 900, 750);
  
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Options!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        setMenu.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                SetMenu.start();
                primaryStage.close();
            }
        });
         
        
        allMenu.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                AllMenu.start();
                primaryStage.close();
            }
        });
        
    }    
}
