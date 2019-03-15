/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import UI.Breakfast;
import UI.HotMeal;

/**
 *
 * @author ciara
 */
public class MainMenu extends Application {
    
    @Override
    public void start(Stage primaryStage) {
               
        
         //define our controls and some of their properities
         //Button for breakfast
        Image image = new Image(getClass().getResourceAsStream("breakfast.jpg"));
        Button btnBreakfast = new Button();
        btnBreakfast.setGraphic(new ImageView(image));
        //btnBreakfast.setText("Breakfast");
        btnBreakfast.setStyle("-fx-font: 22 arial; -fx-base: #AC3B61;");

         //Button for Dinner
        Image image1 = new Image(getClass().getResourceAsStream("dinner.jpg"));
        Button btnDinner = new Button();
        btnDinner.setGraphic(new ImageView(image1));
        //btnDinner.setText("Dinner");
        btnDinner.setStyle("-fx-font: 22 arial; -fx-base: #AC3B61;");
        
        
        

       btnBreakfast.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //open breakfast window
                Breakfast.start();

            }
        });

         btnDinner.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                HotMeal.start();
      
            }
        });
         
         
        //use a VBOX pane and add our controls to its list of children
        VBox root = new VBox();
         root.setId("pane");
        root.getChildren().add(btnBreakfast);
        root.getChildren().add(btnDinner);

              
        //GridePane for main screen menu
        GridPane grid = new GridPane(); //Creates our gridpane
        grid.setId("pane");
        grid.setAlignment(Pos.CENTER); //Align everything to the center of our gridpane     
        grid.setVgap(10); // the Vertical gap between the grid rows
        
        
    
        grid.add(btnBreakfast, 1, 2);
        grid.add(btnDinner, 1, 3);
      Scene scene = new Scene(grid, 900, 750);
      scene.getStylesheets().addAll(this.getClass().getResource("MainCSS.css").toExternalForm());
     
    
    
      
      
      
  

        primaryStage.setTitle("Welcome to the menu!");
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
