/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author typem
 */
public class SplashScreen extends Application {
    @Override
    public void start(Stage stage) {
       
        Label lblLoading = new Label("Loading..."); 
        
        ProgressBar progressBar = new ProgressBar();
        //ProgressIndicator progressIndicator = new ProgressIndicator();
        
        //root.getStyleClass().add("pane");
        //root.setPadding(new Insets(10));
        //root.setHgap(10);
        //root.setVgap(10);
            
       

        
     
     
 //GridePane for main screen menu
        GridPane grid = new GridPane(); //Creates our gridpane
        grid.setId("pane");
        
       
       
        grid.setAlignment(Pos.CENTER); //Align everything to the center of our gridpane     
        grid.setVgap(10); // the Vertical gap between the grid rows
        
        grid.add(lblLoading,0,0);
        grid.add(progressBar,0,1);
        
         Scene scene = new Scene(grid, 300, 200);
        stage.initStyle(StageStyle.UNDECORATED);
        
        
        stage.setMaxHeight(750);

        stage.setMaxWidth(700);
      scene.getStylesheets().addAll(this.getClass().getResource("MainCSS.css").toExternalForm());
          
   
        

        
        //Fading the splash screen in 
        //https://www.genuinecoder.com/javafx-splash-screen-loading-screen/
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(4), grid);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        
        //Fading the splash screen out
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), grid);
       fadeOut.setFromValue(1);
       fadeOut.setToValue(0);
       fadeOut.setCycleCount(1);
 
        fadeIn.play();
 
        //After fade in, start fade out
        fadeIn.setOnFinished((e) -> {
            fadeOut.play();
               
        });
        
        
        
        
          stage.getIcons().add(
   new Image(
      SplashScreen.class.getResourceAsStream( "logoicon.png" ))); 
        stage.setScene(scene);
       stage.show();
        stage.setResizable(false);
        
        
        
        //Keeps spalshscreen open for 6 seconds
         //https://codereview.stackexchange.com/questions/174846/make-a-popup-window-that-will-stay-open-for-3-seconds/174849#174849
         PauseTransition pause = new PauseTransition(Duration.seconds(7));
            pause.setOnFinished((e) -> {
                stage.close();
                pause.playFromStart();            
            });
            
            
            
            
    
             pause.play();
             Login.start();   
              
    }
    
   

 public static void main(String[] args) {
        launch(args);
     
    }   
 }