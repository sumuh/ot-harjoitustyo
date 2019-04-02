/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual_cat.ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Susanna Muhli
 */
public class GameWindow {
    
    public Parent getWindow() {
        
        Label info = new Label("Your cats name: " + UiHandler.getName());
        
        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(info);
        
        return borderpane;
    }
    
}
