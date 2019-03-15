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



/**
 *
 * @author asus
 */
public class SetMenu {
    public static void start() {
        GridPane setmenupane = new GridPane();
        setmenupane.setAlignment(Pos.CENTER);
        
        //Just something to put in the form
        Button backBtn = new Button("Back");
        setmenupane.add(backBtn,0,0);
   
        
        
        //Create the scene
        Scene myScene = new Scene(setmenupane,800,650);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("SetMenu");
        primaryStage.setScene(myScene);
        primaryStage.show();
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                    Option.start();
                    primaryStage.close();
            }
        });
    }
    
}
