/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;



import java.awt.Insets;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import UI.MainMenu;
import java.io.File;
import javax.imageio.ImageIO;
import UI.Option;
import javafx.stage.StageStyle;




/**
 *
 * @author Ciara
 */
public class Login {

   
    public static void start(){
        
        
        
            
        
        
        String username, password;
        username = "123";
        password = "123";
        
        //GridePane
        GridPane grid = new GridPane(); //Creates our gridpane
        grid.getStyleClass().add("grid");
       
        grid.setAlignment(Pos.CENTER); 
        grid.setHgap(5); 
        grid.setVgap(5); 
       
           //Add logo
       
        ImageView logo = new ImageView();
        
        logo.setFitWidth(500);
        logo.setFitHeight(250);
 
     
      
        grid.getChildren().addAll(logo);
       
        
        //Username
        Label lblUserName = new Label("User Name"); //Creates a new 'Label' object 
        grid.add(lblUserName, 0,2); //Adds the Label object to our GridPane
        TextField txtUsername = new TextField();
        grid.add(txtUsername, 0, 3); 
        
        
        
        //Password
        Label lblPassword = new Label("Password"); 
        grid.add(lblPassword, 0,4);
        PasswordField txtPassword = new PasswordField(); 
        grid.add(txtPassword, 0, 5); 
        
        
        
        //Text for error
        final Text ErrorText = new Text(); 
        grid.add(ErrorText, 0, 9); 
        
        //Button
        Button btn = new Button("Sign In"); 
         Button btnBack = new Button("  Back  ");
          btnBack.getStyleClass().add("backBtn");
        grid.add(btn, 0, 8); 
        grid.add(btnBack, 0, 9);

    Scene scene = new Scene(grid, 700, 700); //Create our scene, add our pane, and define dimensions.
    
     scene.getStylesheets().add("UI/MainCSS.css");
     
     
    
      Stage SecondryStage = new Stage();
      
      SecondryStage.getIcons().add(
   new Image(
      MainMenu.class.getResourceAsStream( "logoicon.png" ))); 
        SecondryStage.setScene(scene);
        SecondryStage.show();
               SecondryStage.setMaxHeight(700);

           SecondryStage.setMaxWidth(750);


    
    SecondryStage.setTitle("Log In"); //Sets the stage title
 
    
    SecondryStage.setScene(scene);// adds the scene to the stage
    SecondryStage.show(); //show the stage
    //Button Action
    
    
    btnBack.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                    SecondryStage.close();
            }
        });
    
    
    btn.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e ){
            if(txtUsername.getText().equals(username) && txtPassword.getText().equals(password)){
                ErrorText.setText("Successful Login!");
                Option.start();
                SecondryStage.close();                
                   
            }else{
                ErrorText.setText("Wrong details. Try Again.");
            }
        }      
    });
    
    }
    
}
