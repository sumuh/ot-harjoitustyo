/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.CatService;
import java.io.File;
import java.net.URL;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Susanna Muhli
 */
public class GameWindow {
   
    CatService catService;
    
    public Parent getWindow(CatService catService) throws Exception {
        
        Label hunger = new Label("");
        Label boredom = new Label("");
        Label fatigue = new Label("");
        this.catService = catService;
        
        Label info = new Label((catService.getCurrentCat()).getName());
        
        hunger.setText("Hunger: " + (catService.getCurrentCat().getHunger()));
        boredom.setText("Boredom: " + (catService.getCurrentCat().getBoredom()));
        fatigue.setText("Fatigue: " + (catService.getCurrentCat().getFatigue()));
       
        Task hungerTask = this.createDynamicTimeTask("Hunger", 7000);
        hunger.textProperty().bind(hungerTask.messageProperty());
        Thread t2 = new Thread(hungerTask);
        t2.setName("HungerThread");
        t2.setDaemon(true);
        
        Task boredomTask = this.createDynamicTimeTask("Boredom", 4000);
        boredom.textProperty().bind(boredomTask.messageProperty());
        Thread t3 = new Thread(boredomTask);
        t3.setName("BoredomThread");
        t3.setDaemon(true);
        
        Task fatigueTask = this.createDynamicTimeTask("Fatigue", 10000);
        fatigue.textProperty().bind(fatigueTask.messageProperty());
        Thread t4 = new Thread(fatigueTask);
        t4.setName("FatigueThread");
        t4.setDaemon(true);
        

        t2.start();
        t3.start();
        t4.start();
        
        Button feed = new Button("Feed");
        Button play = new Button("Play");
        Button sleep = new Button("Sleep");
        
        feed.setOnAction((event) -> {
            try {
                catService.feed();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        
        play.setOnAction((event) -> {
            try {
                catService.play();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        
        sleep.setOnAction((event) -> {
            try {
                catService.sleep();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        
        Image image = new Image("file:src/main/resources/pixil-frame-160.png");
        ImageView iv = new ImageView(image);
        //iv.setFitWidth(150);
        iv.setPreserveRatio(true);
        
        HBox statsHBox = new HBox();
        statsHBox.setSpacing(20);

        statsHBox.getChildren().add(hunger);
        statsHBox.getChildren().add(boredom);
        statsHBox.getChildren().add(fatigue);
        
        VBox buttonsVBox = new VBox();
        buttonsVBox.setSpacing(20);
        
        buttonsVBox.getChildren().add(feed);
        buttonsVBox.getChildren().add(play);
        buttonsVBox.getChildren().add(sleep);
        
        BorderPane borderpane = new BorderPane();
        borderpane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        borderpane.setPadding(new Insets(20, 20, 20, 20));
        borderpane.setCenter(iv);
        borderpane.setBottom(info);
        borderpane.setTop(statsHBox);
        borderpane.setRight(buttonsVBox);
        
        return borderpane;
    }
    
    public Task createDynamicTimeTask(String stat, int sleepTime) {
        Task dynamicTimeTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                        while (true) {
                                if (stat.equals("Hunger")) {
                                    updateMessage("Hunger: " + catService.getCurrentCat().getHunger());
                                } else if (stat.equals("Boredom")) {
                                    updateMessage("Boredom: " + catService.getCurrentCat().getBoredom());
                                } else if (stat.equals("Fatigue")) {
                                    updateMessage("Fatigue: " + catService.getCurrentCat().getFatigue());
                                }
                                catService.raiseOneStat(stat);
                                try {
                                        Thread.sleep(sleepTime);
                                } catch (InterruptedException ex) {
                                        break;
                                }
                        }
                        return null;
                }
        };
        return dynamicTimeTask;
    }
    
    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
    
}
