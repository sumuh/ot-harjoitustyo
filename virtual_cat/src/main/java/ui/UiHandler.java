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

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *Luokka luo ui:n ja käsittelee näkymän vaihtamista aloitusmenusta nimenluontinäkymään tai pelinäkymään.
 */
public class UiHandler extends Application {
    
    private String tempName;
    private CatService catService;
    
    /**
     * Init-metodi tarkistaa config.properties-tiedostosta oikean tiedoston nimen ja luo daon jolle nimi annetaan parametrina. Luodaan myös catService joka saa parametrina daon.
     * @throws Exception 
     */
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        ClassLoader cl = this.getClass().getClassLoader();
        try (InputStream stream = cl.getResourceAsStream("config.properties")) {
           properties.load(stream);
        }
        String filename = properties.getProperty("catfile");
        FileCatDao catDao = new FileCatDao(filename);
        this.catService = new CatService(catDao);
    }
    
    /**
     * Hoitaa näkymien luomisen ja niiden välillä vaihtamisen nappeja painamalla.
     * @param window ikkuna jossa näkymän näytetään
     * @throws Exception 
     */
    @Override
    public void start(Stage window) throws Exception {
        
        BorderPane borderpane = new BorderPane();
        borderpane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        borderpane.setPadding(new Insets(10, 10, 10, 10));
        
        Button continueGame = new Button("Continue game");
        Button newCat = new Button("Create new cat");
        Label errormessage = new Label("");
        
        continueGame.setOnAction((event) -> {
            
            if (catService.getCurrentCat() == null) {
                errormessage.setText("Error: no existing cat");
            } else {
                GameWindow gameWindow = new GameWindow();
                Scene gameScene;
                try {
                    gameScene = new Scene(gameWindow.getWindow(this.catService), 400, 300);
                    window.setScene(gameScene);
                } catch (Exception ex) {
                    Logger.getLogger(UiHandler.class.getName()).log(Level.SEVERE, null, ex);
                }


                window.setTitle("Virtual cat");
                window.show();
            }
    
        });
        
        newCat.setOnAction((event) -> {
            
            BorderPane borderpane2 = new BorderPane();
            borderpane2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            borderpane2.setPadding(new Insets(20, 20, 20, 20));
        
            Label nameLabel = new Label("Choose a name for your cat:");
            TextField nameField = new TextField("");
            Button nameButton = new Button("Select");
            nameButton.setDefaultButton(true);
            
            nameButton.setOnAction((event2) -> {
                tempName = nameField.getText();

                try {
                    catService.create(tempName);
                    GameWindow gameWindow = new GameWindow();
                    Scene gameScene = new Scene(gameWindow.getWindow(this.catService), 400, 300);
                    window.setScene(gameScene);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            
            });
        
            borderpane2.setTop(nameLabel);
            borderpane2.setCenter(nameButton);
            borderpane2.setLeft(nameField);
            
            Scene nameScene = new Scene(borderpane2, 300, 100);
            window.setScene(nameScene);

            window.setTitle("Virtual cat");
            window.show();
        });
        
        VBox startMenu = new VBox(); 
        startMenu.setSpacing(10);
        startMenu.getChildren().add(continueGame);
        startMenu.getChildren().add(newCat);
        startMenu.getChildren().add(errormessage);
        borderpane.setCenter(startMenu);
        Scene startScene = new Scene(borderpane, 300, 100);
        window.setScene(startScene);
        
        window.setTitle("Virtual cat");
        window.show();
        
    }
}
