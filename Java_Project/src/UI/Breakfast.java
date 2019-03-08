/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import UI.MainMenu;

/**
 *
 * @author asus
 */
public class Breakfast {
    public static void start() {
        GridPane allMenuForm = new GridPane();
        allMenuForm.setAlignment(Pos.CENTER);
        
        //Just something to put in the form
        Button backBtn = new Button("Back");
        allMenuForm.add(backBtn,0,0);
   
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {

            }
        });
        
        //Create the scene
        Scene myScene = new Scene(allMenuForm,800,650);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Breakfast");
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
    
    
}
