/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual_cat.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 *
 * @author Susanna Muhli
 */
public class NameWindow {
    
    private String tempName;
    
    public Parent getWindow() {
        
        Label nameLabel = new Label("Choose a name for your cat:");
        TextField nameField = new TextField("");
        Button nameButton = new Button("Select");
        nameButton.setOnAction((event) -> {
            tempName = nameField.getText();
        });
        
        String catName = tempName;
        
        
        BorderPane borderpane = new BorderPane();
        borderpane.setTop(nameLabel);
        borderpane.setCenter(nameButton);
        borderpane.setLeft(nameField);
        
        Scene scene = new Scene(borderpane);
     
        return borderpane;
    }
    
}
