/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import domain.CatService;
import domain.Cat;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;

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
        
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                catService.raiseCurrentCatStats();
//                hunger.setText("Hunger: " + (catService.getCurrentCat().getHunger()));
//                boredom.setText("Boredom: " + (catService.getCurrentCat().getBoredom()));
//                fatigue.setText("Fatigue: " + (catService.getCurrentCat().getFatigue()));
//            }
//        });

//        Task dynamicTimeTask = new Task<Void>() {
//                @Override
//                protected Void call() throws Exception {
//                        while (true) {
//                                catService.raiseCurrentCatStats();
//                                hunger.setText("Hunger: " + (catService.getCurrentCat().getHunger()));
//                                boredom.setText("Boredom: " + (catService.getCurrentCat().getBoredom()));
//                                fatigue.setText("Fatigue: " + (catService.getCurrentCat().getFatigue()));
//                                try {
//                                        Thread.sleep(100);
//                                } catch (InterruptedException ex) {
//                                        break;
//                                }
//                        }
//                        return null;
//                }
//        };

        Task dynamicTimeTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                        while (true) {
                                catService.raiseCurrentCatStats();
                                updateMessage("Hunger: " + catService.getCurrentCat().getHunger());
                                try {
                                        Thread.sleep(1000);
                                } catch (InterruptedException ex) {
                                        break;
                                }
                        }
                        return null;
                }
        };
        
        hunger.textProperty().bind(dynamicTimeTask.messageProperty());
        Thread t2 = new Thread(dynamicTimeTask);
        t2.setName("Updater");
        t2.setDaemon(true);
        t2.start();
        
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
    
//    public void refreshStats() throws Exception {
//        TimerTask repeatedTask = new TimerTask() {
//            @Override
//            public void run() {
//                hunger.setText("Hunger: " + (catService.getCurrentCat().getHunger()));
//                boredom.setText("Boredom: " + (catService.getCurrentCat().getBoredom()));
//                fatigue.setText("Fatigue: " + (catService.getCurrentCat().getFatigue()));
//            }
//        };
//        TimerTask repeatedTask2 = new TimerTask() {
//            @Override
//            public void run() {
//                catService.raiseCurrentCatStats();
//            }
//        };
//        Timer timer = new Timer();
//
//        long delay  = 1000L;
//        long period = 1000L;
//        timer.scheduleAtFixedRate(repeatedTask, delay, period);
//        timer.scheduleAtFixedRate(repeatedTask2, delay, period);
//    }
    
}
