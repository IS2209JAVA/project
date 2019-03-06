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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 *
 * @author 117331683
 */
public class Login extends Application {
    
    //while creating this class, press ALT + ENTER over errors to auto imports
    @Override
    public void start(Stage LoginStage) {
        
        String username, password;
        username = "Java";
        password = "2019";
        
        //GridePane
        GridPane grid = new GridPane(); //Creates our gridpane
        grid.setAlignment(Pos.CENTER); 
        grid.setHgap(5); 
        grid.setVgap(5); 
           //Add logo
        Image image = new Image(getClass().getResourceAsStream("logo.jpg"));
        ImageView logo = new ImageView();
        logo.setFitWidth(500);
        logo.setFitHeight(250);
        

            // create Background 
            //Background background = new Background(logo); 
       //Setting the position of the image 
        //logo.setX(50); 
        //logo.setY(25); 
 
        //BackgroundSize bs = new BackgroundSize(100, 100, true, true, true, false);
        //BackgroundImage bi = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bs);
        //Background bg = new Background(bi);
     
        logo.setImage(image);
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
        grid.add(btn, 0, 8); 
        
        //Button Action
        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e ){
                if(txtUsername.getText().equals(username) && txtPassword.getText().equals(password)){
                    ErrorText.setText("Successful Login!");
                }else{
                    ErrorText.setText("Wrong details. Try Again.");
                }
            }      
        });

    Scene scene = new Scene(grid, 500, 430); //Create our scene, add our pane, and define dimensions.
    LoginStage.setTitle("Log In"); //Sets the stage title
    LoginStage.setScene(scene);// adds the scene to the stage
    LoginStage.show(); //show the stage
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
