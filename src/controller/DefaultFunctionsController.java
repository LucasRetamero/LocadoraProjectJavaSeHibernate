/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Su
 * "/view/HomeFXML.fxml"
 */
public class DefaultFunctionsController {
    
    //Chamar uma janela e fechar a anterior
    public void callWindow(String screen,String title,int width,int height,ActionEvent event){
     try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(screen));
        Scene scene = new Scene(fxmlLoader.load(),width,height);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
     }catch(IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
      }
    }
    
    //Chamar uma janela e não fechar a anterior
    public void callWindowNotClose(String screen,String title,int width,int height){
     try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(screen));
        Scene scene = new Scene(fxmlLoader.load(),width,height);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        //((Node)(event.getSource())).getScene().getWindow().hide();
     }catch(IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
      }
    }
    
    //Mensagem ao usuario
    public void mensagem(String title, String headerText, String contentText,int alert){
     Alert mss = null;
      switch(alert){
       case 1:
       mss = new Alert(Alert.AlertType.WARNING);
       break;
       case 2:
       mss = new Alert(Alert.AlertType.CONFIRMATION);
       break;
       case 3:
       mss = new Alert(Alert.AlertType.ERROR);
       break;
       case 4:
       mss = new Alert(Alert.AlertType.INFORMATION);
       break;
     }
     mss.setTitle(title);
     mss.setHeaderText(headerText);
     mss.setContentText(contentText);
     mss.showAndWait();
     }
    
    //Verificar se campos possui dados
    public static Boolean isNullOrEmpty(String... str){
     for(String st : str){
      if(st == null || st.equals(""))
       return true;
     } 
     return false;
    }
    
    //Limpar campos TextFields
    public void clearTextFields(TextField... txts){
     for(TextField txt : txts){
     txt.setText("");
     }
    }
    
    //Formatar Data
    public String formatDate(Date dateParam,int typeParam) throws ParseException{
    String outDate  = "";
    DateFormat inputFormat = null;
    DateFormat outputFormat = null;
    Date objDate = null;
    switch(typeParam){
      case 1: 
        inputFormat  = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        outputFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.US);    
      break;
      case 2:
        inputFormat  = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        outputFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.US); 
      break;
    }
    objDate = inputFormat.parse(String.valueOf(dateParam));
    outDate = outputFormat.format(objDate);
    return outDate;
    }
    
    //Realizar conversão para inserir data no componente
    public static final LocalDate  LOCAL_DATE(String dateParam){
    DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(dateParam,formatter);
    return localDate;
   }
    
   //Conveter um LocalDate to Date
    public static final Date DATA_VALUE(LocalDate dateParam){
    LocalDate localDate = dateParam;
    Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    Date date = Date.from(instant);
    return date;
    }
  
  
}
