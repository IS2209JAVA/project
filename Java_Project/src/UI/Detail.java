/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import UI.AllMenu;
/**
 *
 * @author asus
 */
public class Detail {
    public static void start() {
        GridPane detailpane = new GridPane(); 
        detailpane.setAlignment(Pos.CENTER); //place everything in the center of the gridpane
        detailpane.setHgap(6); //???????
        detailpane.setVgap(6); // Place nodes in the pane 

        TextField nameTextField = new TextField();
        nameTextField.setPrefWidth(260);
        TextField categoryTextField = new TextField();
        categoryTextField.setPrefWidth(260);
        TextField contentsTextField = new TextField();
        contentsTextField.setPrefWidth(260);
        TextField priceTextField = new TextField();
        priceTextField.setPrefWidth(150);
        TextField caloriesTextField = new TextField();
        caloriesTextField.setPrefWidth(150);
        
        detailpane.add(new Label("Name:"), 0, 0);
        detailpane.add(nameTextField, 1, 0);
        detailpane.add(new Label("Category:"), 0, 1);
        detailpane.add(categoryTextField, 1, 1);
        detailpane.add(new Label("Contents:"), 0, 2);
        detailpane.add(contentsTextField, 1, 2); 
        detailpane.add(new Label("Price:"), 0, 3);
        detailpane.add(priceTextField, 1, 3); 
        detailpane.add(new Label("Calories:"), 0, 4);
        detailpane.add(caloriesTextField, 1, 4); 
        detailpane.add(new Label("ContainsNuts:"), 0, 5);
        CheckBox chkContainsNutsYes = new CheckBox("Yes");
        detailpane.add(chkContainsNutsYes, 1, 5);
        detailpane.add(new Label("Vegetrian:"), 0, 6);
        CheckBox chkVegetrianYes = new CheckBox("Yes");
        detailpane.add(chkVegetrianYes, 1, 6);
        detailpane.add(new Label("Vegan:"), 0, 7);
        CheckBox chkVeganYes = new CheckBox("Yes");
        detailpane.add(chkVeganYes, 1, 7);
        detailpane.add(new Label("GlutenFree:"), 0, 8);
        CheckBox chkGlutenFreeYes = new CheckBox("Yes");
        detailpane.add(chkGlutenFreeYes, 1, 8);
        
        Button backBtn = new Button("Back");
        detailpane.add(backBtn, 0, 10); 
        Button deleteBtn = new Button("Delet");
        detailpane.add(deleteBtn, 1, 10); 
        Button saveBtn = new Button("Save");
        detailpane.add(saveBtn, 1, 10);  
        GridPane.setHalignment(deleteBtn, HPos.CENTER); 
        GridPane.setHalignment(saveBtn, HPos.RIGHT); // Create a scene and place it in the stage 
        
        Scene scene = new Scene(detailpane,800,650); 
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Detail"); // Set the stage title 
        primaryStage.setScene(scene); // Place the scene in the stage 
        primaryStage.show(); // Display the stage 
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                AllMenu.start();
                primaryStage.close();
            }
        });
        
        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //Reference:https://o7planning.org/en/11533/opening-a-new-window-in-javafx
                
                Label messageLabel = new Label("Are you going to delete this record?");
                Button yesBtn = new Button("Yes");
                Button noBtn = new Button("No");
 
                GridPane MessageWindow = new GridPane();
                MessageWindow.setAlignment(Pos.CENTER); 
                MessageWindow.setVgap(12); // Place nodes in the pane 
                MessageWindow.add(messageLabel,0,0);
                MessageWindow.add(yesBtn,0,1);
                MessageWindow.add(noBtn,0,1);
                GridPane.setHalignment(yesBtn, HPos.LEFT); 
                GridPane.setHalignment(noBtn, HPos.RIGHT);

                Scene messageScene = new Scene(MessageWindow, 300, 100);
 
                // New window (Stage)
                Stage messageWindow = new Stage();
                messageWindow.setTitle("Information!");
                messageWindow.setScene(messageScene);

                messageWindow.show();
                
                yesBtn.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        AllMenu.start();
                        messageWindow.close();
                        primaryStage.close();
                    }
                });
                noBtn.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        messageWindow.close();
                    }
                });
                
            }
        });
        
 
        
        
        
    }
    
}
