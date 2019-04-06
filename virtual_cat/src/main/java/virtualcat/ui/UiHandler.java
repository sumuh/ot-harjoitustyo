/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualcat.ui;

import virtualcat.domain.Cat;

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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Susanna Muhli
 */
public class UiHandler extends Application {
    
    private String tempName;
    
    @Override
    public void init() throws Exception {
    }
    
    @Override
    public void start(Stage window) {
        
        BorderPane borderpane = new BorderPane();
        borderpane.setPadding(new Insets(20, 20, 20, 20));
        
        //luodaan näkymä jossa kissalle annetaan nimi
        
        GameWindow gameWindow = new GameWindow();
        
        
        Label nameLabel = new Label("Choose a name for your cat:");
        TextField nameField = new TextField("");
        Button nameButton = new Button("Select");
        
        nameButton.setOnAction((event) -> {
            
            //nappi tallentaa kissan nimen tiedostoon ja vaihtaa näkymän pelinäkymään
            
            tempName = nameField.getText();
            try (FileWriter nameWriter = new FileWriter(new File("nametemp.txt"))) {
                nameWriter.write(tempName);
                nameWriter.flush();
                nameWriter.close();
      
                Scene gameScene = new Scene(gameWindow.getWindow(), 300, 100);
                window.setScene(gameScene);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
        
        
        borderpane.setTop(nameLabel);
        borderpane.setCenter(nameButton);
        borderpane.setLeft(nameField);
        
        Scene nameScene = new Scene(borderpane, 300, 100);
        window.setScene(nameScene);
        
        window.show();
        
    }
    public static String getName() {
        String name = new String();
        try (Scanner scanner = new Scanner(new File("nametemp.txt"))) {
            while (scanner.hasNextLine()) {
                name = scanner.nextLine();
                System.out.println(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return name;
    }
    
}
