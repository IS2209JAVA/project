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
import UI.Login;
import javafx.scene.shape.Circle;

/**
 *
 * @author ciara
 */
public class MainMenu extends Application {
    
    @Override
    public void start(Stage primaryStage) {
               
        
         //define our controls and some of their properities
         //Button for breakfast
       
        Button btnBreakfast = new Button();
        
       
        //btnBreakfast.setText("Breakfast");
        btnBreakfast.setStyle("-fx-font: 22 arial; -fx-base: #AC3B61;");

         //Button for Dinner
        
        Button btnDinner = new Button();
       
       
       
        //btnDinner.setText("Dinner");
        btnDinner.setStyle("-fx-font: 22 arial; -fx-base: #AC3B61;");
        
        
        
         btnBreakfast.setId("btn");
        btnDinner.setId("btn1");
        btnBreakfast.setPadding(Insets.EMPTY);
        btnDinner.setPadding(Insets.EMPTY);
        
        
        
        
        
        Image image2 = new Image(getClass().getResourceAsStream("person.png"));
        Button btnManager = new Button();
        btnManager.getStyleClass().add("backBtn");
        btnManager.setGraphic(new ImageView(image2));
        
        
        
        

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
         
         
         
         btnManager.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Login.start();
                 primaryStage.close();
      
            }
        });
         
         
        //use a VBOX pane and add our controls to its list of children
        VBox root = new VBox();
         root.setId("pane");
         
        root.getChildren().add(btnBreakfast);
        root.getChildren().add(btnDinner);
        root.getChildren().add(btnManager);

              
        //GridePane for main screen menu
        GridPane grid = new GridPane(); //Creates our gridpane
        grid.setId("pane");
        grid.add(btnManager, 1, 1);
        grid.setAlignment(Pos.CENTER); //Align everything to the center of our gridpane     
        grid.setVgap(10); // the Vertical gap between the grid rows
        
        
    
        grid.add(btnBreakfast, 1, 2);
        grid.add(btnDinner, 1, 3);
      Scene scene = new Scene(grid, 750, 750);
          primaryStage.setMaxHeight(750);

               primaryStage.setMaxWidth(700);
      scene.getStylesheets().addAll(this.getClass().getResource("MainCSS.css").toExternalForm());
     
    
    
      
      
      
  

        primaryStage.setTitle("                                                            Welcome to the menu!");
        
      primaryStage.getIcons().add(
   new Image(
      MainMenu.class.getResourceAsStream( "logoicon.png" ))); 
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}