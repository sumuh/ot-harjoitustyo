/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual_cat.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Susanna Muhli
 */
public class UiHandler extends Application{
    
    @Override
    public void init() throws Exception {
        
    }
    
    @Override
    public void start(Stage window) {
        
        BorderPane borderpane = new BorderPane();
        borderpane.setPadding(new Insets(10, 10, 10, 10));
        
        NameWindow nameWindow = new NameWindow();
        
        borderpane.setCenter(nameWindow.getWindow());
        
        Scene scene = new Scene(borderpane, 400, 300);
        
        window.setScene(scene);
        window.show();
        
    }
    
}
