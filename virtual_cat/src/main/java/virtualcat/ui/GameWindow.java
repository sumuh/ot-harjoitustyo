/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualcat.ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Susanna Muhli
 */
public class GameWindow {
    
    public Parent getWindow() {
        
        Label info = new Label(UiHandler.getName());
        
        Label hunger = new Label("Hunger: ");
        Label boredom = new Label("Boredom: ");
        Label fatigue = new Label("Fatigue: ");
        
        HBox statsHBox = new HBox();
        statsHBox.setSpacing(20);

        statsHBox.getChildren().add(hunger);
        statsHBox.getChildren().add(boredom);
        statsHBox.getChildren().add(fatigue);
        
        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(info);
        borderpane.setTop(statsHBox);
        
        return borderpane;
    }
    
}
