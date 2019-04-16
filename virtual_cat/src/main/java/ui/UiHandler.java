/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Cat;
import domain.CatService;
import dao.FileCatDao;
import dao.CatDao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Susanna Muhli
 */
public class UiHandler extends Application {
    
    private String tempName;
    private CatService catService;
    
    @Override
    public void init() throws Exception {
        FileCatDao catDao = new FileCatDao();
        this.catService = new CatService(catDao);
    }
    
    @Override
    public void start(Stage window) throws Exception {
        
        BorderPane borderpane = new BorderPane();
        borderpane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        borderpane.setPadding(new Insets(20, 20, 20, 20));
        
        GameWindow gameWindow = new GameWindow();
        
        //create scene where name is given
        
        Label nameLabel = new Label("Choose a name for your cat:");
        TextField nameField = new TextField("");
        Button nameButton = new Button("Select");
        nameButton.setDefaultButton(true);
        
        nameButton.setOnAction((event) -> {
            //button saves name in file and changes scene to game scene 
            tempName = nameField.getText();
            
            try {
                catService.create(tempName);
      
                Scene gameScene = new Scene(gameWindow.getWindow(this.catService), 400, 300);
                window.setScene(gameScene);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        });
        
        borderpane.setTop(nameLabel);
        borderpane.setCenter(nameButton);
        borderpane.setLeft(nameField);
        
        Scene nameScene = new Scene(borderpane, 300, 100);
        window.setScene(nameScene);
        
        window.setTitle("Virtual cat");
        window.show();
        
    }
}
