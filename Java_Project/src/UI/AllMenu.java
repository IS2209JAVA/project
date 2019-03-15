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
import javafx.stage.Stage;
import UI.Option;
import UI.Detail;
/**
 *
 * @author asus
 */
public class AllMenu {
    public static void start() {
        GridPane allmenupane = new GridPane();
        allmenupane.setAlignment(Pos.CENTER);
        
        //Just something to put in the form
        Button backBtn = new Button("Back");
        allmenupane.add(backBtn,0,0);
        Button nextBtn = new Button("Next");
        allmenupane.add(nextBtn,1,2);
   
        //Create the scene
        Scene myScene = new Scene(allmenupane,800,650);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("AllMenu");
        primaryStage.setScene(myScene);
        primaryStage.show();
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                    Option.start();
                    primaryStage.close();
            }
        });
        
        nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                    Detail.start();
                    primaryStage.close();
            }
        });
        
    }
    
    
}
