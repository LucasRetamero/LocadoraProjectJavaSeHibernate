/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Su
 */
public class HomeFXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML 
    private void callPageFXML(ActionEvent event){
    try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/ClienteFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 805, 480);
        Stage stage = new Stage();
        stage.setTitle("Home - Cliente");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
      }
    }
    
    @FXML
    private void callFilmeFXML(ActionEvent event){
     try{
     FXMLLoader fxmlLoader = new FXMLLoader();
     fxmlLoader.setLocation(getClass().getResource("/view/FilmeFXML.fxml"));
     Scene scene = new Scene(fxmlLoader.load(),690, 450);
     Stage stage = new Stage();
     stage.setTitle("Home - Filme");
     stage.setResizable(false);
     stage.setScene(scene);
     stage.show();
     }catch(IOException e){
     Logger logger = Logger.getLogger(getClass().getName());
     logger.log(Level.SEVERE,"Failed to create new Window.", e);
      }
    }
    
    @FXML 
    private void callAluguelFXML(ActionEvent event){
    try{
    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(getClass().getResource("/view/AluguelFXML.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    Stage stage = new Stage();
    stage.setTitle("Home - Alugar Filme");
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
    }catch(IOException e){
     Logger logger = Logger.getLogger(getClass().getName());
     logger.log(Level.SEVERE,"Failed to create new window");
    }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
}
